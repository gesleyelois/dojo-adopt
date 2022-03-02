package br.com.alura.dojoadopt.controllers;

import br.com.alura.dojoadopt.dtos.AnimalView;
import br.com.alura.dojoadopt.dtos.NewAnimalForm;
import br.com.alura.dojoadopt.models.Animal;
import br.com.alura.dojoadopt.repositories.AnimalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/novo/animal")
    public String newForm(NewAnimalForm newAnimalForm, Model model) {
        model.addAttribute("animalTypes", Animal.AnimalType.values());
        model.addAttribute("animalSizes", Animal.AnimalSize.values());
        return "animal/newForm";
    }

    @PostMapping("/novo/animal")
    public String saveNewForm(@Valid NewAnimalForm newAnimalForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return newForm(newAnimalForm, model);
        animalRepository.save(newAnimalForm.toModel());
        return "redirect:/animais";
    }

    @GetMapping("/animais")
    public String list(Model model) {
        List<AnimalView> animals = animalRepository.findAll().stream().map(AnimalView::new).toList();
        model.addAttribute("animals", animals);
        return "animal/list";
    }
}
