package it.nttdata.concessionario.repositories;

import it.nttdata.concessionario.models.Concessionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ConcessionarioRepository extends CrudRepository<Concessionario, Long> {


    @Query("SELECT COUNT(DISTINCT( c.regione)) FROM Concessionario c")
    Integer countRegion();

}
