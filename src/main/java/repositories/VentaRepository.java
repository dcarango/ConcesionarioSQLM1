package repositories;

import database.DBConnection;
import models.Cliente;
import models.Coche;
import models.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VentaRepository {

    // Crea una venta apartir de una id_venta
    public Venta ventaById(Integer idVenta) {

        Venta venta = null;
        DBConnection dbConnection = new DBConnection();
        String sql = "SELECT * FROM ventas WHERE id_venta = ?";

        try (
                Connection connection = dbConnection.connect();
                PreparedStatement pstm = connection.prepareStatement(sql)
        ) {
            pstm.setInt(1,idVenta);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    venta.setId_cliente(rs.getInt("id_cliente"));
                    venta.setId_coche(rs.getInt("id_coche"));
                    venta.setFecha_venta(rs.getDate("fecha_venta").toLocalDate());
                    venta.setPrecio_final(rs.getDouble("precio_final"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return venta;
    }

    // Elimina una venta por su id
    public Boolean deleteVentaById(Integer idCliente) {
        Boolean deleteVenta;

        DBConnection dbConnection = new DBConnection();
        String sql = "DELETE FROM ventas WHERE id_cliente = ?";

        try (
                Connection connection = dbConnection.connect();
                PreparedStatement pstm = connection.prepareStatement(sql);
                ) {
            pstm.setInt(1,idCliente);
            deleteVenta = pstm.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleteVenta;
    }

    // Crea un listado de ventas
    public List<Venta> allVentas () {
        List<Venta> ventas = new ArrayList<>();
        DBConnection dbConnection = new DBConnection();
        String sql = "SELECT * FROM ventas";

        try (
                Connection connection = dbConnection.connect();
                PreparedStatement pstm = connection.prepareStatement(sql)
                ) {
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Venta venta = new Venta();
                    venta.setId_cliente(rs.getInt("id_cliente"));
                    venta.setId_coche(rs.getInt("id_coche"));
                    // Parseamos fecha
                    venta.setFecha_venta(LocalDate.parse(rs.getString("fecha_venta")));
                    venta.setPrecio_final(rs.getDouble("precio_final"));
                    ventas.add(venta);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ventas;
    }
}
