package tn.esprit.examnomprenom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examnomprenom.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
