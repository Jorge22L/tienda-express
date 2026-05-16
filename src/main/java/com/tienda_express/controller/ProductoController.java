package com.tienda_express.controller;

import com.tienda_express.modelo.Producto;
import com.tienda_express.repository.CategoriaRepository;
import com.tienda_express.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;
    private final CategoriaRepository categoriaRepository;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("productos", productoService.listarTodos());
        return "productos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "productos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@Valid @ModelAttribute Producto producto,
                                  BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("categorias", categoriaRepository.findAll());
            return "productos/formulario";
        }

        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/{id}")
    public String verDetalle(@PathVariable Long id, Model model){
        model.addAttribute("producto", productoService.buscarPorId(id));
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "productos/formulario";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model)
    {
        model.addAttribute("producto", productoService.buscarPorId(id));
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "productos/formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarProducto(@PathVariable Long id, @Valid @ModelAttribute Producto producto,
                                     BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("categorias", categoriaRepository.findAll());
            return "productos/formulario";
        }

        productoService.actualizar(id, producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        productoService.eliminar(id);
        return "redirect:/productos";
    }


}
