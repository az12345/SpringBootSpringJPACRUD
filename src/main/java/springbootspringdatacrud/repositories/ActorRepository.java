package springbootspringdatacrud.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springbootspringdatacrud.domain.Actor;
@Repository
public interface ActorRepository  extends CrudRepository<Actor, Integer>{
}
