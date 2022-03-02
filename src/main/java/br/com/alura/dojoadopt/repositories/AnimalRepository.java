package br.com.alura.dojoadopt.repositories;

import br.com.alura.dojoadopt.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
