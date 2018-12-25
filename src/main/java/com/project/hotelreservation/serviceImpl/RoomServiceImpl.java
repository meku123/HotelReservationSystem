package com.project.hotelreservation.serviceImpl;

import com.project.hotelreservation.model.Guest;
import com.project.hotelreservation.model.Room;
import com.project.hotelreservation.repository.RoomRepository;
import com.project.hotelreservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public void save(Room room) {

        roomRepository.save(room);
    }

    @Override
    public void delete(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }
}
