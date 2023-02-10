package com.example.wallet.service;

import com.example.wallet.dto.MapperDTO;
import com.example.wallet.entity.wallet;
import com.example.wallet.dto.walletDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private wallet wallet;

    public List<walletDTO> getAll() {
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

    public walletDTO createWallet( Long id_user) {
       wallet.setUser_id(id_user);
       wallet.setBalance(0);
       wallet.setRef(UUID.randomUUID().toString());
        wallet = walletRepository.save(wallet);
        return mapper.mapToDTO(wallet);
    }
}
