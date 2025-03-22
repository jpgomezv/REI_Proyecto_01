package com.backendUsuarios.Usuarios.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario") 
    private Integer IdUsuario;

    private String fullname;
    private String username;
    private String segment;
    private String password;
    private String email;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String region;
    private String country;


    public enum Usertype {
        admin, user
    }

    @Enumerated(EnumType.STRING)
    private Usertype Usertype;
}

