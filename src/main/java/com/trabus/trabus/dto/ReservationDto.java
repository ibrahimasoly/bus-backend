package com.trabus.trabus.dto;

import com.trabus.trabus.model.Passager;
import com.trabus.trabus.model.Voyage;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class ReservationDto {
    private int id;
    private Date date;
    private Voyage voyage;
    private Passager passager;
}
