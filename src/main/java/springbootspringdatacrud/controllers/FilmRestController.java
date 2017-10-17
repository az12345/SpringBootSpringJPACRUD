package springbootspringdatacrud.controllers;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springbootspringdatacrud.domain.Film;
import springbootspringdatacrud.dto.FilmResponse;
import springbootspringdatacrud.services.FilmService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FilmRestController {
    private final DozerBeanMapper dozerBeanMapper;

    private final FilmService filmService;

    @GetMapping("/films")
    @ResponseBody
    public ResponseEntity getFilms() {
        final List<Film> filmList = filmService.filmList();
        final FilmResponse filmResponse = dozerBeanMapper.map(filmList, FilmResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(filmResponse);
    }
}
