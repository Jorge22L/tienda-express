package com.tienda_express.service;

import com.tienda_express.modelo.Rol;

import java.util.List;

public interface RolService {
    List<Rol> listarTodos();

    Rol buscarPorId(Long id);

    Rol guardar(Rol rol);

    Rol actualizar(Long id, Rol rol);

    void eliminar(Long id);
}
