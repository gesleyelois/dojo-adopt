package br.com.alura.dojoadopt.models;

import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static br.com.alura.dojoadopt.models.Tutor.TypeOfHousing.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Tutor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @CPF
    @NotBlank
    private String cpf;

    @NotNull
    @PastOrPresent
    private LocalDate birthDate;

    @NotNull
    private BigDecimal salary;

    @NotNull
    @Enumerated(STRING)
    private TypeOfHousing typeOfHousing;

    @URL
    @NotBlank
    private String photoURL;

    @Deprecated
    public Tutor() {

    }

    public Tutor(String name, String cpf, LocalDate birthDate, BigDecimal salary, TypeOfHousing typeOfHousing, String photoURL) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.salary = salary;
        this.typeOfHousing = typeOfHousing;
        this.photoURL = photoURL;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public TypeOfHousing getTypeOfHousing() {
        return typeOfHousing;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public boolean isMoreThanEighteenYearsOld() {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now()) > 18;
    }

    public boolean hasNameStartsWithLetter(String letter) {
        return name.startsWith(letter);
    }

    public boolean isTypeOfHousingSitio() {
        return SITIO.equals(typeOfHousing);
    }

    public boolean isTypeOfHousingHouseWithPool() {
        return HOUSE_WITH_POOL.equals(typeOfHousing);
    }

    public boolean isTypeOfHousingApartment() {
        return APARTMENT.equals(typeOfHousing);
    }

    public boolean hasSalaryGreaterThanFiftyThousand() {
        return hasSalaryGreaterThan(new BigDecimal("50.000"));
    }

    private boolean hasSalaryGreaterThan(BigDecimal value) {
        return salary.compareTo(value) > 0;
    }

    public enum TypeOfHousing {
        HOUSE("Casa"),
        APARTMENT("Apartamento"),
        HOUSE_WITH_YARD("Casa com Quintal"),
        HOUSE_WITH_POOL("Casa com Piscina"),
        SITIO("Sitio");

        private String displayName;

        TypeOfHousing(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

}
