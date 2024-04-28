package tn.esprit.examnomprenom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examnomprenom.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
