package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static br.com.alura.dojoadopt.models.Tutor.TypeOfHousing.HOUSE_WITH_POOL;
import static br.com.alura.dojoadopt.models.Tutor.TypeOfHousing.SITIO;
import static org.assertj.core.api.Assertions.assertThat;

class FishTest {

    @Test
    void canAdopt__should_return_true_when_type_of_housing_is_house_with_pool() {
        Fish fish = new Fish();
        Tutor tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(SITIO).build();

        assertThat(fish.canAdopt(tutor, Mockito.mock(AdoptRepository.class))).isFalse();

        tutor = new TutorBuilder().withSalary(new BigDecimal("51.000")).withTypeOfHousing(HOUSE_WITH_POOL).build();

        assertThat(fish.canAdopt(tutor, Mockito.mock(AdoptRepository.class))).isTrue();
    }
}