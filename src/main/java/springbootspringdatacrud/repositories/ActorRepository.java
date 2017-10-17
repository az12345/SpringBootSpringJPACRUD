package springbootspringdatacrud.repositories;

import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import springbootspringdatacrud.domain.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
