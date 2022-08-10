package br.com.alura.dojoadopt.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class TutorBuilder {

    private String name;

    private String cpf;

    private LocalDate birthDate;

    private BigDecimal salary;

    private Tutor.TypeOfHousing typeOfHousing;

    private String photoURL;

    public TutorBuilder() {
        this.name = "User %s".formatted(UUID.randomUUID().toString());
        this.cpf = "89327710061";
        this.birthDate = LocalDate.now().minusYears(18);
        this.salary = BigDecimal.TEN;
        this.typeOfHousing = Tutor.TypeOfHousing.APARTMENT;
        this.photoURL = "https://photo.com.br";
    }

    public TutorBuilder withSalary(BigDecimal salary) {
        this.salary = salary;
        return  this;
    }

    public TutorBuilder withTypeOfHousing(Tutor.TypeOfHousing typeOfHousing) {
        this.typeOfHousing = typeOfHousing;
        return  this;
    }

    public Tutor build() {
        return new Tutor(name, cpf, birthDate, salary, typeOfHousing, photoURL);
    }
}
