package com.example.user.dto;

import com.example.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class MapperDTO {
    public UserDTO mapToDTO(User user) {
        String nom = user.getNom();
        String prenom = user.getPrenom();
        String email = user.getEmail();
        String password = user.getPassword();

        return new UserDTO(nom, prenom, email, password);
    }

}
