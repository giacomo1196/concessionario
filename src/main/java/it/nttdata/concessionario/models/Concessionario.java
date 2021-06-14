package it.nttdata.concessionario.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Concessionario {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Size(min = 1)
    private String nome;

    @NonNull
    @Size(min = 1)
    private String via;

    @NonNull
    @Size(min = 1)
    private String citta;

    @NonNull
    private Regione regione;

    @OneToMany(mappedBy = "concessionario")
    private Set<Dipendente> listaDipendenti = new HashSet<>();

    @OneToMany(mappedBy = "concessionario")
    private Set<Auto> listaAuto = new HashSet<>();

    @Column(length = 1000)
    private String descrizione;

    public String getUrlDettaglio() {
        return "/concessionario/" +id.toString();
    }

}