package springbootspringdatacrud.controllers;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springbootspringdatacrud.domain.Film;
import springbootspringdatacrud.dto.FilmRequest;
import springbootspringdatacrud.dto.FilmResponse;
import springbootspringdatacrud.services.FilmService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FilmRestController {

    private final DozerBeanMapper mapper;
    private final FilmService filmService;

    @GetMapping("/films")
    @ResponseBody
    public ResponseEntity getFilms() {
        final List<Film> filmList = filmService.filmList();
        final FilmResponse filmResponse = mapper.map(filmList, FilmResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(filmService.filmList());
    }

    @PostMapping("/actors/{id}/films")
    @ResponseBody
    public ResponseEntity createFilm(@PathVariable(value = "id") final Integer id,
                                     @RequestBody final FilmRequest request) {

        final Film toSave = mapper.map(request, Film.class);

        final Film saved = filmService.addToActor(id, toSave);

        final FilmResponse response = mapper.map(saved, FilmResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
