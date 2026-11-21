package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StructureDB {

    // Rutas
    private final Path dbPath = Path.of("src/main/resources/concesionario.db");
    private final Path sqlScriptPath = Path.of("src/main/resources/ConcesionarioSQLite.sql");
    ;

    // Funcion que crea la estructura de la base de datos.
    public String loadScript(){
        String message;
        DBConnection connectionBD = new DBConnection();
        try(
                Connection conBD = connectionBD.connect();
                Statement statement = conBD.createStatement()
        ) {
            //execute update se traga como statement un script entero
            String sqlScriptString = Files.readString(sqlScriptPath);
            statement.executeUpdate(sqlScriptString);
            message="Script loaded";
        } catch (SQLException ex) {
            message="Error with database: " + ex.getMessage();
        } catch (IOException e) {
            message="File not found";
        }
        return message;
    }

    // Funcion que elimina la base de datos.
    public String deleteDatabase() {
        String message;

        try {
            if (Files.deleteIfExists(dbPath)) {
                message = "Database deleted successfully.";
            } else {
                message = "Database does not exist.";
            }
        } catch (IOException e) {
            message = "Error deleting database: " + e.getMessage();
        }
        return message;
    }
}
