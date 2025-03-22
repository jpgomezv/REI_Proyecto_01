package com.backendUsuarios.Usuarios.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendUsuarios.Usuarios.Model.UserModel;
import com.backendUsuarios.Usuarios.Repository.UsuariosIRepository;

@Service
public class UsuarioServiceImpl implements UsuariosIService {

    @Autowired
    private UsuariosIRepository usuarioRepository;

    @Override
    public String guardarUsuario(UserModel usuario) {
        usuarioRepository.save(usuario);
        return "Usuario guardado correctamente.";
    }

    @Override
    public UserModel buscarUsuarioPorId(Integer IdUsuario) {
        return usuarioRepository.findById(IdUsuario).orElse(null);
    }

    @Override
    public String eliminarUsuarioPorId(Integer IdUsuario) {
        if (usuarioRepository.existsById(IdUsuario)) {
            usuarioRepository.deleteById(IdUsuario);
            return "Usuario eliminado correctamente.";
        }
        return "Usuario no encontrado.";
    }

    @Override
    public String actualizarUsuario(Integer IdUsuario, UserModel usuarioNuevo) {
        return usuarioRepository.findById(IdUsuario).map(usuario -> {
            usuario.setFullname(usuarioNuevo.getFullname());
            usuario.setUsername(usuarioNuevo.getUsername());
            usuario.setSegment(usuarioNuevo.getSegment());
            usuario.setPassword(usuarioNuevo.getPassword());
            usuario.setEmail(usuarioNuevo.getEmail());
            usuario.setAddress(usuarioNuevo.getAddress());
            usuario.setCity(usuarioNuevo.getCity());
            usuario.setState(usuarioNuevo.getState());
            usuario.setPostalCode(usuarioNuevo.getPostalCode());
            usuario.setRegion(usuarioNuevo.getRegion());
            usuario.setCountry(usuarioNuevo.getCountry());
            usuario.setUsertype(usuarioNuevo.getUsertype());
            usuarioRepository.save(usuario);
            return "Usuario actualizado correctamente.";
        }).orElse("Usuario no encontrado.");
    }
    
    @Override
    public java.util.List<UserModel> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
