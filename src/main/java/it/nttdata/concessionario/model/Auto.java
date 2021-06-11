package it.nttdata.concessionario.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Size(min = 1)
    private  String modello;
    private Double prezzo;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "concessionario_id")
    private  Concessionario concessionario;

    public Auto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getModello() {
        return modello;
    }

    public void setModello(@NonNull String modello) {
        this.modello = modello;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }
}
