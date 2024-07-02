package id.co.astratech.dao;

import id.co.astratech.model.PenjualanSalon;
import id.co.astratech.vo.LaporanCountLayananVo;
import id.co.astratech.vo.PenjualanSalonVo;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface PenjualanSalonDao {

    public List<PenjualanSalonVo> getAllSalon();

    public String getLastId(Integer tahun);

    public List<LaporanCountLayananVo> getLaporanCountIdLayanan();

    public Integer getTotalTransaksi();

}
