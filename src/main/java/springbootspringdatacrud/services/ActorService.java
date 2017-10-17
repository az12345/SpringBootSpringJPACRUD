package springbootspringdatacrud.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootspringdatacrud.domain.Actor;
import springbootspringdatacrud.repositories.ActorRepository;

import java.util.List;

@Service

public class ActorService {
    @Autowired
    ActorRepository actorRepository;
    public List<Actor> actorList(){
        return (List<Actor>) actorRepository.findAll();
    }
    public Actor getById(int id){
        return actorRepository.findOne(id);
    }
    public void saveOrUpdate(Actor actor){
        actorRepository.save(actor);
    }
    public void delete(int id){
        actorRepository.delete(id);
    }
}
