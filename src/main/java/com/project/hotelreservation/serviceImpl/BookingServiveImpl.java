package com.project.hotelreservation.serviceImpl;


import com.project.hotelreservation.model.Booking;
import com.project.hotelreservation.model.Guest;
import com.project.hotelreservation.repository.BookingRepository;
import com.project.hotelreservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
 @Service
public class BookingServiveImpl implements BookingService {
   @Autowired
   BookingRepository bookingRepository;
    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

     @Override
     public void delete(Long id) {
         bookingRepository.deleteById(id);
     }

     @Override
     public Booking findById(Long id) {
         return bookingRepository.findById(id).orElse(null);
     }


 }
