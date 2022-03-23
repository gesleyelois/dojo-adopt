package br.com.alura.dojoadopt.models;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Adopt {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    // @FutureOrPresent
    private LocalDateTime at;

    @ManyToOne
    private Tutor tutor;

    @OneToOne
    private Animal animal;

    @Deprecated
    public Adopt() {

    }

    public Adopt(Tutor tutor, Animal animal) {
        this.tutor = tutor;
        this.animal = animal;
        this.at = now();
    }

    public Animal getAnimal() {
        return animal;
    }
}
