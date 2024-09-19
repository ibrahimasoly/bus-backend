package com.trabus.trabus.dto;

import com.trabus.trabus.model.Bus;
import com.trabus.trabus.model.Reserver;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassagerDto {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private Collection<Reserver> reservers;
}
