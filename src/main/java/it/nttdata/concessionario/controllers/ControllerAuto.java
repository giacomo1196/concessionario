package it.nttdata.concessionario.controllers;

import it.nttdata.concessionario.models.Auto;
import it.nttdata.concessionario.repositories.AutoRepository;
import it.nttdata.concessionario.repositories.ConcessionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class ControllerAuto {

    private final AutoRepository autoRepository;
    private final ConcessionarioRepository concessionarioRepository;



    public ControllerAuto(AutoRepository autoRepository, ConcessionarioRepository concessionarioRepository) {

        this.autoRepository = autoRepository;
        this.concessionarioRepository = concessionarioRepository;
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

    @GetMapping("/addauto")
    public String getForm(Model model)
    {
        model.addAttribute("concessionarie", concessionarioRepository.findAll());
        return "formauto";
    }

    @PostMapping("/addauto")
    public String addAuto(Auto auto)
    {
        autoRepository.save(auto);
        return "redirect:/listaauto";
    }

}
