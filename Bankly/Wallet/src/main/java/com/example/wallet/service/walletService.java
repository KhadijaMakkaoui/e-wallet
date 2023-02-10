package com.example.wallet.service;

import com.example.wallet.dto.MapperDTO;
import com.example.wallet.entity.wallet;
import com.example.wallet.dto.walletDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
public class walletService {
    private final com.example.wallet.repository.walletRepository walletRepository;
    private final MapperDTO mapper;
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
}
