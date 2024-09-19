package com.trabus.trabus.dto;

import com.trabus.trabus.model.Bus;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class VoyageDto {
    private int id;
    private Date dateDepart;
    private Date heurDepart;
    private Date heurArriver;
    private String lieuDepart;
    private String lieuArriver;
    private int nbpassager;
    private Bus bus;
}
