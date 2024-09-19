package com.trabus.trabus.repository;

import com.trabus.trabus.model.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Integer> {
    List<Voyage> findByLieuDepartAndLieuArriver(String lieuDepart, String lieuArriver);
    List<Voyage> findByDateDepart(Date dateDepart);
    List<Voyage> findByLieuDepart(String lieuDepart);
    List<Voyage> findByLieuArriver(String lieuArriver);

}
