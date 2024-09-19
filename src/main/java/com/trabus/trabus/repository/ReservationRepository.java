package com.trabus.trabus.repository;

import com.trabus.trabus.model.Reserver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reserver, Integer> {
}
