package id.co.astratech.repository;

import id.co.astratech.model.Layanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static id.co.astratech.constant.LayananConstant.*;

@Repository
public interface LayananRepository extends JpaRepository<Layanan, Integer> {

    @Query(value = qGetAllLayanan, nativeQuery = true)
    public List<Layanan> getAllLayanan();

}
