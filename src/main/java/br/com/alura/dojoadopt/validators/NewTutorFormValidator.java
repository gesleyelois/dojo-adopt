package br.com.alura.dojoadopt.validators;

import br.com.alura.dojoadopt.dtos.NewTutorForm;
import br.com.alura.dojoadopt.repositories.TutorRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NewTutorFormValidator implements Validator {

    private final TutorRepository tutorRepository;

    public NewTutorFormValidator(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewTutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if (errors.hasErrors()) return;

        NewTutorForm newTutorForm = (NewTutorForm) object;

        if (tutorRepository.existsByCpf(newTutorForm.getCpf()))
            errors.reject("newAnimalForm.existsByCpf", "The CPF already exists");
    }
}
