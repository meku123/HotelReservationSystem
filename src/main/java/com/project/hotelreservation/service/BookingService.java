package com.project.hotelreservation.service;

import com.project.hotelreservation.model.Booking;


import java.util.List;

public interface BookingService {
    void save(Booking booking);
    List<Booking> findAll();
    void delete(Long id);
    Booking findById(Long id);
}
