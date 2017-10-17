package springbootspringdatacrud.repositories;

import org.springframework.data.repository.CrudRepository;
import springbootspringdatacrud.domain.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

}
