package id.co.astratech.constant;

public class PenjualanSalonConstant {

    public static final String qGetLastId = "SELECT MAX(idTransaksi) FROM TR_PENJUALAN_SALON  WHERE idTransaksi LIKE CONCAT(:tahun, '%')";

    public static final String qGetSumByIdLayanan =
            "SELECT " +
                    "    t.idLayanan, " +
                    "    l.NamaLayanan AS namaLayanan, " +
                    "    COUNT(*) AS jumlah, " +
                    "    SUM(l.hargaLayanan) AS totalHarga " +
                    "FROM " +
                    "    TR_PENJUALAN_SALON t " +
                    "JOIN " +
                    "    MS_LAYANAN l ON t.idLayanan = l.idLayanan " +
                    "GROUP BY " +
                    "    t.idLayanan, " +
                    "    l.NamaLayanan " +
                    "ORDER BY " +
                    "    jumlah DESC";




}
