package com.example.wallet.service;

import com.example.wallet.dto.MapperDTO;
import com.example.wallet.entity.wallet;
import com.example.wallet.dto.WalletDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;
import com.example.wallet.repository.walletRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class walletService {
    private final walletRepository walletRepository;

    private final MapperDTO mapper;
@Autowired
    private WalletDTO walletdto;

    public List<WalletDTO> getAll() {
        return walletRepository.findAll()
                .stream()
                .map((wallet) -> mapper.mapToDTO(wallet))
                .collect(toList());
    }
    public wallet checkBallance(String ref, float amount) {
        wallet wallet = walletRepository.findByRef(ref);
        if (wallet.getBalance()>=amount) {
            return wallet;
        }
        else {
            return null;
        }
    }

    public WalletDTO createWallet(Long id_user) {
        wallet wallet = new wallet();

        wallet.setUser_id(id_user);
        wallet.setBalance(0);
        wallet.setRef(UUID.randomUUID().toString());
        walletdto=mapper.mapToDTO(walletRepository.save(wallet));
        return walletdto;
    }
}
