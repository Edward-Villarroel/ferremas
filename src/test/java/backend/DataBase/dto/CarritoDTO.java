/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.DataBase.dto;

/**
 *
 * @author edwar
 */
public class CarritoDTO extends ProductoDTO{
    private Integer id_carrito;

    private Integer cantidad;

    public CarritoDTO() {
    }

    public CarritoDTO(Integer id_carrito, Integer cantidad) {
        this.id_carrito = id_carrito;
        this.cantidad = cantidad;
    }

    public Integer getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Integer id_carrito) {
        this.id_carrito = id_carrito;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
