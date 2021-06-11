package it.nttdata.concessionario.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Concessionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Size(min = 1)
    private Regione regione;

    @OneToMany(mappedBy = "concessionario")
    private Set<Dipendente> listadipendente;


    public Concessionario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Regione getRegione() {
        return regione;
    }

    public void setRegione(Regione regione) {
        this.regione = regione;
    }

    public Set<Dipendente> getListadipendente() {
        return listadipendente;
    }

    public void setListadipendente(Set<Dipendente> listadipendente) {
        this.listadipendente = listadipendente;
    }
}
