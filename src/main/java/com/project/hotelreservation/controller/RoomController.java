package com.project.hotelreservation.controller;

import com.project.hotelreservation.model.Room;
import com.project.hotelreservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RoomController {
    @Autowired
    RoomService roomService;



    @GetMapping("/addRoom")
    public String addRooms(Model model) {
        model.addAttribute("room", new Room());
        return "room/new";
    }

    @PostMapping("/addRoom")
    public String addRooms(@Valid @ModelAttribute("room") Room room,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "room/new";
        }
        roomService.save(room);
        return "redirect:/rooms";
    }

    @GetMapping("/rooms")
    public String homeList(Model model) {
        Comparator<Room> comp = (Room r1, Room r2) -> r1.getCategory().compareTo(r2.getCategory()) ;
        List<Room> rooms = roomService.findAll().stream().sorted(comp).collect(Collectors.toList());

        model.addAttribute("rooms", rooms);
        return "room/list";
    }


    @GetMapping(value="/room/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        roomService.delete(id);
        return "redirect:/rooms";
    }

       @RequestMapping(value="/room/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("room", roomService.findById(id));
        return "room/new";
    }
}