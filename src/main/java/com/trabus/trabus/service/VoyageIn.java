package com.trabus.trabus.service;

import com.trabus.trabus.dto.VoyageDto;
import com.trabus.trabus.model.Voyage;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface VoyageIn {
    public List<VoyageDto> afficherAll();
    Optional<VoyageDto> afficherById(int id);
    public void save(VoyageDto voyageDto, int id);
    public List<VoyageDto> chercherParVilleDate(String lieuDepart, String lieuArriver);
    List<VoyageDto> findByDateDepart(Date dateDepart);
    List<VoyageDto> findByLieuDepart(String lieuDepart);
    List<VoyageDto> findByLieuArriver(String lieuArriver);

   void changerNbPassager(String lieuDepart, String lieuArriver, int nbpassager, Date dateDepart);
}
