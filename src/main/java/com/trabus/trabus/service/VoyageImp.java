package com.trabus.trabus.service;

import com.trabus.trabus.dto.VoyageDto;
import com.trabus.trabus.mapper.VoyageMapper;
import com.trabus.trabus.model.Bus;
import com.trabus.trabus.model.Voyage;
import com.trabus.trabus.repository.BusRepository;
import com.trabus.trabus.repository.VoyageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class VoyageImp implements VoyageIn{
    private VoyageRepository voyageRepository;
    private BusRepository busRepository;
    private VoyageMapper voyageMapper;
    @Override
    public List<VoyageDto> afficherAll() {
        List<Voyage> voyages = voyageRepository.findAll();
        return voyages.stream().map(voyageMapper::voyageEnVoyageDto).collect(Collectors.toList());
    }

    @Override
    public Optional<VoyageDto> afficherById(int id) {
        Optional<Voyage> voyage = voyageRepository.findById(id);
        VoyageDto voyageDto = voyageMapper.voyageEnVoyageDto(voyage.get());
        return Optional.ofNullable(voyageDto);
    }

    @Override
    public void save(VoyageDto voyageDto, int bus_id) {
        VoyageDto voyageDto1= new VoyageDto();
        voyageDto1.setDateDepart(voyageDto.getDateDepart());
        voyageDto1.setHeurDepart(voyageDto.getHeurDepart());
        voyageDto1.setHeurArriver(voyageDto.getHeurArriver());
        voyageDto1.setLieuDepart(voyageDto.getLieuDepart());
        voyageDto1.setLieuArriver(voyageDto.getLieuArriver());
        voyageDto1.setNbpassager(voyageDto.getNbpassager());
        Bus bus = busRepository.findById(bus_id).orElse(null);
        voyageDto1.setBus(bus);
        Voyage voyage = voyageMapper.voyageDtoEnVoyage(voyageDto1);
        voyageRepository.save(voyage);
    }

    @Override
    public List<VoyageDto> chercherParVilleDate(String lieuDepart, String lieuArriver) {
       List<Voyage>  v= voyageRepository.findByLieuDepartAndLieuArriver(lieuDepart, lieuArriver);
        return v.stream().map(voyageMapper::voyageEnVoyageDto).collect(Collectors.toList());
    }

    @Override
    public List<VoyageDto> findByDateDepart(Date dateDepart) {
        List<Voyage>  v = voyageRepository.findByDateDepart(dateDepart);
        return v.stream().map(voyageMapper::voyageEnVoyageDto).collect(Collectors.toList());
    }

    @Override
    public List<VoyageDto> findByLieuDepart(String lieuDepart) {
        List<Voyage> v = voyageRepository.findByLieuDepart(lieuDepart);
        return v.stream().map(voyageMapper::voyageEnVoyageDto).collect(Collectors.toList());
    }

    @Override
    public List<VoyageDto> findByLieuArriver(String lieuArriver) {
        List<Voyage> v = voyageRepository.findByLieuArriver(lieuArriver);
        return v.stream().map(voyageMapper::voyageEnVoyageDto).collect(Collectors.toList());
    }

    @Override
    public void changerNbPassager(String lieuDepart, String lieuArriver, int nbpassager, Date dateDepart) {
        List<Voyage> voyages = voyageRepository.findByLieuDepartAndLieuArriver(lieuDepart, lieuArriver);
       for (int i = 0; i < voyages.size(); i++){
           Voyage v = voyages.get(i);
           v.setNbpassager(nbpassager);
           v.setDateDepart(dateDepart);
           voyageRepository.save(v);
       }
    }


}
