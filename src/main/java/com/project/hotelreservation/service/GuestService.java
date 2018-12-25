package com.project.hotelreservation.service;

import com.project.hotelreservation.model.Guest;
import com.project.hotelreservation.model.Room;

import java.util.List;

public interface GuestService {
    List<Guest> findAll();
    void save(Guest guest);
    void delete(Guest guest);
    Guest findById(Long id);
}
