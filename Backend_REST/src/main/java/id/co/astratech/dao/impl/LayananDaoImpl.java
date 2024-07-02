package id.co.astratech.dao.impl;

import id.co.astratech.dao.LayananDao;
import id.co.astratech.model.Layanan;
import id.co.astratech.repository.LayananRepository;
import id.co.astratech.vo.LayananVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LayananDaoImpl implements LayananDao {

    @Autowired
    private LayananRepository layananRepository;

    @Override
    public List<LayananVo> getAllLayanan() {
        Iterable<Layanan> layanan = layananRepository.getAllLayanan();
        List<LayananVo> layananVos = new ArrayList<>();
        for (Layanan item: layanan){
            LayananVo layananVo = new LayananVo(item);
            layananVos.add(layananVo);
        }
        return layananVos;
    }
}
