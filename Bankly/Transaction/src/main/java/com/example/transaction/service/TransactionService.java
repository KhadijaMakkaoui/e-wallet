package com.example.transaction.service;

import com.example.transaction.APIWallet;
import com.example.transaction.dto.MapperDTO;
import com.example.transaction.dto.TransactionDTO;
import com.example.transaction.dto.WalletDto;
import com.example.transaction.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
import org.springframework.web.reactive.function.client.WebClient;
*/

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;
import com.example.transaction.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private MapperDTO mapper;
    @Autowired
    private APIWallet apiWallet;
    WalletDto walletDtoUp;
    WalletDto walletDto;

    /* @Autowired
     private WebClient.Builder webClientBuilder;
 */
    public List<TransactionDTO> getAll() {

        return transactionRepository.findAll()
                .stream()
                .map((transaction) -> mapper.mapToDTO(transaction))
                .collect(toList());
    }

    public TransactionDTO TransactionOperation(Transaction transaction) {
        System.out.println("Transaction type: " + transaction.getType());
        if (transaction.getType().equals("credit")) {
            return creditTransaction(transaction);
        } else if (transaction.getType().equals("debit")) {
            return debitTransaction(transaction);
        } else {
            System.out.println("invalid operation");
            return null;
        }
    }


    public TransactionDTO creditTransaction(Transaction transaction) {

        WalletDto walletDto = apiWallet.checkBallance(transaction.getUser_id(), transaction.getAmount());

        if (walletDto != null) {
            setDateAndRef(transaction);
            if (transaction != null) {
                //update wallet balance
                walletDto.setBalance(walletDto.getBalance() - transaction.getAmount());
                return saveTransaction(transaction, walletDto);
            } else {
                System.out.println("Transaction failed");
                return null;
            }
        } else {
            System.out.println("Balance is not valid to credit");
            return null;
        }
    }

    public TransactionDTO debitTransaction(Transaction transaction) {
        setDateAndRef(transaction);
        WalletDto walletDto = apiWallet.getWallet(transaction.getUser_id());

        if (walletDto != null) {
            //update wallet balance
            walletDto.setBalance(walletDto.getBalance() + transaction.getAmount());
            return saveTransaction(transaction, walletDto);
        } else {
            System.out.println("Transaction failed");
            return null;
        }

    }

    private TransactionDTO saveTransaction(Transaction transaction, WalletDto walletDto) {
        walletDtoUp = apiWallet.updateWallet(transaction.getUser_id(), walletDto);
        if (walletDtoUp != null) {
            System.out.println("Wallet updated successfully");
            return mapper.mapToDTO(transactionRepository.save(transaction));
        } else {
            System.out.println("Transaction failed");
            return null;
        }
    }


    private void setDateAndRef(Transaction transaction) {
        transaction.setRef(UUID.randomUUID().toString());
        transaction.setDate(Timestamp.valueOf(LocalDateTime.now()));
    }



}
