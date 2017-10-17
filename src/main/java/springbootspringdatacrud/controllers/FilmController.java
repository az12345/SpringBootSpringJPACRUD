package springbootspringdatacrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import springbootspringdatacrud.domain.Film;
import springbootspringdatacrud.services.FilmService;

@Controller
public class FilmController {
    @Autowired
    FilmService filmService;
    @GetMapping("/film/edit/{id}")
    public String editFilm(@PathVariable int id, Model model){
        model.addAttribute("film",filmService.getById(id) );
        return "editfilm";
    }
    @GetMapping("/film/delete/{id}")
    public String deleteFilm(@PathVariable int id){
        filmService.delete(id);
        return "redirect:/";
    }
    @PostMapping("/film/save")
    public String saveFilm(@ModelAttribute Film film){
        filmService.saveOrUpdate(film);
        return "redirect:/";
    }
}
