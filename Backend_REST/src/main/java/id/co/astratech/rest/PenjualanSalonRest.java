package id.co.astratech.rest;

import id.co.astratech.model.PenjualanSalon;
import id.co.astratech.response.DtoResponse;
import id.co.astratech.service.PenjualanSalonService;
import id.co.astratech.vo.PenjualanSalonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penjualan")
@CrossOrigin
public class PenjualanSalonRest {

    @Autowired
    private PenjualanSalonService penjualanSalonService;

    public PenjualanSalonRest (PenjualanSalonService penjualanSalonService){
        this.penjualanSalonService = penjualanSalonService;
    }

    @GetMapping("/getAllTransaksi")
    public DtoResponse getAllTransaksi(){
        return penjualanSalonService.getAllTransaksi();
    }

    @GetMapping("/getAllLaporanCountByIdLayanan")
    public DtoResponse getLaporanCountByIdLayanan(){
        return penjualanSalonService.getLaporanCountByIdLayanan();
    }

    @GetMapping("/getTotalTransaksi")
    public DtoResponse getTotalTransaksi(){
        return penjualanSalonService.getTotalTransaksi();
    }

    @PostMapping("/saveTransaksi")
    public DtoResponse saveTransaksi(@RequestBody PenjualanSalon penjualanSalon){
        return penjualanSalonService.saveTransaksi(penjualanSalon);
    }

}
