package tn.esprit.examnomprenom.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examnomprenom.entities.Bank;
import tn.esprit.examnomprenom.entities.Compte;
import tn.esprit.examnomprenom.services.IBankService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank")
public class BankController {
    private final IBankService bankService;

    @PostMapping("/addBank")
    public Bank addBank(@RequestBody Bank bank){
        return bankService.ajouterBank(bank);
    }

    @PostMapping("/affect/{agence}")
    public Compte affect(@RequestBody Compte compte,@PathVariable String agence){
        return bankService.ajouterCompteEtAffecterAAgence(compte,agence);
    }
}
