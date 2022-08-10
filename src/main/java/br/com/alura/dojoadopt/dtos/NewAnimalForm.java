package br.com.alura.dojoadopt.dtos;

import br.com.alura.dojoadopt.models.*;
import br.com.alura.dojoadopt.models.Animal.AnimalSize;
import br.com.alura.dojoadopt.models.Animal.AnimalType;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NewAnimalForm {

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @Min(10)
    private BigDecimal monthlyCost;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotNull
    private AnimalType type;

    @NotNull
    private AnimalSize size;

    @URL
    @NotBlank
    private String photoURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(BigDecimal monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public AnimalSize getSize() {
        return size;
    }

    public void setSize(AnimalSize size) {
        this.size = size;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Animal toModel() {
        return switch (type) {
            case FISH -> new Fish(name, monthlyCost, birthDate, size, photoURL);
            case REPTILE -> new Reptile(name, monthlyCost, birthDate, size, photoURL);
            case CAT -> new Cat(name, monthlyCost, birthDate, size, photoURL);
            case DOG -> new Dog(name, monthlyCost, birthDate, size, photoURL);
            case BIRD -> new Bird(name, monthlyCost, birthDate, size, photoURL);
            case EXOTIC -> new Exotic(name, monthlyCost, birthDate, size, photoURL);
            default -> throw new IllegalArgumentException("Unsupported type!");
        };
    }
}
