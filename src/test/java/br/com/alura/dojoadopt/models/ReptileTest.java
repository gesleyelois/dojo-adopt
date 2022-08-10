package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static br.com.alura.dojoadopt.models.Tutor.TypeOfHousing.APARTMENT;
import static br.com.alura.dojoadopt.models.Tutor.TypeOfHousing.SITIO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class ReptileTest {

    @Test
    void canAdopt__should_return_true_when_tutor_does_not_have_an_adopted_cat_or_dog_or_type_of_housing_is_not_sitio() {
        Reptile reptile = new Reptile();
        AdoptRepository adoptRepository = Mockito.mock(AdoptRepository.class);

        Tutor tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(SITIO).build();
        when(adoptRepository.tutorHasAdoptedCatOrDog(tutor)).thenReturn(true);

        assertThat(reptile.canAdopt(tutor, adoptRepository)).isFalse();

        tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(APARTMENT).build();
        when(adoptRepository.tutorHasAdoptedCatOrDog(tutor)).thenReturn(true);

        assertThat(reptile.canAdopt(tutor, adoptRepository)).isTrue();

        tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(SITIO).build();
        when(adoptRepository.tutorHasAdoptedCatOrDog(tutor)).thenReturn(false);

        assertThat(reptile.canAdopt(tutor, adoptRepository)).isTrue();
    }
}