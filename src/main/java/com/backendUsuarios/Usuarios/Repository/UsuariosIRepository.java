package com.backendUsuarios.Usuarios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendUsuarios.Usuarios.Model.UserModel;

public interface UsuariosIRepository extends JpaRepository<UserModel, Integer> {


}
