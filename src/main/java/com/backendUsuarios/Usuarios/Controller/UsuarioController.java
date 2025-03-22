package com.backendUsuarios.Usuarios.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendUsuarios.Usuarios.Model.UserModel;
import com.backendUsuarios.Usuarios.Service.UsuariosIService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
        @Autowired
    private UsuariosIService usuarioService;

    @PostMapping
    public ResponseEntity<String> guardarUsuario(@RequestBody UserModel usuario) {
        return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
    }

    @GetMapping("/{Id}")
    public ResponseEntity<UserModel> buscarUsuarioPorId(@PathVariable Integer IdUsuario) {
        UserModel usuario = usuarioService.buscarUsuarioPorId(IdUsuario);
        return (usuario != null) ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Integer IdUsuario) {
        return ResponseEntity.ok(usuarioService.eliminarUsuarioPorId(IdUsuario));
    }

    @PutMapping("/{Id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable Integer IdUsuario, @RequestBody UserModel usuarioNuevo) {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(IdUsuario, usuarioNuevo));
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }
    
}
