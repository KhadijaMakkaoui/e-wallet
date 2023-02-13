package com.example.transaction.service;

import com.example.transaction.APIWallet;
import com.example.transaction.dto.MapperDTO;
import com.example.transaction.dto.transactionDTO;
import com.example.transaction.dto.walletDto;
import com.example.transaction.entity.transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
import org.springframework.web.reactive.function.client.WebClient;
*/

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;
import com.example.transaction.repository.transactionRepository;

@Service
public class transactionService {
    @Autowired
    private transactionRepository transactionRepository;
    @Autowired
    private MapperDTO mapper;
    @Autowired
    private APIWallet apiWallet;
   /* @Autowired
    private WebClient.Builder webClientBuilder;
*/
    public List<transactionDTO> getAll() {

        return transactionRepository.findAll()
                .stream()
                .map((transaction) -> mapper.mapToDTO(transaction))
                .collect(toList());
    }
    public transactionDTO TransactionOperation(transaction transaction) {
        if (transaction.getType()=="credit") {
            return creditTransaction(transaction);
        }
       /* else if (transaction.getType()=="debit") {
            return debitTransaction(transaction);
        }*/
        else {
            return null;
        }
    }


    public transactionDTO creditTransaction(transaction transaction) {
        //TODO: make wallet ref dynamic

        walletDto result = apiWallet.checkBallance("AA11", transaction.getAmount());

        if (result!=null) {
            System.out.println("Transaction succeded");
            //TODO: update wallet balance
            transaction.setDate(Timestamp.valueOf(LocalDateTime.now()));
            return mapper.mapToDTO(transactionRepository.save(transaction));
        }else {
            System.out.println("Transaction failed");
            return null;
        }
    }
    private void debitTransaction(transaction transaction) {
    }

}
