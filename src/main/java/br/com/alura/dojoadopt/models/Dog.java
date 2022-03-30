package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Dog")
public class Dog extends Animal {

    @Deprecated
    public Dog() {
        super();
    }

    public boolean canAdopt(Tutor tutor, AdoptRepository adoptRepository) {
        return tutor.isTypeOfHousingApartment() && adoptRepository.tutorHasOnleOneLargeOrBigAdoptedDog(tutor);
    }

}
