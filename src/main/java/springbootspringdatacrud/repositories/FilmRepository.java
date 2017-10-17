package springbootspringdatacrud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springbootspringdatacrud.domain.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer>{

}
