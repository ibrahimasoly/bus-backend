package com.trabus.trabus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Bus implements Serializable {
    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private String matricule;
    private String marque;
    private int prix;
    private int capasite;
    @OneToMany(mappedBy = "bus", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Voyage> voyage;
}
