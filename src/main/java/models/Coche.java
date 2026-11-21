package models;

/**
 * Coche:
 * Clase utilizada para modelar los datos de la BDD.
 */
public class Coche {
    private Integer id_coche;
    private String marca;
    private String modelo;
    private Integer año;
    private String bastidor;
    private Double precio;
    private Boolean disponible;

    // Constructor
    public Coche() {}

    // Getters
    public Integer getId_coche() {return id_coche;}
    public String getMarca() {return marca;}
    public String getModelo() {return modelo;}
    public Integer getAño() {return año;}
    public String getBastidor() {return bastidor;}
    public Double getPrecio() {return precio;}
    public Boolean getDisponible() {return disponible;}

    // Setters
    public void setId_coche(Integer id_coche) {this.id_coche = id_coche;}
    public void setMarca(String marca) {this.marca = marca;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public void setAño(Integer año) {this.año = año;}
    public void setBastidor(String bastidor) {this.bastidor = bastidor;}
    public void setPrecio(Double precio) {this.precio = precio;}
    public void setDisponible(Boolean disponible) {this.disponible = disponible;}
}
