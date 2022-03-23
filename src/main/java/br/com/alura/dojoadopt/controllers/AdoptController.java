package br.com.alura.dojoadopt.controllers;

import br.com.alura.dojoadopt.dtos.AdoptForm;
import br.com.alura.dojoadopt.dtos.AnimalView;
import br.com.alura.dojoadopt.exceptions.NotFoundException;
import br.com.alura.dojoadopt.models.Tutor;
import br.com.alura.dojoadopt.repositories.AnimalRepository;
import br.com.alura.dojoadopt.repositories.TutorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdoptController {

    private final TutorRepository tutorRepository;
    private final AnimalRepository animalRepository;

    public AdoptController(TutorRepository tutorRepository, AnimalRepository animalRepository) {
        this.tutorRepository = tutorRepository;
        this.animalRepository = animalRepository;
    }

    @GetMapping("/adotar/tutor/{id}")
    public String tutor(@PathVariable Long id, Model model) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(NotFoundException::new);
        List<AnimalView> animals = animalRepository.findAll().stream().map(AnimalView::new).toList();

        model.addAttribute("animals", animals);
        model.addAttribute("tutor", tutor);
        return "adopt/index";
    }

    @PostMapping("/adotar/animal")
    public String adopt(@Valid AdoptForm adoptForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Não foi possível adotar o animal!");
            return "redirect:/tutores";
        }

        return "redirect:/animais";
    }

}
