package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static br.com.alura.dojoadopt.models.Tutor.TypeOfHousing.SITIO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class CatTest {

    @Test
    void canAdopt__should_return_true_when_tutor_does_not_have_more_than_three_adopted_dogs() {
        Cat cat = new Cat();
        AdoptRepository adoptRepository = Mockito.mock(AdoptRepository.class);

        Tutor tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(SITIO).build();
        when(adoptRepository.tutorHasMoreThanThreeAdoptedDogs(tutor)).thenReturn(true);

        assertThat(cat.canAdopt(tutor, adoptRepository)).isFalse();

        when(adoptRepository.tutorHasMoreThanThreeAdoptedDogs(tutor)).thenReturn(false);

        assertThat(cat.canAdopt(tutor, adoptRepository)).isTrue();
    }
}