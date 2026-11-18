package repositories;

import database.DBConnection;
import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteRepository {

    // Crea un cliente apartir de un id_cliente
    public Cliente clienteById(Integer idCliente) {

        Cliente cliente = null;
        DBConnection dbConnection = new DBConnection();
        String sql = "SElECT * FROM clientes WHERE id_cliente = ?";

        try (
                Connection connection = dbConnection.connect();
                PreparedStatement pstm = connection.prepareStatement(sql)
        ) {
            pstm.setInt(1,idCliente);
            try ( ResultSet rs = pstm.executeQuery();) {
                if (rs.next()) {
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
}