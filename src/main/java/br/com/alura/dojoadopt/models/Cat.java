package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("CAT")
public class Cat extends Animal {

    @Deprecated
    public Cat() {
        super();
    }

    public Cat(String name, BigDecimal monthlyCost, LocalDate birthDate, AnimalSize size, String photoURL) {
        super(name, monthlyCost, birthDate, size, photoURL);
    }

    public boolean canAdopt(Tutor tutor, AdoptRepository adoptRepository) {
        return !adoptRepository.tutorHasMoreThanThreeAdoptedDogs(tutor);
    }
}
