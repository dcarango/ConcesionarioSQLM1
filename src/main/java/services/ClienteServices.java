package services;

import models.Cliente;
import repositories.ClienteRepository;
import repositories.VentaRepository;

import java.util.List;

public class ClienteServices {

    // Muestra la lista de clientes utilizando la clase Clientes
    public List<Cliente> showCliente(){
        ClienteRepository clienteRepository = new ClienteRepository();
        List<Cliente> clientes = clienteRepository.allClientes();

        return clientes;
    }

    //  Elimina un cliente y sus posibles ventas
    public String deleteCliente(Integer idCliente) {
        String messege = "";
        ClienteRepository clienteRepository = new ClienteRepository();
        VentaRepository ventaRepository = new VentaRepository();

        if (clienteRepository.deleteClienteById(idCliente)) {
            messege = "Cliente eliminado correctamente\n";
            if (ventaRepository.deleteVentaById(idCliente)) {
                messege += "Ventas eliminadas correctamente";
            } else {
                messege += "Cliente sin ventas registradas";
            }
        } else {
            messege = "Cliente no encontrado";
        }

        return messege;
    }
}
