package com.project.hotelreservation.service;

import com.project.hotelreservation.model.Guest;
import com.project.hotelreservation.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    void save(Room room);
    void delete(Long id);
    Room findById(Long id);
}
