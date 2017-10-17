package springbootspringdatacrud.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootspringdatacrud.domain.Actor;
import springbootspringdatacrud.repositories.ActorRepository;

import java.util.List;

@Service
public class ActorService {

    // TODO: lombok
    @Autowired
    ActorRepository actorRepository;

    // TODO: interface
    public List<Actor> actorList(){
        return (List<Actor>) actorRepository.findAll();
    }

    public Actor getById(int id){
        return actorRepository.findOne(id);
    }

    public Actor saveOrUpdate(Actor actor){
        return actorRepository.save(actor);
    }

    public void delete(int id){
        actorRepository.delete(id);
    }
}
