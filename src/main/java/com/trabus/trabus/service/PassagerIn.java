package com.trabus.trabus.service;

import com.trabus.trabus.dto.PassagerDto;

import java.util.List;

public interface PassagerIn {
    public List<PassagerDto> afficheAll();
    public PassagerDto save(PassagerDto passagerDto);
}
