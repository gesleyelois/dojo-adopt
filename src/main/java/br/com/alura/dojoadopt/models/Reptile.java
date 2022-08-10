package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("REPTILE")
public class Reptile extends Animal {

    @Deprecated
    public Reptile() {
        super();
    }

    public Reptile(String name, BigDecimal monthlyCost, LocalDate birthDate, AnimalSize size, String photoURL) {
        super(name, monthlyCost, birthDate, size, photoURL);
    }

    public boolean canAdopt(Tutor tutor, AdoptRepository adoptRepository) {
        return !adoptRepository.tutorHasAdoptedCatOrDog(tutor) || !tutor.isTypeOfHousingSitio();
    }

}
