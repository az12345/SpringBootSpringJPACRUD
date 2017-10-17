package springbootspringdatacrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootspringdatacrud.domain.Actor;
import springbootspringdatacrud.services.ActorService;

@Controller
public class ActorController {
    @Autowired
    ActorService actorService;
    @GetMapping("/actor/edit/{id}")
    public String editActor(@PathVariable int id, Model model){
        Actor actor = actorService.getById(id);
        model.addAttribute("actor", actor);
        return "editactor";
    }
    @GetMapping("/actor/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        actorService.delete(id);
        return "redirect:/";
    }
    @PostMapping("/actor/save")
    public String saveOrUpdate(@ModelAttribute Actor actor){
        actorService.saveOrUpdate(actor);
        return "redirect:/";
    }
}
