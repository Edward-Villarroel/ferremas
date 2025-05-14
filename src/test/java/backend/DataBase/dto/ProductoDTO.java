/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.DataBase.dto;

/**
 *
 * @author edwar
 */
public class ProductoDTO extends CategoriaDTO{
    private Integer id_producto;

    private String nombre_producto;
    private String descripcion;
    private Float precio;
    private String marca;
    private Integer cantidad_disponible;

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }



    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(Integer cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public ProductoDTO() {
    }

    public ProductoDTO(Integer id_producto, String nombre_producto, String descripcion, Float precio, String marca, Integer cantidad_disponible) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
        this.cantidad_disponible = cantidad_disponible;
    }
    
}
