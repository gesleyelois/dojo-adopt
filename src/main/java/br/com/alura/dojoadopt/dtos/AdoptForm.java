package br.com.alura.dojoadopt.dtos;

import javax.validation.constraints.NotNull;

public class AdoptForm {

    @NotNull
    private Long animalId;

    @NotNull
    private Long tutorId;

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }
}
