package com.trabus.trabus.service;

import com.trabus.trabus.dto.ReservationDto;
import com.trabus.trabus.dto.VoyageDto;
import com.trabus.trabus.mapper.PassagerMapper;
import com.trabus.trabus.mapper.ReservationMapper;
import com.trabus.trabus.mapper.VoyageMapper;
import com.trabus.trabus.model.Passager;
import com.trabus.trabus.model.Reserver;
import com.trabus.trabus.model.Voyage;
import com.trabus.trabus.repository.PassagerRepository;
import com.trabus.trabus.repository.ReservationRepository;
import com.trabus.trabus.repository.VoyageRepository;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationImp implements ReservationIn{
    ReservationRepository reservationRepository;
    VoyageRepository voyageRepository;
    PassagerRepository passagerRepository;
    VoyageMapper voyageMapper;
    PassagerMapper passagerMapper;
    ReservationMapper reservationMapper;



    @Override
    public void reserver(int idVoyage, int idPassager) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setDate(new Date());
       Optional<Voyage> voyage = voyageRepository.findById(idVoyage);
        Optional<Passager> passager = passagerRepository.findById(idPassager);
        reservationDto.setVoyage(voyage.get());
        reservationDto.setPassager(passager.get());
        if (voyage != null && passager != null) {
            Reserver reserver = reservationMapper.ReservationDtoToReserver(reservationDto);
                reservationRepository.save(reserver);
        } else {
         System.out.println("n'exist pas");   // Gérer les cas où le voyage ou le passager n'existe pas
        }
    }

    @Override
    public List<Reserver> afficherAll() {
        return reservationRepository.findAll();
    }
}
