package services;

import dtos.VentaDTO;
import models.Cliente;
import models.Coche;
import models.Venta;
import repositories.ClienteRepository;
import repositories.CocheRepository;
import repositories.VentaRepository;

import java.util.ArrayList;
import java.util.List;

public class VentaServices {

    // Funcion utilizada para crea una lista de VentasDTO
    // Recupera datos de la tabla Clientes y Coches
    public List<VentaDTO> showVentasDTO() {
        ClienteRepository clienteRepository = new ClienteRepository();
        VentaRepository ventaRepository = new VentaRepository();
        CocheRepository cocheRepository = new CocheRepository();
        List<VentaDTO> ventasDto = new ArrayList<>();

        List<Venta> ventasSQL = ventaRepository.allVentas();
        for (Venta ventaSQL : ventasSQL) {
            Cliente cliente = clienteRepository.getClienteById(ventaSQL.getId_cliente());
            Coche coche = cocheRepository.cocheById(ventaSQL.getId_coche());

            VentaDTO ventaDTO = new VentaDTO();
            ventaDTO.setNombreCliente(cliente.getNombre());
            ventaDTO.setModeloCoche(coche.getModelo());
            ventaDTO.setPrecioCoche(ventaSQL.getPrecio_final());
            ventaDTO.setFechaVenta(ventaSQL.getFecha_venta());
            ventasDto.add(ventaDTO);
            }
        return ventasDto;
    }
}
