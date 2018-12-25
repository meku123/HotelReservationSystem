package com.project.hotelreservation.controller;

import com.project.hotelreservation.model.Guest;
import com.project.hotelreservation.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class GustController {
    @Autowired
    GuestService gustService;

//    @GetMapping("/guests")
//    public String gustList(Model model) {
//        Comparator<Guest> comp = (Guest g1, Guest g2) -> g1.getFname().compareTo(g2.getFname()) ;
//        List<Guest> gusts = gustService.findAll().stream().sorted(comp).collect(Collectors.toList());
//
//        model.addAttribute("gusts", gusts);
//        return "gust/list";
//    }

    @GetMapping("/addGuest")
    public String addGuest(Model model) {
        model.addAttribute("guest", new Guest());
        return "guest/new";
    }

    @PostMapping("/addGuest")
    public String addGuest(@Valid @ModelAttribute("guest") Guest guest,
                           BindingResult bindingResult, Model model, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "guest/new";
        }
        gustService.save(guest);
        redirect.addFlashAttribute("guest",guest);

        return "redirect:/guestInfo";
    }
    @GetMapping("/guestInfo")
    public String guestInfo() {
        return "guest/rooms";
    }

    @GetMapping("/loginManager")
    public String logInManager(Model model) {
        model.addAttribute("guest", new Guest());
        return "manager/new";
    }

    @PostMapping("/loginmanager")
    public String logedManager(@Valid @ModelAttribute("guest") Guest guest,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "guest/new";
        }
        gustService.save(guest);
        return "redirect:/login";
    }
    @GetMapping(value="/login")
    public String managerLogin() {
        return  "manager/login";
    }
}
