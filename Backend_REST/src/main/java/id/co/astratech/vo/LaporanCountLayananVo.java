package id.co.astratech.vo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaporanCountLayananVo {

    private String idLayanan;

    private String namaLayanan;

    private String jumlah;

    private String totalHarga;

}
