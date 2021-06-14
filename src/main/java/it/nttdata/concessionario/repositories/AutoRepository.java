package it.nttdata.concessionario.repositories;

import it.nttdata.concessionario.models.Auto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AutoRepository extends CrudRepository<Auto, Long> {



}
