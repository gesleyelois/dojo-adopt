package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("DOG")
public class Dog extends Animal {

    @Deprecated
    public Dog() {
        super();
    }

    public Dog(String name, BigDecimal monthlyCost, LocalDate birthDate, AnimalSize size, String photoURL) {
        super(name, monthlyCost, birthDate, size, photoURL);
    }

    public boolean canAdopt(Tutor tutor, AdoptRepository adoptRepository) {
        return tutor.isTypeOfHousingApartment() && adoptRepository.tutorHasOnlyOneLargeOrBigAdoptedDog(tutor);
    }

}
