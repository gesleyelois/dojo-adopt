package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Cat")
public class Cat extends Animal {

    @Deprecated
    public Cat() {
        super();
    }

    public boolean canAdopt(Tutor tutor, AdoptRepository adoptRepository) {
        return !adoptRepository.tutorHasMoreThanThreeAdoptedDogs(tutor);
    }
}
