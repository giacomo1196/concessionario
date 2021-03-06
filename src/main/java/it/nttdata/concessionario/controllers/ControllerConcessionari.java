package it.nttdata.concessionario.controllers;

import it.nttdata.concessionario.models.Concessionario;
import it.nttdata.concessionario.models.Regione;
import it.nttdata.concessionario.repositories.ConcessionarioRepository;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


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

    @GetMapping("/concessionario/{id}")
    public String getDettaglioConcessionario(@PathVariable("id") Long id, Model model)
    {
        Optional<Concessionario> optional = concessionarioRepository.findById(id);
        if(optional.isPresent())
        {
            Concessionario c = optional.get();
            model.addAttribute("nomeconcessionario", c.getNome());
            model.addAttribute("descrizioneconcessionario", c.getDescrizione());
        }
        else
        {
            model.addAttribute("descrizioneconcessionario", "ID non trovato");
        }

        return "dettaglioconcessionario";
    }

    @PostMapping("/addconcessionario")
    public String addConcessionario(Concessionario concessionario)
    {
        concessionarioRepository.save(concessionario);
        return "redirect:/listaconcessionari";
    }

    @GetMapping("/addconcessionario")
    public String getFormConcessionario(Model model)
    {
        model.addAttribute("regioni", Regione.values());
        return "formconcessionario";
    }
}