package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static br.com.alura.dojoadopt.models.Tutor.TypeOfHousing.APARTMENT;
import static br.com.alura.dojoadopt.models.Tutor.TypeOfHousing.SITIO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class DogTest {

    @Test
    void canAdopt__should_return_true_when_tutor_has_only_one_large_or_big_adopted_dog_and_type_of_housing_is_apartment() {
        Dog dog = new Dog();
        AdoptRepository adoptRepository = Mockito.mock(AdoptRepository.class);

        Tutor tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(SITIO).build();
        when(adoptRepository.tutorHasOnlyOneLargeOrBigAdoptedDog(tutor)).thenReturn(false);

        assertThat(dog.canAdopt(tutor, adoptRepository)).isFalse();

        tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(APARTMENT).build();
        when(adoptRepository.tutorHasOnlyOneLargeOrBigAdoptedDog(tutor)).thenReturn(false);

        assertThat(dog.canAdopt(tutor, adoptRepository)).isFalse();

        tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(SITIO).build();
        when(adoptRepository.tutorHasOnlyOneLargeOrBigAdoptedDog(tutor)).thenReturn(true);

        assertThat(dog.canAdopt(tutor, adoptRepository)).isFalse();

        tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(APARTMENT).build();
        when(adoptRepository.tutorHasOnlyOneLargeOrBigAdoptedDog(tutor)).thenReturn(true);

        assertThat(dog.canAdopt(tutor, adoptRepository)).isTrue();

    }
}