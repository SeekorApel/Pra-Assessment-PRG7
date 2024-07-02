package id.co.astratech.service.impl;

import id.co.astratech.dao.LayananDao;
import id.co.astratech.model.Layanan;
import id.co.astratech.repository.LayananRepository;
import id.co.astratech.response.DtoResponse;
import id.co.astratech.service.LayananService;
import id.co.astratech.vo.LayananVo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
@Transactional
public class LayananServiceImpl implements LayananService {


    @Autowired
    private LayananDao layananDao;

    @Autowired
    private LayananRepository layananRepository;

    @Override
    public DtoResponse getAllLayanan() {
        List<LayananVo> data = layananDao.getAllLayanan();
        if(data != null){
            return new DtoResponse(200, data, "Sukses");
        }else {
            return new DtoResponse(500, null, "Error saat mengambil data");
        }

    }

    @Override
    public DtoResponse getLayananById(Integer idLayanan) {
        Layanan data = layananRepository.findById(idLayanan).orElse(null);
        if(data != null){
            return new DtoResponse(200, data, "Sukses mengambil data");
        }else {
            return new DtoResponse(500, null, "Gagal pada saat mengambil data");
        }
    }

    @Override
    public DtoResponse saveLayanan(Layanan layanan) {
        try {
            layanan.setStatus(1);
            layananRepository.save(layanan);
            return new DtoResponse(200, layanan, "Sukes Menyimpan data");
        }catch (Exception e){
            return new DtoResponse(500, layanan, "Gagal Menyimpan Data");
        }
    }

    @Override
    public DtoResponse updateLayanan(Layanan updateLayanan) {
        Layanan layananDB = layananRepository.findById(updateLayanan.getIdLayanan()).orElse(null);
        try {
            if(layananDB != null){
                copyNonNullProperties(updateLayanan, layananDB);
                layananRepository.save(layananDB);
                return new DtoResponse(200, layananDB, "Sukses Mengupdate data");
            }
        } catch (Exception e) {
            return new DtoResponse(500, null, e.getMessage());
        }
        return new DtoResponse(500, null, "Terjadi Kesalahan Mengupdate Data");
    }

    @Override
    public DtoResponse deleteLayanan(Integer idLayanan) {
        Layanan deleteLayanan = layananRepository.findById(idLayanan).orElse(null);
        try {
            if(deleteLayanan!=null){
                deleteLayanan.setStatus(0);
                layananRepository.save(deleteLayanan);
                return new DtoResponse(200, deleteLayanan, "Sukses Menghapus data");
            }
        }catch (Exception e){
            return new DtoResponse(500, null, e.getMessage());
        }
        return new DtoResponse(500, null, "Terjadi Kesalahan Saat Menghapus Data");
    }

    public static void copyNonNullProperties(Object source, Object target) {
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(source);
                if (value != null) {
                    field.set(target, value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
