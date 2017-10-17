package springbootspringdatacrud.controllers;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import springbootspringdatacrud.domain.Actor;
import springbootspringdatacrud.domain.Film;
import springbootspringdatacrud.dto.ActorResponse;
import springbootspringdatacrud.dto.ActorsResponse;
import springbootspringdatacrud.dto.FilmResponse;
import springbootspringdatacrud.services.ActorService;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorRestController {
    private final DozerBeanMapper mapper;
    private final ActorService actorService;
    @GetMapping("/actors")
    @ResponseBody
    public ResponseEntity getActors(){
        final List<Actor> actorSet = actorService.actorList();
        ActorsResponse actorResponse = mapper.map(actorSet, ActorsResponse.class);
    return ResponseEntity.status(HttpStatus.OK).body(actorResponse);
    }
    @GetMapping("/actors/{id}")
    @ResponseBody
    public ResponseEntity<Actor> getActor(@PathVariable int id){
        return new ResponseEntity<Actor>(actorService.getById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/actors/{id}")
    @ResponseBody
    public ResponseEntity  createActor(@RequestBody Actor actor){
        actorService.saveOrUpdate(actor);
        return new ResponseEntity(actor, HttpStatus.OK);
    }
    @PutMapping("/actors/{id}")
    @ResponseBody
    public ResponseEntity editActor(@PathVariable int id, @RequestBody Actor actor){
        Actor actor1 = actorService.getById(id);
        if(actor1==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        actorService.saveOrUpdate(actor);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/actors/{id}")
    @ResponseBody
    public ResponseEntity deleteActor(@PathVariable int id){
        actorService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
