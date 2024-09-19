package com.trabus.trabus.repository;

import com.trabus.trabus.model.Passager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassagerRepository extends JpaRepository<Passager, Integer> {
    public Optional<Passager> findByEmailAndTel(String email,String tel);
}
