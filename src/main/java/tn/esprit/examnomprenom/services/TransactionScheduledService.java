package tn.esprit.examnomprenom.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examnomprenom.entities.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionScheduledService {

    private final ITransactionService transactionService;
    private static final Logger logger = LoggerFactory.getLogger(TransactionScheduledService.class);



    @Scheduled(fixedRate = 30000) // Scheduled every 30 seconds
    public void getAllTransactionByDate() {
        LocalDate today = LocalDate.now();
        List<Transaction> transactions = transactionService.getAllTransactionsForDate(today);

        logger.info("Transactions for today ({}):", today);
        for (Transaction transaction : transactions) {
            logger.info(transaction.toString());
        }
    }
}

