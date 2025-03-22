package com.backendUsuarios.Usuarios.Service;

import java.util.List;

import com.backendUsuarios.Usuarios.Model.UserModel;

public interface UsuariosIService {
    String guardarUsuario(UserModel usuario);
    UserModel buscarUsuarioPorId(Integer IdUsuario);   
    String eliminarUsuarioPorId(Integer IdUsuario);
    String actualizarUsuario(Integer IdUsuario, UserModel usuarioNuevo);
    List<UserModel> listarUsuarios();
}
