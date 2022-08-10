package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("BIRD")
public class Bird extends Animal {

    @Deprecated
    public Bird() {
        super();
    }

    public Bird(String name, BigDecimal monthlyCost, LocalDate birthDate, AnimalSize size, String photoURL) {
        super(name, monthlyCost, birthDate, size, photoURL);
    }

    public boolean canAdopt(Tutor tutor, AdoptRepository adoptRepository) {
        return tutor.hasNameStartsWithLetter("A")
                && tutor.isMoreThanEighteenYearsOld()
                && !tutor.isTypeOfHousingApartment();
    }

}
