package models;

/**
 * Cliente:
 * Clase utilizada para modelar los datos que se guardan en la BDD.
 */
public class Cliente {
    private Integer id_cliente;
    private String nombre;
    private String telefono;
    private String email;

    // Constructor
    public Cliente() {}

    // Getters
    public Integer getId_cliente() {return id_cliente;}
    public String getNombre() {return nombre;}
    public String getTelefono() {return telefono;}
    public String getEmail() {return email;}

    // Setter
    public void setId_cliente(Integer id_cliente) {this.id_cliente = id_cliente;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public void setEmail(String email) {this.email = email;}
}


