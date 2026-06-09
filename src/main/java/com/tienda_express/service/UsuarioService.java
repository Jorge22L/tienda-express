package com.tienda_express.service;

import com.tienda_express.modelo.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listarTodos();

    Usuario buscarPorId(Long id);

    Usuario guardar(Usuario usuario);

    Usuario actualizar(Long id, Usuario usuario);

    void eliminar(Long id);

    void cambiarEstado(Long id);
}
