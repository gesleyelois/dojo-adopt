package br.com.alura.dojoadopt.dtos;

import br.com.alura.dojoadopt.models.Animal;

public class AdoptAnimalView {

    private String name;

    private String photoURL;

    public AdoptAnimalView(Animal animal) {
        this.name = animal.getName();
        this.photoURL = animal.getPhotoURL();
    }

    public String getName() {
        return name;
    }

    public String getPhotoURL() {
        return photoURL;
    }

}
