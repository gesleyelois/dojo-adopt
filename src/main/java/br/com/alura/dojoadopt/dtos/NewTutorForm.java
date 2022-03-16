package br.com.alura.dojoadopt.dtos;

import br.com.alura.dojoadopt.models.Tutor;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;

public class NewTutorForm {

    @NotBlank
    @Size(max = 100)
    private String name;

    @CPF
    @NotBlank
    private String cpf;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotNull
    private BigDecimal salary;

    @NotNull
    @Enumerated(STRING)
    private Tutor.TypeOfHousing typeOfHousing;

    @URL
    @NotBlank
    private String photoURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Tutor.TypeOfHousing getTypeOfHousing() {
        return typeOfHousing;
    }

    public void setTypeOfHousing(Tutor.TypeOfHousing typeOfHousing) {
        this.typeOfHousing = typeOfHousing;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Tutor toModel() {
        return new Tutor(name, cpf, birthDate, salary, typeOfHousing, photoURL);
    }

}
