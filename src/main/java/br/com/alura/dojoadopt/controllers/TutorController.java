package br.com.alura.dojoadopt.controllers;

import br.com.alura.dojoadopt.dtos.NewTutorForm;
import br.com.alura.dojoadopt.dtos.TutorView;
import br.com.alura.dojoadopt.models.Tutor;
import br.com.alura.dojoadopt.repositories.TutorRepository;
import br.com.alura.dojoadopt.validators.NewTutorFormValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TutorController {

    private final TutorRepository tutorRepository;

    public TutorController(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @InitBinder("newTutorForm")
    public void initBinderNewTutorForm(WebDataBinder binder) {
        binder.addValidators(new NewTutorFormValidator(tutorRepository));
    }

    @GetMapping("/novo/tutor")
    public String newForm(NewTutorForm newTutorForm, Model model) {
        model.addAttribute("typesOfHousing", Tutor.TypeOfHousing.values());
        return "tutor/newForm";
    }

    @PostMapping("/novo/tutor")
    public String saveNewForm(@Valid NewTutorForm newTutorForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return newForm(newTutorForm, model);
        tutorRepository.save(newTutorForm.toModel());
        return "redirect:/tutores";
    }

    @GetMapping("/tutores")
    public String list(Model model) {
        List<TutorView> tutors = tutorRepository.findAll().stream().map(TutorView::new).toList();
        model.addAttribute("tutors", tutors);
        return "tutor/list";
    }

}
