package com.trabus.trabus.service;

import com.trabus.trabus.dto.BusDto;
import com.trabus.trabus.dto.VoyageDto;

import java.util.List;

public interface BusIn {
    public List<BusDto> afficherAll();
    public void save(BusDto busDto);
}
