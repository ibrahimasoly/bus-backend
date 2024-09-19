package com.trabus.trabus.dto;

import com.trabus.trabus.model.Voyage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusDto {
    private String matricule;
    private String marque;
    private int prix;
    private int capasite;
    private Collection<Voyage> voyage;
}
