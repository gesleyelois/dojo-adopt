package br.com.alura.dojoadopt.dtos;

import br.com.alura.dojoadopt.models.Tutor;

import java.time.LocalDate;

public class TutorView {

    private Long id;

    private String name;

    private String cpf;

    private LocalDate birthDate;

    private String photoURL;

    public TutorView(Tutor tutor) {
        this.id = tutor.getId();
        this.name = tutor.getName();
        this.cpf = tutor.getCpf();
        this.birthDate = tutor.getBirthDate();
        this.photoURL = tutor.getPhotoURL();
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

    public String getPhotoURL() {
        return photoURL;
    }
}
