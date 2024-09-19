package com.trabus.trabus.mapper;

import com.trabus.trabus.dto.PassagerDto;
import com.trabus.trabus.model.Passager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PassagerMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public PassagerDto passagerToPassaegrDto(Passager passager) {
        return modelMapper.map(passager, PassagerDto.class);
    }

    public Passager passagerDtoToPassager(PassagerDto passagerDto){
        return modelMapper.map(passagerDto, Passager.class);
    }
}
