package tn.esprit.examnomprenom.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examnomprenom.entities.Bank;
import tn.esprit.examnomprenom.entities.Compte;
import tn.esprit.examnomprenom.entities.Transaction;
import tn.esprit.examnomprenom.repositories.BankRepository;
import tn.esprit.examnomprenom.repositories.CompteRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankServiceImpl implements IBankService{
    private final BankRepository bankRepository;
    private final CompteRepository compteRepository;

    @Override
    public Bank ajouterBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank) {
        Bank bank = bankRepository.findBankByAgence(agenceBank);
        bank.getComptes().add(compte);
        compteRepository.save(compte);
        bankRepository.save(bank);
        return compte;
    }

    @Override
    public String ajouterVirement(Transaction transaction) {
        return null;
    }

    @Override
    @Scheduled(cron="*/30 * * * * *")
    public void getAllTransactionByDate() {
        log.info("test");
    }
}
