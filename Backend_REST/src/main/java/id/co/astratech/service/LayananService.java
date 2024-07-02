package id.co.astratech.service;

import id.co.astratech.model.Layanan;
import id.co.astratech.response.DtoResponse;

public interface LayananService {

    public DtoResponse getAllLayanan();

    public DtoResponse getLayananById(Integer idLayanan);

    public DtoResponse saveLayanan(Layanan layanan);

    public DtoResponse deleteLayanan(Integer idLayanan);

    public DtoResponse updateLayanan(Layanan layanan);

}
