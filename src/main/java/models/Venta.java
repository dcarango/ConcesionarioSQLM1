package models;

import java.time.LocalDate;

/**
 * Venta:
 * Clase utilizada para modelar los datos de la BDD,
 */
public class Venta {
    private Integer id_venta;
    private Integer id_coche;
    private Integer id_cliente;
    private LocalDate fecha_venta; // Formato que encaja con SQLite
    private Double precio_final;

    // Constructor
    public Venta() {}

    // Getters
    public Integer getId_venta() {return id_venta;}
    public Integer getId_coche() {return id_coche;}
    public Integer getId_cliente() {return id_cliente;}
    public LocalDate getFecha_venta() {return fecha_venta;}
    public Double getPrecio_final() {return precio_final;}

    // Setters
    public void setId_venta(Integer id_venta) {this.id_venta = id_venta;}
    public void setId_coche(Integer id_coche) {this.id_coche = id_coche;}
    public void setId_cliente(Integer id_cliente) {this.id_cliente = id_cliente;}
    public void setFecha_venta(LocalDate fecha_venta) {this.fecha_venta = fecha_venta;}
    public void setPrecio_final(Double precio_final) {this.precio_final = precio_final;}
}
