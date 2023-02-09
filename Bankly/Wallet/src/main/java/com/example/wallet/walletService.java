package com.example.wallet;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
public class walletService {
    private final walletRepository walletRepository;
    private final MapperDTO mapper;
    public List<walletDTO> getAll() {
        return walletRepository.findAll()
                .stream()
                .map((wallet) -> mapper.mapToDTO(wallet))
                .collect(toList());
    }
    /*@SneakyThrows*/
    public wallet checkBallance(String ref, float amount) {
       /* log.info("Wait started");
            Thread.sleep(10000);

        log.info("Wait ended");*/
        wallet wallet = walletRepository.findByRef(ref);
        if (wallet.getBalance()>=amount) {
            return wallet;
        }
        else {
            return null;
        }
    }
}
