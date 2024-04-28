package tn.esprit.examnomprenom.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examnomprenom.entities.Transaction;
import tn.esprit.examnomprenom.services.ITransactionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactonController {

    private final ITransactionService transactionService;



    @PostMapping("/virement")
    public ResponseEntity<String> ajouterVirement(@RequestBody Transaction transaction) {
        String response = transactionService.ajouterVirement(transaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/retrait")
    public ResponseEntity<String> ajouterRetrait(@RequestBody Transaction transaction) {
        String response = transactionService.ajouterRetrait(transaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/versement")
    public ResponseEntity<String> ajouterVersement(@RequestBody Transaction transaction) {
        String response = transactionService.ajouterVersement(transaction);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
   /* @GetMapping("/bank/{idBank}")
    public ResponseEntity<List<Transaction>> getAllTransactionByBankId(@PathVariable long idBank) {
        List<Transaction> transactions = transactionService.getAllTransactionByBankId(idBank);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }*/
}
