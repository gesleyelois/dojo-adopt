package br.com.alura.dojoadopt.models;

import br.com.alura.dojoadopt.repositories.AdoptRepository;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Animal {

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

//    @NotNull
    @Enumerated(STRING)
    @Column(updatable = false, insertable = false)
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMonthlyCost() {
        return monthlyCost;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public AnimalType getType() {
        return type;
    }

    public AnimalSize getSize() {
        return size;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public abstract boolean canAdopt(Tutor tutor, AdoptRepository adoptRepository);

    public Animal(String name, BigDecimal monthlyCost, LocalDate birthDate, AnimalSize size, String photoURL) {
        this.name = name;
        this.monthlyCost = monthlyCost;
        this.birthDate = birthDate;
        this.size = size;
        this.photoURL = photoURL;
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
