package com.trabus.trabus.web;

import com.trabus.trabus.dto.VoyageDto;
import com.trabus.trabus.model.Voyage;
import com.trabus.trabus.service.VoyageIn;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Voyage")
@CrossOrigin("*")
@AllArgsConstructor
public class VoyageControler {
    private VoyageIn voyage;

    @GetMapping()
    public List<VoyageDto> afficheAll(){
        return voyage.afficherAll();
    }

    @GetMapping("/{id}")
    public Optional<VoyageDto> afficherVoyageById(@PathVariable int id){
        return voyage.afficherById(id);
    }

    @GetMapping("/Recherche")
    public List<VoyageDto> chercherParVilleEtDate(
            @RequestParam(name = "ville1", defaultValue = "string")String lieuDepart,
            @RequestParam(name = "ville2", defaultValue = "string")String lieuArriver){
        return voyage.chercherParVilleDate(lieuDepart, lieuArriver);
    }

    @GetMapping("/RechercheDateDepart")
    public List<VoyageDto> findByLieuDepart(@RequestParam(defaultValue = "") String lieuDepart) {
        return voyage.findByLieuDepart(lieuDepart);
    }

    @PostMapping("/{bus_id}")
    public void save(
            @RequestBody VoyageDto voyageDto,
            @PathVariable int bus_id){
        voyage.save(voyageDto, bus_id);
    }

    @PutMapping("/{lieuDepart}/{lieuArriver}")
    public void changerNbPassager(
            @PathVariable String lieuDepart,
            @PathVariable String lieuArriver,
            @RequestParam int nbpassager,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDepart){
         voyage.changerNbPassager(lieuDepart, lieuArriver, nbpassager, dateDepart);
    }
}
