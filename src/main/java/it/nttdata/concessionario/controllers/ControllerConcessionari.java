package it.nttdata.concessionario.controllers;

import it.nttdata.concessionario.repositories.ConcessionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ControllerConcessionari {

    private ConcessionarioRepository concessionarioRepository;

    public ControllerConcessionari (ConcessionarioRepository concessionarioRepository) {
        this.concessionarioRepository = concessionarioRepository;
    }

    @GetMapping("/listaconcessionari")
    public String getAllConcessionari(Model model) {

        model.addAttribute("listaConcessionari", concessionarioRepository.findAll());
        return "listaconcessionari";
    }
}