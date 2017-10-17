package springbootspringdatacrud.repositories;

import org.springframework.data.repository.CrudRepository;
import springbootspringdatacrud.domain.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {

}
