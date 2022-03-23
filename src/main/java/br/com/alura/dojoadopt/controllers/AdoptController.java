package br.com.alura.dojoadopt.controllers;

import br.com.alura.dojoadopt.AdoptService;
import br.com.alura.dojoadopt.dtos.AdoptForm;
import br.com.alura.dojoadopt.dtos.AnimalView;
import br.com.alura.dojoadopt.exceptions.NotFoundException;
import br.com.alura.dojoadopt.models.*;
import br.com.alura.dojoadopt.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class AdoptController {

    private final TutorRepository tutorRepository;
    private final AnimalRepository animalRepository;
    private final AdoptRepository adoptRepository;
    private final AdoptService adoptService;

    public AdoptController(TutorRepository tutorRepository, AnimalRepository animalRepository, AdoptRepository adoptRepository, AdoptService adoptService) {
        this.tutorRepository = tutorRepository;
        this.animalRepository = animalRepository;
        this.adoptRepository = adoptRepository;
        this.adoptService = adoptService;
    }

    @GetMapping("/adotar/tutor/{id}")
    public String tutor(@PathVariable Long id, Model model) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(NotFoundException::new);
        List<AnimalView> animals = animalRepository.findAll().stream()
                .filter(animal -> adoptService.canAdopt(tutor, animal))
                .map(AnimalView::new)
                .toList();

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

        Tutor tutor = tutorRepository.findById(adoptForm.getTutorId()).orElseThrow(NotFoundException::new);
        Animal animal = animalRepository.findById(adoptForm.getAnimalId()).orElseThrow(NotFoundException::new);

        if (!adoptService.canAdopt(tutor, animal)) {
            redirectAttributes.addFlashAttribute("error", "Não foi possível adotar o animal!");
            return "redirect:/adotar/tutor/%d".formatted(tutor.getId());
        }

        Adopt adopt = new Adopt(tutor, animal);
        adoptRepository.save(adopt);

        redirectAttributes.addFlashAttribute("success", "Parabéns o(a) %s foi adotado(a) com sucesso!".formatted(animal.getName()));

        return "redirect:/animais-adotados/tutor/%d".formatted(tutor.getId());
    }

    @GetMapping("/animais-adotados/tutor/{id}")
    public String adoptedAnimals(@PathVariable Long id, Model model) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(NotFoundException::new);

        BigDecimal totalPetExpenses = adoptService.getTotalPetExpenses(tutor);

        List<AnimalView> animals = adoptRepository.findByTutor(tutor).stream()
                .map(Adopt::getAnimal)
                .map(AnimalView::new)
                .toList();

        model.addAttribute("animals", animals);
        model.addAttribute("tutor", tutor);
        model.addAttribute("totalPetExpenses", totalPetExpenses);
        return "adopt/tutor";
    }

}
