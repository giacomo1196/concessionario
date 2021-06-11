package it.nttdata.concessionario.controllers;

import it.nttdata.concessionario.repositories.AutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerAuto {

    private final AutoRepository autoRepository;

    public ControllerAuto(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @GetMapping("/automobili")
    public String getAuto(Model model) {
        model.addAttribute("automobili", autoRepository.findAll());
        return "auto";
    }

}
