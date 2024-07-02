package id.co.astratech.rest;

import id.co.astratech.model.Layanan;
import id.co.astratech.response.DtoResponse;
import id.co.astratech.service.LayananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/layanan")
@CrossOrigin
public class LayananRest {

    @Autowired
    private LayananService layananService;

    public LayananRest (LayananService layananService){
        this.layananService = layananService;
    }

    @GetMapping("/getAllLayanan")
    public DtoResponse getAllLayanan(){
        return layananService.getAllLayanan();
    }

    @GetMapping("/getLayananById/{idLayanan}")
    public DtoResponse getLayananById(@PathVariable Integer idLayanan){
        return layananService.getLayananById(idLayanan);
    }

    @PostMapping("/saveLayanan")
    public DtoResponse createLayanan(@RequestBody Layanan layanan){
        return layananService.saveLayanan(layanan);
    }

    @PostMapping("/updateLayanan")
    public DtoResponse updateLayanan(@RequestBody Layanan layanan){
        return layananService.updateLayanan(layanan);
    }

    @PostMapping("/deleteLayanan/{idLayanan}")
    public DtoResponse deleteLayanan(@PathVariable Integer idLayanan){
        return layananService.deleteLayanan(idLayanan);
    }

}
