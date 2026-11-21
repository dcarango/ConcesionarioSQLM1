package repositories;

import database.DBConnection;
import models.Cliente;
import models.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CocheRepository {

    // Crea un coche apartir de un id_coche
    public Coche cocheById(Integer idCoche) {

        Coche coche = null;
        DBConnection dbConnection = new DBConnection();
        String sql = "SElECT * FROM coches WHERE id_coche = ?";

        try (
                Connection connection = dbConnection.connect();
                PreparedStatement pstm = connection.prepareStatement(sql)
        ) {
            pstm.setInt(1,idCoche);
            try (ResultSet rs = pstm.executeQuery();) {
                if (rs.next()) {
                    coche = new Coche();
                    coche.setId_coche(rs.getInt("id_coche"));
                    coche.setMarca(rs.getString("marca"));
                    coche.setModelo(rs.getString("modelo"));
                    coche.setAño(rs.getInt("modelo"));
                    coche.setBastidor(rs.getString("año"));
                    coche.setPrecio(rs.getDouble("precio"));
                    coche.setDisponible(rs.getBoolean("disponible"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return coche;
    }
}
