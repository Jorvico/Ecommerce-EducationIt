package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.services.ProductoService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String read(Model model){
        model.addAttribute("productos", productoService.findAll());
        return "pages/itemread";
    }

    @GetMapping("/create")
    public String create(){

        return "pages/itemcreate";
    }
    @PostMapping("/update")
    public String update(Producto producto){
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model){
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.getProducto(id);
        producto = optionalProducto.get();
        LOGGER.info("producto: {}" + producto);
        model.addAttribute("producto", producto);
        return "pages/itemupdate";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productoService.delete(id);
        return "redirect:/productos";
    }

    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file){
        LOGGER.info("producto: {}" + producto);
        Usuario usuario = new Usuario(1001,"Jorge","Jorge1989","jorge@gmail.com","Av siempre viva","321654987","654987");
        producto.setUsuario(usuario);
        productoService.create(producto);
        return "redirect:/productos";
    }
}
