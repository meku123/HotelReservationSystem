package com.project.hotelreservation.serviceImpl;

import com.project.hotelreservation.model.Guest;
import com.project.hotelreservation.model.Room;
import com.project.hotelreservation.repository.GuestRepository;
import com.project.hotelreservation.repository.RoomRepository;
import com.project.hotelreservation.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GustServiceImpl implements GuestService {
    @Autowired
    GuestRepository gustRepository;

    @Override
    public List<Guest> findAll() {
        return gustRepository.findAll();
    }

    @Override
    public void save(Guest guest) {
        gustRepository.save(guest);
    }

    @Override
    public void delete(Guest guest) {
        gustRepository.delete(guest);
    }

    @Override
    public Guest findById(Long id) {
        return gustRepository.findById(id).orElse(null);
    }
}
