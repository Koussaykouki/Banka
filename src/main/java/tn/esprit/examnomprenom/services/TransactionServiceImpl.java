package tn.esprit.examnomprenom.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examnomprenom.entities.Client;
import tn.esprit.examnomprenom.entities.Compte;
import tn.esprit.examnomprenom.entities.Transaction;
import tn.esprit.examnomprenom.entities.enums.TypeCompte;
import tn.esprit.examnomprenom.entities.enums.TypeTransaction;
import tn.esprit.examnomprenom.repositories.ClientRepository;
import tn.esprit.examnomprenom.repositories.CompteRepository;
import tn.esprit.examnomprenom.repositories.TransactionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements ITransactionService {
    private final TransactionRepository transactionRepository ;
    private final CompteRepository compteRepository ;
    @Override
    public String ajouterVirement(Transaction transaction) {
        Compte expediteur = compteRepository.findById(transaction.getExpediteur().getIdCompte()).orElse(null);
        Compte Destinataire =compteRepository.findById(transaction.getDestinataire().getIdCompte()).orElse(null);
        if (expediteur.getType() == TypeCompte.EPARGNE) {
            return "on ne peut pas faire un virement a partir d'un compte epargne";
        }

        if(expediteur.getSolde()<transaction.getMontant()+3)
        {
            return"virement impossible, veuillez recharger votre compte";
        }

        expediteur.setSolde(expediteur.getSolde() -transaction.getMontant()-3);
        Destinataire.setSolde(Destinataire.getSolde() +transaction.getMontant());
        compteRepository.save(expediteur);
        compteRepository.save(Destinataire);
        transactionRepository.save(transaction);

        return String.format("VIREMENT de %.2f DT de compte %d vers le compte %d approuvé avec succès.",
                transaction.getMontant(), transaction.getExpediteur().getIdCompte(), transaction.getDestinataire().getIdCompte());


        }

    @Override
    public String ajouterRetrait(Transaction transaction) {
        Compte expediteur = compteRepository.findById(transaction.getExpediteur().getIdCompte()).orElse(null);
        if(transaction.getType()== TypeTransaction.RETRAIT)
        {
            if(transaction.getMontant()>expediteur.getSolde()+2)
            {
                return "Solde insuffisant";
            }

            expediteur.setSolde(expediteur.getSolde() -transaction.getMontant()-2);
            compteRepository.save(expediteur);
            transactionRepository.save(transaction);

            return String.format("Retrait de %.2f de compte %d approuvé avec succés",transaction.getMontant(),transaction.getExpediteur().getIdCompte());
        }
        return"type problem";
    }

    @Override
    public String ajouterVersement(Transaction transaction) {
        Compte Destinataire =compteRepository.findById(transaction.getDestinataire().getIdCompte()).orElse(null);

        if(transaction.getType()== TypeTransaction.VERSEMENT)
        {
            if (Destinataire.getType() != TypeCompte.EPARGNE) {
                Destinataire.setSolde(Destinataire.getSolde() +transaction.getMontant()-2);
                compteRepository.save(Destinataire);
                transactionRepository.save(transaction);

                return String.format("Versement de %.2f vers compte %d approuvé avec succés",transaction.getMontant()-2,transaction.getDestinataire().getIdCompte());
            }
            Destinataire.setSolde(Destinataire.getSolde() +transaction.getMontant());
            compteRepository.save(Destinataire);
            transactionRepository.save(transaction);


            return String.format("Versement de %.2f de compte %d approuvé avec succés",transaction.getMontant(),transaction.getDestinataire().getIdCompte());
        }
        return"type problem";
    }

    @Override
    public List<Transaction> getAllTransactionsForDate(LocalDate date) {
        return transactionRepository.findAllByDateTransaction(date);
    }
    /*@Override
    public List<Transaction> getAllTransactionByBankId(long idBank) {
        return transactionRepository.getAllTransactionByBankId(idBank);
    }*/

}
