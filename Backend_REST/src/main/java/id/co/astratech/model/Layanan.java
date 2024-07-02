package id.co.astratech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "MS_LAYANAN")
@NoArgsConstructor
@AllArgsConstructor
public class Layanan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLayanan")
    private Integer idLayanan;

    @Column(name = "NamaLayanan")
    private String namaLayanan;

    @Column(name = "DeskripsiLayanan")
    private String deskripsi;

    @Column(name = "HargaLayanan")
    private Integer harga;

    @Column(name = "StatusLayanan")
    private Integer status;

}
