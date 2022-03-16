package br.com.alura.dojoadopt.repositories;

import br.com.alura.dojoadopt.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    boolean existsByCpf(String cpf);

}
