package id.co.astratech.vo;
import id.co.astratech.model.PenjualanSalon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenjualanSalonVo {

    private String idTransaksi;

    private Integer idLayanan;

    private String namaLayanan;

    private Integer hargaLayanan;

    private Integer qty;

    private Integer total;

    private Date tanggalTransaksi;

    public PenjualanSalonVo(PenjualanSalon penjualanSalon){
        this.idTransaksi = penjualanSalon.getIdTransaksi();
        this.idLayanan = penjualanSalon.getIdLayanan();
        this.qty = penjualanSalon.getQty();
        this.total = penjualanSalon.getTotal();
        this.tanggalTransaksi = penjualanSalon.getTanggalTransaksi();
    }

}
