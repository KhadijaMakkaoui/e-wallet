package com.example.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("api/v1/wallet")
public class walletController {
    @Autowired
    private walletService walletService;
    @Autowired
    private MapperDTO mapper;

    @GetMapping
    public List<walletDTO> ListWallets() {
        return walletService.getAll()
                .stream()
                .map((wallet) -> mapper.mapToDTO(wallet))
                .collect(toList());

    }

}
