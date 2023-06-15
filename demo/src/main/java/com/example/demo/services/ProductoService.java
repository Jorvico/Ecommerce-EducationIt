package com.example.demo.services;

import com.example.demo.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    public Producto create(Producto Producto);
    public Optional<Producto> getProducto(Integer id);
    public void update(Producto producto);
    public void delete(Integer id);
    public List<Producto> findAll();

}
