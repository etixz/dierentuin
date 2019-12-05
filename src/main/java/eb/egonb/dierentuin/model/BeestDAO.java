package eb.egonb.dierentuin.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeestDAO extends CrudRepository<Beest, Integer> {

    List<Beest> findByNaam(String naam);
}
