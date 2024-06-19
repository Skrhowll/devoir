package com.dev.school.controller;

import com.dev.school.model.Airplane;
import com.dev.school.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/airplane")
public class AirplaneController {
    private final AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Airplane> airplanes = airplaneService.findAllAirplanes();
        model.addAttribute("airplanes", airplanes);
        return "airplane/list";
    }

    @GetMapping("/add")
    public String showAddAirplaneForm(Airplane airplane) {
        return "airplane/add";
    }

    @PostMapping("/add")
    public String handleAddAirplane(Airplane airplane) {
        airplaneService.saveAirplane(airplane);
        return redirectToList();
    }

    @GetMapping("/update/{id}")
    public String showUpdateAirplaneForm(@PathVariable("id") Integer id, Model model) {
        Optional<Airplane> optionalAirplane = airplaneService.findAirplaneById(id);
        if (optionalAirplane.isPresent()) {
            model.addAttribute("airplane", optionalAirplane.get());
            return "airplane/update";
        } else {
            return redirectToList();
        }
    }

    @PostMapping("/update")
    public String handleUpdateAirplane(Airplane airplane) {
        airplaneService.updateAirplane(airplane.getId(), airplane);
        return redirectToList();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        airplaneService.deleteAirplane(id);
        return redirectToList();
    }

    private String redirectToList() {
        return "redirect:/airplane/list";
    }
}
