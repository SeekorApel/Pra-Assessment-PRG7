package id.co.astratech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "TR_PENJUALAN_SALON")
@NoArgsConstructor
@AllArgsConstructor
public class PenjualanSalon {

    @Id
    @Column(name = "idTransaksi")
    private String idTransaksi;

    @Column(name = "idLayanan")
    private Integer idLayanan;

    @Column(name = "QtyLayanan")
    private Integer qty;

    @Column(name = "HargaTotalTransaksi")
    private Integer total;

    @Column(name = "TanggalTransaksi")
    private Date tanggalTransaksi;

}
