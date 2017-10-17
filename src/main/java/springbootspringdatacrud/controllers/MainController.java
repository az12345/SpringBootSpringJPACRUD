package springbootspringdatacrud.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springbootspringdatacrud.services.ActorService;
import springbootspringdatacrud.services.FilmService;

import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainController {

    private final FilmService filmService;
    private final ActorService actorService;

    @GetMapping({"", "/"})
    public String main(Model model) {
        List filmList = filmService.filmList();
        model.addAttribute("filmList", filmList);
        model.addAttribute("actorList", actorService.actorList());
        return "index";
    }
}
