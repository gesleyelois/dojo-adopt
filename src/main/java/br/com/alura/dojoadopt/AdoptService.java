package br.com.alura.dojoadopt;

import br.com.alura.dojoadopt.models.*;
import br.com.alura.dojoadopt.repositories.AdoptRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AdoptService {

    private final AdoptRepository adoptRepository;

    public AdoptService(AdoptRepository adoptRepository) {
        this.adoptRepository = adoptRepository;
    }

    public boolean canAdopt(Tutor tutor, Animal animal) {

        if (adoptRepository.existsByTutorAndAnimal(tutor, animal)) return false;

        BigDecimal monthlyCostTotal = totalMonthlyCostWithAnimal(tutor).add(animal.getMonthlyCost());

        return tutor.getSalary().compareTo(monthlyCostTotal) > 0;
    }

    public BigDecimal totalMonthlyCostWithAnimal(Tutor tutor) {
        return adoptRepository.findByTutor(tutor).stream()
                .map(Adopt::getAnimal)
                .map(Animal::getMonthlyCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
