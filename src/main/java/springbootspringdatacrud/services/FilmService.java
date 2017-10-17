package springbootspringdatacrud.services;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootspringdatacrud.domain.Film;
import springbootspringdatacrud.repositories.FilmRepository;
import java.util.List;
@Service
public class FilmService{
    @Autowired
    FilmRepository filmRepository;
    public List<Film> filmList(){return (List<Film>) filmRepository.findAll();}
    public Film getById(int id){
        return filmRepository.findOne(id);
    }
    public void saveOrUpdate(Film film){
        filmRepository.save(film);
    }
    public void delete(int id){filmRepository.delete(id);}
}
