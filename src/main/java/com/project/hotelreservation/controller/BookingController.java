package com.project.hotelreservation.controller;

import com.project.hotelreservation.model.Booking;
import com.project.hotelreservation.model.Guest;
import com.project.hotelreservation.model.Room;
import com.project.hotelreservation.service.BookingService;
import com.project.hotelreservation.service.GuestService;
import com.project.hotelreservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    RoomService roomService;
    @Autowired
    GuestService guestService;

    @GetMapping("/large")
    public String large(Model model){
        List<Room> rooms  = roomService.findAll().stream()
                .filter(r -> r.getCategory().startsWith("l")|| r.getCategory().startsWith("L")).collect(Collectors.toList());
        model.addAttribute("rooms",rooms);
        return "room/large";
    }
    @GetMapping("/medium")
    public String medium(Model model){
        List<Room> rooms  = roomService.findAll().stream()
                .filter(r -> r.getCategory().startsWith("m")|| r.getCategory().startsWith("M")).collect(Collectors.toList());
        model.addAttribute("rooms",rooms);
        return "room/medium";
    }
    @GetMapping("/small")
    public String small(Model model){
        List<Room> rooms  = roomService.findAll().stream()
                .filter(r -> r.getCategory().startsWith("s")|| r.getCategory().startsWith("S")).collect(Collectors.toList());
        model.addAttribute("rooms",rooms);
        return "room/small";
    }

    @RequestMapping(value="/room/book/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model){
        model.addAttribute("room", roomService.findById(id));
        model.addAttribute("guests", guestService.findAll());
        model.addAttribute("book", new Booking());


        return "book/new";
    }

    @RequestMapping(value = "/roomBooked", method = RequestMethod.POST)
    public String booking(@Valid @ModelAttribute("book") Booking book,
                          BindingResult bindingResult, RedirectAttributes redirect, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "book/new";
        }


        bookingService.save(book);

      return "redirect:/bookedInfo";
    }


    @GetMapping("/bookedInfo")

    public String redirectedBook() {

        return "book/booked";
    }

    @GetMapping("/reserved")
    public String reserved(Model model) {
     model.addAttribute("resevedList", bookingService.findAll());
        return "book/list";
    }
    @GetMapping(value="/book/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        bookingService.delete(id);
        return "redirect:/rooms";
    }
}
