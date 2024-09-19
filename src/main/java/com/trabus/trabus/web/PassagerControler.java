package com.trabus.trabus.web;

import com.trabus.trabus.dto.PassagerDto;
import com.trabus.trabus.service.PassagerIn;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Passager")
@CrossOrigin("*")
@AllArgsConstructor
public class PassagerControler {
    private PassagerIn passager;

    @GetMapping()
    public List<PassagerDto> afficheAll(){
        return passager.afficheAll();
    }

    @PostMapping()
    public PassagerDto save(@RequestBody PassagerDto passagerDto){
       return passager.save(passagerDto);
    }
}
