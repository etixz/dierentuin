package eb.egonb.dierentuin.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BeestDAO extends CrudRepository<Beest, Integer> {

    Iterable<Beest> findBySoortOrderByNaam(String soort);

    @Query(value = "select b from Beest b where b.naam = :naam")
    Iterable<Beest> zoekBijNaam(String naam);
}
