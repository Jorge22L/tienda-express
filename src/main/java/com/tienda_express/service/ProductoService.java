package com.tienda_express.service;

import com.tienda_express.modelo.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listarTodos();
    Producto buscarPorId(Long id);
    Producto guardar(Producto producto);
    Producto actualizar(Long id, Producto producto);
    void eliminar(Long id);
}
