package com.example.transaction.service;

import com.example.transaction.APITransaction;
import com.example.transaction.dto.MapperDTO;
import com.example.transaction.dto.transactionDTO;
import com.example.transaction.dto.walletDto;
import com.example.transaction.transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
import org.springframework.web.reactive.function.client.WebClient;
*/

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class transactionService {
    @Autowired
    private com.example.transaction.repository.transactionRepository transactionRepository;
    @Autowired
    private MapperDTO mapper;
    @Autowired
    private APITransaction apiTransaction;
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
        /*if (transaction.getType()=="credit") {*/
            System.out.println("Transaction credit");
            return creditTransaction(transaction);

       /* }
        else if (transaction.getType()=="debit") {*/
        /*    debitTransaction(transaction);
        }*/
    }


    public transactionDTO creditTransaction(transaction transaction) {
        //call wellet service to credit the amount
       /* walletDto result = webClientBuilder.build().get()
                .uri("http://Wallet/api/v1/wallet/AA11/"+transaction.getAmount())
                        *//*uriBuilder -> uriBuilder
                                .queryParam("ref", "AA11")
                                .queryParam("amount", transaction.getAmount())
                                .build())*//*
                .retrieve()
                .bodyToMono(walletDto.class)
                .block();*/

        walletDto result = apiTransaction.checkBallance("AA11", transaction.getAmount());
/*
                return result;
*/
        if (result!=null) {
            System.out.println("Transaction succeded");
            return mapper.mapToDTO(transactionRepository.save(transaction));
        }else {
            System.out.println("Transaction failed");
            return null;
        }
    }
    private void debitTransaction(transaction transaction) {
    }

}
