package com.example.wallet.service;

import com.example.wallet.dto.MapperDTO;
import com.example.wallet.entity.Wallet;
import com.example.wallet.dto.WalletDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;
import com.example.wallet.repository.WalletRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class WalletService {
    private final WalletRepository walletRepository;

    private final MapperDTO mapper;

@Autowired
    private WalletDTO walletdto;

    public List<WalletDTO> getAll() {
        return walletRepository.findAll()
                .stream()
                .map((wallet) -> mapper.mapToDTO(wallet))
                .collect(toList());
    }
    public Wallet checkBallance(Long idUser, float amount) {
        Wallet wallet = walletRepository.findByUserId(idUser);
        if(wallet!=null){
            if (wallet.getBalance()>=amount) {
                return wallet;
            }else{
                return null;
            }
        }else {
                return null;
        }
    }

    public WalletDTO createWallet(Long id_user) {
        Wallet wallet = new Wallet();

        wallet.setUserId(id_user);
        wallet.setBalance(0);
        wallet.setRef(UUID.randomUUID().toString());
        walletdto=mapper.mapToDTO(walletRepository.save(wallet));
        return walletdto;
    }
    public WalletDTO updateBalance(Long id,WalletDTO walletDTO) {
       Wallet wallet=walletRepository.findById(id).get();
        if(wallet!=null){
            wallet.setBalance(walletDTO.getBalance());
           return mapper.mapToDTO(walletRepository.save(wallet));
        }
        else {
            return null;
        }

    }
}
