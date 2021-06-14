package it.nttdata.concessionario.controllers.bootstrap;

import it.nttdata.concessionario.models.Auto;
import it.nttdata.concessionario.models.Concessionario;
import it.nttdata.concessionario.models.Dipendente;
import it.nttdata.concessionario.models.Regione;
import it.nttdata.concessionario.repositories.AutoRepository;
import it.nttdata.concessionario.repositories.ConcessionarioRepository;
import it.nttdata.concessionario.repositories.DipendenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class BootstrapData implements CommandLineRunner {

    private AutoRepository autoRepository;
    private ConcessionarioRepository concessionarioRepository;
    private DipendenteRepository dipendenteRepository;

    public BootstrapData(AutoRepository autoRepository, ConcessionarioRepository concessionarioRepository, DipendenteRepository dipendenteRepository) {
        this.autoRepository = autoRepository;
        this.concessionarioRepository = concessionarioRepository;
        this.dipendenteRepository = dipendenteRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Concessionario c1 = new Concessionario();
        c1.setNome("MotorVillage");
        c1.setVia("Via Roma");
        c1.setCitta("Roma");
        c1.setRegione(Regione.LAZIO);
        c1.setDescrizione("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas pellentesque justo vel lectus viverra posuere. Donec fringilla lorem at nisl tincidunt, sollicitudin dignissim sem pulvinar. Etiam efficitur fringilla tortor sit amet pharetra. Aenean et ligula neque. Nunc laoreet massa a elementum malesuada. Nam tortor ipsum, pulvinar ac ante eget, consectetur sodales sapien. Nunc commodo consectetur lorem, vitae malesuada elit venenatis eget. Nulla facilisi. In aliquam sem sit amet mauris scelerisque, quis imperdiet nulla congue. In molestie placerat felis sit amet euismod. Curabitur non orci eget magna sagittis placerat. Aliquam facilisis, urna sed maximus feugiat, magna dolor pharetra lorem, in vulputate purus nunc in tortor. Donec lobortis metus tincidunt, interdum est non, feugiat neque");

        Concessionario c2 = new Concessionario();
        c2.setNome("ValentinoAuto");
        c2.setVia("Via Padova");
        c2.setCitta("L'Aquila");
        c2.setRegione(Regione.ABRUZZO);
        c2.setDescrizione("Phasellus a rutrum metus. Proin et egestas lectus. Quisque lorem felis, luctus non diam pellentesque, feugiat imperdiet dolor. Sed non facilisis magna, eget rutrum velit. Praesent iaculis magna ut leo rhoncus facilisis. Duis non ligula a diam dapibus molestie vitae vel velit. Cras ut suscipit quam, a elementum enim. Nunc rhoncus vitae ante ut pretium. Quisque porta mollis interdum. Donec consectetur eu lorem quis cursus. Sed laoreet viverra quam. Nullam pellentesque in odio ut ullamcorper.");

        Auto a1 = new Auto();
        a1.setModello("Panda");
        a1.setPrezzo((double) 13000);
        a1.setConcessionario(c1);

        Auto a2 = new Auto();
        a2.setModello("Tipo");
        a2.setPrezzo((double) 20000);
        a2.setConcessionario(c2);

        Dipendente d1 = new Dipendente();
        d1.setNome("Mario");
        d1.setCognome("Rossi");
        d1.setEta(55);
        d1.setStipendio((double) 1500);
        d1.setConcessionario(c1);

        Dipendente d2 = new Dipendente();
        d2.setNome("Marco");
        d2.setCognome("Verdi");
        d2.setEta(30);
        d2.setStipendio((double) 1550);
        d2.setConcessionario(c2);

        c1.getListaDipendenti().add(d1);
        c2.getListaDipendenti().add(d2);

        c1.getListaAuto().add(a1);
        c2.getListaAuto().add(a2);

        concessionarioRepository.save(c1);
        concessionarioRepository.save(c2);

        autoRepository.save(a1);
        autoRepository.save(a2);

        dipendenteRepository.save(d1);
        dipendenteRepository.save(d2);

    }

}
