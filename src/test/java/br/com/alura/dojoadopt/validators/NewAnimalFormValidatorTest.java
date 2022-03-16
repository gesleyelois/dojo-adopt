package br.com.alura.dojoadopt.validators;

import br.com.alura.dojoadopt.dtos.NewAnimalForm;
import br.com.alura.dojoadopt.models.Animal.AnimalType;
import br.com.alura.dojoadopt.repositories.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NewAnimalFormValidatorTest {

    private AnimalRepository animalRepository;
    private NewAnimalFormValidator newAnimalFormValidator;

    @BeforeEach
    void setUp() {
        animalRepository = mock(AnimalRepository.class);
        when(animalRepository.existsByNameAndType("Spike", AnimalType.DOG)).thenReturn(true);

        newAnimalFormValidator = new NewAnimalFormValidator(animalRepository);
    }

    @Test
    void should_validate_if_the_code_already_exists() {
        NewAnimalForm newAnimalForm = new NewAnimalForm();
        newAnimalForm.setName("Spike");
        newAnimalForm.setType(AnimalType.DOG);

        Errors errors = new BeanPropertyBindingResult(newAnimalForm, "newAnimalForm");

        newAnimalFormValidator.validate(newAnimalForm, errors);

        assertThat(errors.getAllErrors()).hasSize(1)
                .extracting("defaultMessage")
                .containsOnly("The Animal already exists");
    }

    @Test
    void should_not_return_errors() {
        NewAnimalForm newAnimalForm = new NewAnimalForm();
        Errors errors = new BeanPropertyBindingResult(newAnimalForm, "newAnimalForm");

        newAnimalFormValidator.validate(newAnimalForm, errors);

        assertThat(errors.hasErrors()).isFalse();
    }

}