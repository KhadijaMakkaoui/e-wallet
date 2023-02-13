package com.example.user.service;

import com.example.user.APIWallet;
import com.example.user.dto.MapperDTO;
import com.example.user.dto.UserDTO;
import com.example.user.dto.WalletDto;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private WalletDto walletDto;
    @Autowired
    private MapperDTO mapperDTO;

    @Autowired
    private APIWallet apiWallet;
    public UserDTO register(User user) {
        userRepository.save(user);
        //create wallet for registred user
        walletDto=new WalletDto();
        walletDto.setUserId(user.getId());
        walletDto= apiWallet.createWallet(walletDto);
        if(walletDto!=null)
            user.setWallet_id(walletDto.getId());

        return mapperDTO.mapToDTO(userRepository.save(user));

    }

    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map((user) -> mapperDTO.mapToDTO(user))
                .collect(java.util.stream.Collectors.toList());
    }

   /* public UserDetails findByEmail(String email) {
        User user= userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(
                        new SimpleGrantedAuthority("ROLE_USER")
        ));
    }*/
}
