package com.trabus.trabus.mapper;

import com.trabus.trabus.dto.VoyageDto;
import com.trabus.trabus.model.Voyage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VoyageMapper {
    private ModelMapper modelMapper= new ModelMapper();
    public Voyage voyageDtoEnVoyage(VoyageDto voyageDto){
        return modelMapper.map(voyageDto, Voyage.class);
    }
    public VoyageDto voyageEnVoyageDto(Voyage voyage){
       return modelMapper.map(voyage, VoyageDto.class);
    }
}
