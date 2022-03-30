package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bird")
public class Bird extends Animal {

    @Deprecated
    public Bird() {
        super();
    }

    public boolean canAdopt(Tutor tutor, AdoptRepository adoptRepository) {
        return tutor.hasNameStartsWithLetter("A")
                && tutor.isMoreThanEighteenYearsOld()
                && !tutor.isTypeOfHousingApartment();
    }

}
