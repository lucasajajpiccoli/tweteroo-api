package com.tweteroo.api.models;

import com.tweteroo.api.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {

    public UserModel(UserDTO dto) {
        this.avatar = dto.getAvatar();
        this.username = dto.getUsername();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(nullable = false)
    private String avatar;
    
    @Column(length = 100, nullable = false, unique = true)
    private String username;
}
