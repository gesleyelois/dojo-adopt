package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Reptile")
public class Reptile extends Animal {

    @Deprecated
    public Reptile() {
        super();
    }

    public boolean canAdopt(Tutor tutor, AdoptRepository adoptRepository) {
        return !adoptRepository.tutorHasAdoptedCatOrDog(tutor) || !tutor.isTypeOfHousingSitio();
    }

}
