package com.trabus.trabus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Voyage implements Serializable {
    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDepart;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH-mm-ss")
    private Date heurDepart;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH-mm-ss")
    private Date heurArriver;
    @Column(length = 10)
    private String lieuDepart;
    @Column(length = 10)
    private String lieuArriver;
    private int nbpassager;
    @ManyToOne
    private Bus bus;
    @OneToMany(mappedBy = "voyage", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Reserver> reservers;

}
