package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static br.com.alura.dojoadopt.models.Tutor.TypeOfHousing.APARTMENT;
import static br.com.alura.dojoadopt.models.Tutor.TypeOfHousing.SITIO;
import static org.assertj.core.api.Assertions.assertThat;

class ExoticTest {

    @Test
    void canAdopt__should_return_true_when_salary_is_greater_than_fifty_thousand_and_type_of_housing_is_sitio() {
        Exotic exotic = new Exotic();
        Tutor tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(SITIO).build();

        assertThat(exotic.canAdopt(tutor, Mockito.mock(AdoptRepository.class))).isTrue();
    }

    @Test
    void canAdopt__should_return_false_when_salary_is_less_than_or_equal_to_fifty_thousand() {
        Exotic exotic = new Exotic();
        Tutor tutor = new TutorBuilder().withSalary(new BigDecimal("49.999")).withTypeOfHousing(SITIO).build();

        assertThat(exotic.canAdopt(tutor, Mockito.mock(AdoptRepository.class))).isFalse();

        tutor = new TutorBuilder().withSalary(new BigDecimal("50.000")).withTypeOfHousing(SITIO).build();

        assertThat(exotic.canAdopt(tutor, Mockito.mock(AdoptRepository.class))).isFalse();

        tutor = new TutorBuilder().withSalary(new BigDecimal("50.001")).withTypeOfHousing(SITIO).build();

        assertThat(exotic.canAdopt(tutor, Mockito.mock(AdoptRepository.class))).isTrue();
    }

    @Test
    void canAdopt__should_return_false_when_type_of_housing_is_not_sitio() {
        Exotic exotic = new Exotic();
        Tutor tutor = new TutorBuilder().withSalary(new BigDecimal("50.000")).withTypeOfHousing(APARTMENT).build();

        assertThat(exotic.canAdopt(tutor, Mockito.mock(AdoptRepository.class))).isFalse();

        tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(SITIO).build();

        assertThat(exotic.canAdopt(tutor, Mockito.mock(AdoptRepository.class))).isTrue();
    }
}