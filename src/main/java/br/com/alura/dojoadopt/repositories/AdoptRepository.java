package br.com.alura.dojoadopt.repositories;

import br.com.alura.dojoadopt.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdoptRepository extends JpaRepository<Adopt, Long> {

    List<Adopt> findByTutor(Tutor tutor);

    boolean existsByTutorAndAnimal(Tutor tutor, Animal animal);

    @Query("SELECT COUNT(1) > 0 FROM Adopt a WHERE a.tutor=:tutor AND a.animal.type IN ('CAT', 'DOG')")
    boolean tutorHasAdoptedCatOrDog(@Param("tutor") Tutor tutor);

    @Query("SELECT COUNT(1) > 2 FROM Adopt a WHERE a.tutor=:tutor AND a.animal.type = 'DOG'")
    boolean tutorHasMoreThanThreeAdoptedDogs(@Param("tutor") Tutor tutor);

    @Query("SELECT COUNT(1) > 0 FROM Adopt a WHERE a.tutor=:tutor AND a.animal.type = 'DOG' and a.animal.size IN ('LARGE', 'GIANT')")
    boolean tutorHasOnlyOneLargeOrBigAdoptedDog(@Param("tutor") Tutor tutor);

}
