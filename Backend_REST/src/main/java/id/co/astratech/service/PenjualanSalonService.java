package id.co.astratech.service;

import id.co.astratech.model.PenjualanSalon;
import id.co.astratech.response.DtoResponse;
import id.co.astratech.vo.PenjualanSalonVo;

public interface PenjualanSalonService {

    public DtoResponse getAllTransaksi();

    public DtoResponse saveTransaksi(PenjualanSalon penjualanSalon);

    public DtoResponse getAllTransaksiByLayanan();

    public DtoResponse getAllTransaksiSum();

    public DtoResponse getLaporanCountByIdLayanan();

    public DtoResponse getTotalTransaksi();

}
