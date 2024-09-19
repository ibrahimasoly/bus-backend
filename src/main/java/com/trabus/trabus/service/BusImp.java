package com.trabus.trabus.service;

import com.trabus.trabus.dto.BusDto;
import com.trabus.trabus.dto.VoyageDto;
import com.trabus.trabus.mapper.BusMapper;
import com.trabus.trabus.mapper.VoyageMapper;
import com.trabus.trabus.model.Bus;
import com.trabus.trabus.model.Voyage;
import com.trabus.trabus.repository.BusRepository;
import com.trabus.trabus.repository.VoyageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BusImp implements BusIn{
    private BusRepository busRepository;
    private BusMapper busMapper;
    private VoyageRepository voyageRepository;
    private VoyageMapper voyageMapper;

    @Override
    public List<BusDto> afficherAll() {
        List<Bus> bus = busRepository.findAll();
        return bus.stream().map(busMapper::busEnBusDto).collect(Collectors.toList());
    }

    @Override
    public void save(BusDto busDto) {
        BusDto busDto1 = new BusDto();
        busDto1.setMatricule(busDto.getMatricule());
        busDto1.setMarque(busDto.getMarque());
        busDto1.setCapasite(busDto.getCapasite());
        busDto1.setPrix(busDto.getPrix());
        Bus bus = busMapper.busDtoEnBus(busDto1);
        busRepository.save(bus);
    }
}
