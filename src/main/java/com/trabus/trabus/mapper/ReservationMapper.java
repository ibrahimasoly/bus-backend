package com.trabus.trabus.mapper;

import com.trabus.trabus.dto.ReservationDto;
import com.trabus.trabus.model.Reserver;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    private ModelMapper modelMapper = new ModelMapper();


    public Reserver ReservationDtoToReserver(ReservationDto reservationDto){
        return modelMapper.map(reservationDto, Reserver.class);
    }

    public ReservationDto ReserverToReservationDto(Reserver resrever){
        return modelMapper.map(resrever, ReservationDto.class);
    }
}
