package id.co.astratech.vo;

import id.co.astratech.model.Layanan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LayananVo {

    private Integer idLayanan;

    private String namaLayanan;

    private String deskripsi;

    private Integer harga;

    private Integer status;

    public LayananVo (Layanan layanan){
        this.idLayanan = layanan.getIdLayanan();
        this.namaLayanan = layanan.getNamaLayanan();
        this.deskripsi = layanan.getDeskripsi();
        this.harga = layanan.getHarga();
        this.status = layanan.getStatus();
    }

}
