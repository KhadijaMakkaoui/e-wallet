package com.example.transaction;

import com.example.transaction.dto.walletDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class transactionService {
    @Autowired
    private transactionRepository transactionRepository;
    @Autowired
    private MapperDTO mapper;
    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<transactionDTO> getAll() {

        return transactionRepository.findAll()
                .stream()
                .map((transaction) -> mapper.mapToDTO(transaction))
                .collect(toList());
    }
    public void TransactionOperation(transaction transaction) {
        /*if (transaction.getType()=="credit") {*/
            System.out.println("Transaction credit");
            creditTransaction(transaction);

       /* }
        else if (transaction.getType()=="debit") {*/
        /*    debitTransaction(transaction);
        }*/
    }


    public void creditTransaction(transaction transaction) {
        //call wellet service to credit the amount
        walletDto result = webClientBuilder.build().get()
                .uri("http://Wallet/api/v1/wallet/AA11/"+transaction.getAmount())
                        /*uriBuilder -> uriBuilder
                                .queryParam("ref", "AA11")
                                .queryParam("amount", transaction.getAmount())
                                .build())*/
                .retrieve()
                .bodyToMono(walletDto.class)
                .block();
/*
                return result;
*/
        if (result!=null) {
            System.out.println("Transaction succeded");
            transactionRepository.save(transaction);
        }else {
            System.out.println("Transaction failed");
        }
    }
    private void debitTransaction(transaction transaction) {
    }

}
