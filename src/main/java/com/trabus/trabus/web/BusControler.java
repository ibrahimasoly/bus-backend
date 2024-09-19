package com.trabus.trabus.web;

import com.trabus.trabus.dto.BusDto;
import com.trabus.trabus.service.BusIn;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Bus")
@CrossOrigin("*")
@AllArgsConstructor
public class BusControler {
    private BusIn bus;

    @GetMapping()
    public List<BusDto> afficherAll(){
        return bus.afficherAll();
    }

    @PostMapping()
    public void saveBus(@RequestBody BusDto busDto){
        bus.save(busDto);
    }
}
