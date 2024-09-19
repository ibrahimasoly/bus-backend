package com.trabus.trabus.service;

import com.trabus.trabus.model.Reserver;

import java.util.List;

public interface ReservationIn {
    public void reserver(int idVoyage, int idPassager);
    public List<Reserver> afficherAll();
}
