package it.nttdata.concessionario.controllers;

import it.nttdata.concessionario.repositories.ConcessionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerIndex {

    private final ConcessionarioRepository concessionarioRepository;

    public ControllerIndex(ConcessionarioRepository concessionarioRepository) {
        this.concessionarioRepository = concessionarioRepository;
    }

    @GetMapping("/")
    public String getIndex(Model model) {

        model.addAttribute("numeroRegioni", concessionarioRepository.countRegion());
        return "index";
    }
}
