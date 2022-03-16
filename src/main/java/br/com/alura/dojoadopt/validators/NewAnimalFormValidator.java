package br.com.alura.dojoadopt.validators;

import br.com.alura.dojoadopt.dtos.NewAnimalForm;
import br.com.alura.dojoadopt.repositories.AnimalRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NewAnimalFormValidator implements Validator {

    private final AnimalRepository animalRepository;

    public NewAnimalFormValidator(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewAnimalForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if (errors.hasErrors()) return;

        NewAnimalForm newAnimalForm = (NewAnimalForm) object;

        if (animalRepository.existsByNameAndType(newAnimalForm.getName(), newAnimalForm.getType()))
            errors.reject("newAnimalForm.existsByNameAndType", "The Animal already exists");
    }
}
