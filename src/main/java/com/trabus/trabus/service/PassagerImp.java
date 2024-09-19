package com.trabus.trabus.service;

import com.trabus.trabus.dto.PassagerDto;
import com.trabus.trabus.mapper.PassagerMapper;
import com.trabus.trabus.model.Passager;
import com.trabus.trabus.repository.PassagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PassagerImp implements  PassagerIn{
    private PassagerRepository passagerRepository;
    private PassagerMapper passagerMapper;
    @Override
    public List<PassagerDto> afficheAll() {
        List<Passager> passagers = passagerRepository.findAll();
        return passagers.stream().map(passagerMapper::passagerToPassaegrDto).collect(Collectors.toList());
    }

    @Override
    public PassagerDto save(PassagerDto passagerDto) {
        PassagerDto passagerDto1 = new PassagerDto();
        passagerDto1.setNom(passagerDto.getNom());
        passagerDto1.setPrenom(passagerDto.getPrenom());
        passagerDto1.setEmail(passagerDto.getEmail());
        passagerDto1.setTel(passagerDto.getTel());
        Passager passager = passagerMapper.passagerDtoToPassager(passagerDto1);
        Optional<Passager> passager1 = passagerRepository.findByEmailAndTel(passager.getEmail(), passager.getTel());
        if (passager1.isPresent()){
            return passagerMapper.passagerToPassaegrDto(passager1.get());
        }else {
        passagerRepository.save(passager);}
       Passager passager2= passagerRepository.findById(passager.getId()).get();
        return passagerMapper.passagerToPassaegrDto(passager2);
    }
}
