package it.nttdata.concessionario.controllers;

import it.nttdata.concessionario.models.Auto;
import it.nttdata.concessionario.repositories.AutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class ControllerAuto {

    private AutoRepository autoRepository;

    public ControllerAuto(AutoRepository autoRepository) {

        this.autoRepository = autoRepository;
    }


    @GetMapping("/listaauto")
    public String getAllAutomobili(Model model) {
        model.addAttribute("listaAutomobili", autoRepository.findAll());

        return "listaauto";
    }

    @GetMapping("/listaautoconcessionario/{nomeConcessionario}")
    public String getListaAutoConcessionario(Model model, @PathVariable("nomeConcessionario") String nomeConcessionario) {
         List<Auto> listaAuto = new ArrayList<Auto>((Collection<? extends Auto>) autoRepository.findAll());
         List<Auto> listaAutoFiltrate = new ArrayList<Auto>();
         for(int i = 0; i<listaAuto.size(); i++)
        {
            Auto a = listaAuto.get(i);
            if(a.getConcessionario().getNome() == nomeConcessionario)
            {
                listaAutoFiltrate.add(a);
            }
        }
         model.addAttribute("listaAutomobili", listaAutoFiltrate);
        return "listaauto";
    }

}
