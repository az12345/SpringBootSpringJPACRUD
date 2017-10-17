package springbootspringdatacrud.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootspringdatacrud.domain.Actor;
import springbootspringdatacrud.domain.Film;
import springbootspringdatacrud.repositories.ActorRepository;
import springbootspringdatacrud.repositories.FilmRepository;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    @Autowired
    ActorRepository actorRepository;

    public List<Film> filmList() {
        return (List<Film>) filmRepository.findAll();
    }

    public Film getById(int id) {
        return filmRepository.findOne(id);
    }

    public void saveOrUpdate(Film film) {
        filmRepository.save(film);
    }

    public void delete(int id) {
        filmRepository.delete(id);
    }

    public Film addToActor(final Integer id, final Film film) {
        final Actor actor = actorRepository.findOne(id);

        final Film saved = filmRepository.save(film);

        actor.getFilmSet().add(saved);

        actorRepository.save(actor);

        return saved;
    }
}
