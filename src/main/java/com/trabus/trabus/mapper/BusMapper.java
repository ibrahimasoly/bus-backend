package com.trabus.trabus.mapper;

import com.trabus.trabus.dto.BusDto;
import com.trabus.trabus.model.Bus;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BusMapper {
    private ModelMapper modelMapper = new ModelMapper();
    public BusDto busEnBusDto(Bus bus){
        return modelMapper.map(bus, BusDto.class);
    }
    public Bus busDtoEnBus(BusDto busDto){
        return modelMapper.map(busDto, Bus.class);
    }
}
