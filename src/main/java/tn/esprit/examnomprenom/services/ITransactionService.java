package tn.esprit.examnomprenom.services;

import tn.esprit.examnomprenom.entities.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface ITransactionService {
    public String ajouterVirement(Transaction transaction);
    public String ajouterRetrait(Transaction transaction);
    public String ajouterVersement(Transaction transaction);

    List<Transaction> getAllTransactionsForDate(LocalDate today);
   // List<Transaction> getAllTransactionByBankId(long idBank);
}
