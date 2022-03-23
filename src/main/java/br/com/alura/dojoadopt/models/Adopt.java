package br.com.alura.dojoadopt.models;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Adopt {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

}
