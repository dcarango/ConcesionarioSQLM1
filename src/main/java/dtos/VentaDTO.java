package dtos;

import java.time.LocalDate;

/**
 * VentaDTO:
 * Clase utilizada para modelar la venta que se muestra en el UI.
 */

public class VentaDTO {
    private String nombreCliente;
    private String modeloCoche;
    private Double precioCoche;
    private LocalDate fechaVenta;

    // Constructor
    public VentaDTO() {}

    // Getter
    public String getNombreCliente() {return nombreCliente;}
    public String getModeloCoche() {return modeloCoche;}
    public Double getPrecioCoche() {return precioCoche;}
    public LocalDate getFechaVenta() {return fechaVenta;}

    // Setter
    public void setFechaVenta(LocalDate fechaVenta) {this.fechaVenta = fechaVenta;}
    public void setPrecioCoche(Double precioCoche) {this.precioCoche = precioCoche;}
    public void setModeloCoche(String modeloCoche) {this.modeloCoche = modeloCoche;}
    public void setNombreCliente(String nombreCliente) {this.nombreCliente = nombreCliente;}
}
