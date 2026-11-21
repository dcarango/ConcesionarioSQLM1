package repositories;

import database.DBConnection;
import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    // Crea un cliente apartir de un id_cliente
    public Cliente getClienteById(Integer idCliente) {

        Cliente cliente = null;
        DBConnection dbConnection = new DBConnection();
        String sql = "SElECT * FROM clientes WHERE id_cliente = ?";

        try (
                Connection connection = dbConnection.connect();
                PreparedStatement pstm = connection.prepareStatement(sql)
        ) {
            pstm.setInt(1,idCliente);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setId_cliente(rs.getInt("id_cliente"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setEmail(rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    // Elimina a un cliente por su id
    public Boolean deleteClienteById(Integer idCliente) {
        Boolean deleteCliente;

        DBConnection dbConnection = new DBConnection();
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";

        try (Connection connection = dbConnection.connect();
             PreparedStatement pstm = connection.prepareStatement(sql);) {

            pstm.setInt(1,idCliente);
            deleteCliente = pstm.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleteCliente;
    }

    // Devuelve una lista con todos los clientes
    public List<Cliente> allClientes () {
        List<Cliente> clientes = new ArrayList<>();

        DBConnection dbConnection = new DBConnection();
        String sql = "SELECT * FROM clientes";

        try (
                Connection connection = dbConnection.connect();
                PreparedStatement pstm = connection.prepareStatement(sql)
                ) {
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId_cliente(rs.getInt("id_cliente"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setEmail(rs.getString("email"));
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }
}