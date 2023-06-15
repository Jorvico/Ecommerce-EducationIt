package com.example.demo.services;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Producto create(Producto producto) {
        return productRepository.save(producto);
    }

    @Override
    public Optional<Producto> getProducto(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Producto producto) {
        productRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Producto> findAll() {
        return productRepository.findAll();
    }
}
