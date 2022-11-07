package be.abis.exercise.controller;

import be.abis.exercise.exceptions.CourseNotFoundException;
import be.abis.exercise.formmodel.LoginModel;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/persons")
public class MyController {
    @Autowired private TrainingService trainingService;

    @GetMapping("/{personId}")
    public String course(Model model, @PathVariable int personId) throws CourseNotFoundException {
        model.addAttribute("title", trainingService.getCourseService().findCourse(7900).getShortTitle());
        model.addAttribute("firstName", trainingService.getPersonService().findPerson(personId).getFirstName());
        model.addAttribute("lastName", trainingService.getPersonService().findPerson(personId).getLastName());
        return "course";
    }

    @GetMapping("/login")
    public String login(Model model){
        LoginModel loginModel = new LoginModel();
        model.addAttribute("login", loginModel);
        return "login";
    }

    @PostMapping("/login")
    public String showUser(Model model, LoginModel login){
        Person p = trainingService.getPersonService().findPerson(login.getEmail(), login.getPassword());

        model.addAttribute("firstName", p.getFirstName());
        model.addAttribute("lastName", p.getLastName());
        return "showUser";
    }
}
