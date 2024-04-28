package tn.esprit.examnomprenom.services;

import tn.esprit.examnomprenom.entities.Bank;
import tn.esprit.examnomprenom.entities.Compte;
import tn.esprit.examnomprenom.entities.Transaction;

public interface IBankService {
    public Bank ajouterBank(Bank bank);
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank);
    public String ajouterVirement(Transaction transaction);
    public void getAllTransactionByDate();
}
