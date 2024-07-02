package id.co.astratech.dao.impl;

import id.co.astratech.constant.PenjualanSalonConstant;
import id.co.astratech.dao.PenjualanSalonDao;
import id.co.astratech.model.Layanan;
import id.co.astratech.model.PenjualanSalon;
import id.co.astratech.repository.LayananRepository;
import id.co.astratech.repository.PenjualanSalonRepository;
import id.co.astratech.vo.LaporanCountLayananVo;
import id.co.astratech.vo.PenjualanSalonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PenjualanSalonDaoImpl implements PenjualanSalonDao {

    @Autowired
    private PenjualanSalonRepository penjualanSalonRepository;

    @Autowired
    private LayananRepository layananRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PenjualanSalonVo> getAllSalon() {
        Iterable<PenjualanSalon> penjualanSalon = penjualanSalonRepository.findAll();
        List<PenjualanSalonVo> penjualanSalonVos = new ArrayList<>();
        for (PenjualanSalon item: penjualanSalon){
            PenjualanSalonVo penjualanSalonVo = new PenjualanSalonVo(item);

            Layanan layanan = layananRepository.findById(penjualanSalonVo.getIdLayanan()).orElse(null);
            penjualanSalonVo.setNamaLayanan(layanan.getNamaLayanan());
            penjualanSalonVo.setHargaLayanan(layanan.getHarga());
            penjualanSalonVos.add(penjualanSalonVo);
        }
        return penjualanSalonVos;
    }

    @Override
    public String getLastId(Integer tahun) {
        String lastId = null;
        lastId = penjualanSalonRepository.getLastId(tahun);
        return lastId;
    }

    @Override
    public List<LaporanCountLayananVo> getLaporanCountIdLayanan() {
        String sql = PenjualanSalonConstant.qGetSumByIdLayanan;
        List<LaporanCountLayananVo> vos = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            LaporanCountLayananVo vo = new LaporanCountLayananVo();
            vo.setIdLayanan(resultSet.getString("idLayanan"));
            vo.setNamaLayanan(resultSet.getString("namaLayanan"));
            vo.setJumlah(resultSet.getString("jumlah"));
            vo.setTotalHarga(resultSet.getString("totalHarga"));
            return vo;
        });
        return vos;
    }

    @Override
    public Integer getTotalTransaksi() {
        List<PenjualanSalon> penjualanSalonList = penjualanSalonRepository.findAll();
        Integer totalTransaksi = 0;
        for (PenjualanSalon penjualanSalon : penjualanSalonList) {
            Integer hargaTotal = penjualanSalon.getTotal();
            totalTransaksi += hargaTotal;
        }
        return totalTransaksi;
    }
}
