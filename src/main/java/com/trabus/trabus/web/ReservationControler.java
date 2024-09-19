package com.trabus.trabus.web;

import com.trabus.trabus.model.Reserver;
import com.trabus.trabus.service.ReservationIn;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Reserver")
@AllArgsConstructor
public class ReservationControler {
    ReservationIn reservation;

    @GetMapping()
    public List<Reserver> afficherAll(){
        return reservation.afficherAll();
    }

    @GetMapping("/{idVoyage}/{idPassager}")
    public void reserver(@PathVariable int idVoyage, @PathVariable int idPassager){
        reservation.reserver(idVoyage,idPassager);
    }
}
