package ui;

import database.StructureDB;
import dtos.VentaDTO;
import models.Cliente;
import myLib.UserMethods;
import services.ClienteServices;
import services.VentaServices;

import java.util.List;
import java.util.Scanner;


public class MainMenu {
    private Scanner scanner = new Scanner(System.in);
    private boolean exitMenu = false;

    public void showMenu(){
        UserMethods userMethods = new UserMethods();
        do{
            userMethods.myPrinter("Choose an option: ");
            userMethods.myPrinter("1. Create data base");
            userMethods.myPrinter("2. Delete data base");
            userMethods.myPrinter("3. Show sales");
            userMethods.myPrinter("4. Delete client");
            userMethods.myPrinter("0. Exit.");
            processOption(requestOption());
        }while(!exitMenu);
    }
    private String requestOption(){
        return this.scanner.nextLine();
    }

    private void processOption(String option){
        UserMethods userMethods = new UserMethods();
        switch(option){
            case "0" -> exitMenu = true;
            case "1" -> {
                StructureDB structureDB = new StructureDB();
                userMethods.myPrinter(structureDB.loadScript());
            }
            case "2" -> {
                StructureDB structureDB = new StructureDB();
                userMethods.myPrinter(structureDB.deleteDatabase());
            }
            case "3" -> {
                VentaServices ventaServices = new VentaServices();
                List<VentaDTO> ventasDTO = ventaServices.showVentasDTO();
                for(VentaDTO ventaDTO : ventasDTO){
                    userMethods.myPrinter("Nombre cliente: "+ventaDTO.getNombreCliente()+" - "+"Modelo: "+ventaDTO.getModeloCoche()+" - "+"Precio: "+ventaDTO.getPrecioCoche()+" - "+"Fecha de venta: "+ventaDTO.getFechaVenta());
                }
            }
            case "4" -> {
                ClienteServices  clienteServices = new ClienteServices();
                List<Cliente> clientes = clienteServices.showCliente();
                for(Cliente cliente : clientes){
                    userMethods.myPrinter("Nombre: "+cliente.getNombre()+" - "+"Id: "+cliente.getId_cliente());
                }
                Integer idCliente = userMethods.requestInteger("Ingrese ID del cliente a eliminar: ");
                userMethods.myPrinter(clienteServices.deleteCliente(idCliente));
            }
            default -> userMethods.myPrinter("Wrong option.");
        }
    }
}
