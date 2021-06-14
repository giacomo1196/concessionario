package it.nttdata.concessionario.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Concessionario concessionario;

    @NonNull
    @Size(min = 1)
    private String nome;

    @NonNull
    @Size(min = 1)
    private String cognome;

    private Double stipendio;

    @NonNull
    @Min(16)
    private Integer eta;

    public Dipendente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public Concessionario getConcessionario() {
        return concessionario;
    }

    public void setConcessionario(@NonNull Concessionario concessionario) {
        this.concessionario = concessionario;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @NonNull
    public String getCognome() {
        return cognome;
    }

    public void setCognome(@NonNull String cognome) {
        this.cognome = cognome;
    }

    public Double getStipendio() {
        return stipendio;
    }

    public void setStipendio(Double stipendio) {
        this.stipendio = stipendio;
    }

    @NonNull
    public Integer getEta() {
        return eta;
    }

    public void setEta(@NonNull Integer eta) {
        this.eta = eta;
    }
}
