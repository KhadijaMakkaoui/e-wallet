package com.example.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class walletService {
    @Autowired
    private walletRepository walletRepository;
    @Autowired
    private MapperDTO mapper;
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
