package id.co.astratech.service.impl;

import id.co.astratech.dao.PenjualanSalonDao;
import id.co.astratech.model.Layanan;
import id.co.astratech.model.PenjualanSalon;
import id.co.astratech.repository.LayananRepository;
import id.co.astratech.repository.PenjualanSalonRepository;
import id.co.astratech.response.DtoResponse;
import id.co.astratech.service.PenjualanSalonService;
import id.co.astratech.vo.LaporanCountLayananVo;
import id.co.astratech.vo.LayananVo;
import id.co.astratech.vo.PenjualanSalonVo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PenjualanSalonServiceImpl implements PenjualanSalonService {

    @Autowired
    private PenjualanSalonDao penjualanSalonDao;

    @Autowired
    private PenjualanSalonRepository penjualanSalonRepository;

    @Autowired
    private LayananRepository layananRepository;

    @Override
    public DtoResponse getAllTransaksi() {
        List<PenjualanSalonVo> data = penjualanSalonDao.getAllSalon();
        if(data != null){
            return new DtoResponse(200, data, "Sukses");
        }else {
            return new DtoResponse(500, null, "Error saat mengambil data");
        }
    }

    @Override
    public DtoResponse saveTransaksi(PenjualanSalon penjualanSalon) {
        try {
            Layanan layanan = layananRepository.findById(penjualanSalon.getIdLayanan()).orElse(null);
            penjualanSalon.setTotal(penjualanSalon.getQty() * layanan.getHarga());
            penjualanSalon.setIdTransaksi(getIdTransaksi());
            penjualanSalon.setTanggalTransaksi(new Date());
            penjualanSalonRepository.save(penjualanSalon);
            return new DtoResponse(200, penjualanSalon, "Sukes Menyimpan data");
        }catch (Exception e){
            return new DtoResponse(500, penjualanSalon, "Gagal Menyimpan Data");
        }
    }

    @Override
    public DtoResponse getAllTransaksiByLayanan() {
        return null;
    }

    @Override
    public DtoResponse getAllTransaksiSum() {
        return null;
    }

    private String getIdTransaksi(){
        Integer tahunSekarang = Calendar.getInstance().get(Calendar.YEAR);
        String tahunString = String.valueOf(tahunSekarang);

        // Mendapatkan nomor urut terakhir
        String lastId = penjualanSalonRepository.getLastId(tahunSekarang);
        int newIncrement = 1;

        if (lastId != null) {
            String lastIncrementStr = lastId.substring(4);
            newIncrement = Integer.parseInt(lastIncrementStr) + 1;
        }

        String newNomorTransaksi = String.format("%s%04d", tahunString, newIncrement);

        return newNomorTransaksi;
    }

    @Override
    public DtoResponse getLaporanCountByIdLayanan() {
        List<LaporanCountLayananVo> data = penjualanSalonDao.getLaporanCountIdLayanan();
        return new DtoResponse(200, data, "Sukses");
    }

    @Override
    public DtoResponse getTotalTransaksi() {
        Integer total = penjualanSalonDao.getTotalTransaksi();
        return new DtoResponse(200, total, "Sukses");
    }
}
