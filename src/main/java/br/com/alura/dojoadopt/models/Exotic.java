package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Exotic")
public class Exotic extends Animal {

    @Deprecated
    public Exotic() {
        super();
    }

    public boolean canAdopt(Tutor tutor, AdoptRepository adoptRepository) {
        return tutor.hasSalaryGreaterThanFiftyThousand()
                && tutor.isTypeOfHousingSitio();
    }

}
