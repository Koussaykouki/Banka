package tn.esprit.examnomprenom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.examnomprenom.entities.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByDateTransaction(LocalDate date);
    /*@Query("SELECT t FROM Transaction t WHERE t.expediteur.idBank = :idBank OR t.destinataire.bank.idBank = :idBank")
    List<Transaction> getAllTransactionByBankId(long idBank);*/
}
