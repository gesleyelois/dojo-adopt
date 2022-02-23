package br.com.alura.dojoadopt.models;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @Min(10)
    private BigDecimal monthlyCost;

    @NotNull
    @PastOrPresent
    private LocalDate birthDate;

    @NotNull
    @Enumerated(STRING)
    private AnimalType type;

    @NotNull
    @Enumerated(STRING)
    private AnimalSize size;

    @URL
    @NotBlank
    private String photoURL;

    @Deprecated
    public Animal() {

    }

    public enum AnimalType {
        FISH("Peixe"),
        REPTILE("Réptil"),
        DOG("Cachorro"),
        CAT("Gato"),
        BIRD("Pássaro"),
        EXOTIC("Exótico");

        private String displayName;

        AnimalType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }


    public enum AnimalSize {
        MINI("Mini"),
        SMALL("Pequeno"),
        MEDIUM("Médio"),
        LARGE("Grande"),
        GIANT("Gigante");

        private String displayName;

        AnimalSize(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

}
