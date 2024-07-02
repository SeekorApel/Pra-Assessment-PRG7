package id.co.astratech.repository;

import id.co.astratech.model.PenjualanSalon;
import id.co.astratech.vo.LaporanCountLayananVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static id.co.astratech.constant.PenjualanSalonConstant.*;

@Repository
public interface PenjualanSalonRepository extends JpaRepository<PenjualanSalon, String> {

    @Query(value = qGetLastId, nativeQuery = true)
    public String getLastId(@Param("tahun") Integer tahun);

}
