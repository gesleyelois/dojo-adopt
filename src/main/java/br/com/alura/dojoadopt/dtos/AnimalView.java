package br.com.alura.dojoadopt.dtos;

import br.com.alura.dojoadopt.models.Animal;
import br.com.alura.dojoadopt.utils.YearsUtil;

import java.time.LocalDate;

public class AnimalView {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private Animal.AnimalType type;

    private Animal.AnimalSize size;

    private String photoURL;

    public AnimalView(Animal animal) {
        this.id = animal.getId();
        this.name = animal.getName();
        this.birthDate = animal.getBirthDate();
        this.size = animal.getSize();
        this.type = animal.getType();
        this.photoURL = animal.getPhotoURL();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Animal.AnimalType getType() {
        return type;
    }

    public Animal.AnimalSize getSize() {
        return size;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public String getAge() {
        return YearsUtil.between(birthDate, LocalDate.now());
    }
}
