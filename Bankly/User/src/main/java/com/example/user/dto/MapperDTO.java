package com.example.user.dto;

import com.example.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class MapperDTO {
    public UserDTO mapToDTO(User user) {
        Long id= user.getId();
        String nom = user.getNom();
        String prenom = user.getPrenom();
        String email = user.getEmail();
        String password = user.getPassword();
        Long wallet_id = user.getWallet_id();

        return new UserDTO(id,nom, prenom, email, password,wallet_id);
    }

}
