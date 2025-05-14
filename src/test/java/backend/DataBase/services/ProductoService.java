/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.DataBase.services;

import backend.DataBase.models.Producto;
import backend.DataBase.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> findByNombreProductoContaining(String nombre) {
        return productoRepository.findByNombre_productoContaining(nombre);
    }


    public List<Producto> findByCategoriaId(Integer categoriaId) {
        return productoRepository.findByCategoriaId_categoria(categoriaId);
    }
}
