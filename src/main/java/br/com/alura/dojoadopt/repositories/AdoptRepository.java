package br.com.alura.dojoadopt.repositories;

import br.com.alura.dojoadopt.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdoptRepository extends JpaRepository<Adopt, Long> {

    List<Adopt> findByTutor(Tutor tutor);

    boolean existsByTutorAndAnimal(Tutor tutor, Animal animal);

}
