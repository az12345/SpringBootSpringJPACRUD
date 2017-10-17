package springbootspringdatacrud.controllers;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springbootspringdatacrud.domain.Actor;
import springbootspringdatacrud.dto.ActorRequest;
import springbootspringdatacrud.dto.ActorResponse;
import springbootspringdatacrud.dto.ActorsResponse;
import springbootspringdatacrud.services.ActorService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorRestController {

    private final DozerBeanMapper mapper;
    private final ActorService actorService;

    @GetMapping("/actors")
    @ResponseBody
    public ResponseEntity getActors() {
        final List<Actor> actorSet = actorService.actorList();

//        final ActorsResponse response = mapper.map(actorSet, ActorsResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(actorSet);
    }

    @GetMapping("/actors/{id}")
    @ResponseBody
    public ResponseEntity<Actor> getActor(@PathVariable int id) {
        return new ResponseEntity<Actor>(actorService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/actors")
    @ResponseBody
    public ResponseEntity createActor(@RequestBody ActorRequest request) {

        final Actor toSave = mapper.map(request, Actor.class);

        final Actor saved = actorService.saveOrUpdate(toSave);

        final ActorResponse response = mapper.map(saved, ActorResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/actors/{id}")
    @ResponseBody
    public ResponseEntity editActor(@PathVariable int id, @RequestBody Actor actor) {
        Actor actor1 = actorService.getById(id);
        if (actor1 == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        actorService.saveOrUpdate(actor);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/actors/{id}")
    @ResponseBody
    public ResponseEntity deleteActor(@PathVariable int id) {
        actorService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
