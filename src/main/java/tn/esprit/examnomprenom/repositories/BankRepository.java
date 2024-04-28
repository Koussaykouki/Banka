package tn.esprit.examnomprenom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examnomprenom.entities.Bank;

public interface BankRepository extends JpaRepository<Bank,Long> {
    Bank findBankByAgence(String agence);
}
