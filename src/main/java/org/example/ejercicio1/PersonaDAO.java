package org.example.ejercicio1;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PersonaDAO {
    private final static String conexion = "jdbc:mysql://localhost:3306/TP-PROXY";
    private final static String usuario = "victor";
    private final static String clave = "nUojg8-u.uc8/a.1";
    private Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(conexion, usuario, clave);
    }
    public Persona personaPorId(int id) {
        String sql = "select p.nombre from personas p where p.id = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String nombrePersona = result.getString(1);
                return new Persona(id, nombrePersona, new ProxySet(id));
            } else {
                throw new RuntimeException("Persona no encontrada");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Telefono> cargarTelefonos(int idPersona) {
        String sql = "select t.numero from telefonos t where t.idpersona = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idPersona);
            ResultSet result = statement.executeQuery();
            Set<Telefono> telefonos = new HashSet<>();
            while (result.next()) {
                telefonos.add(new Telefono(result.getString(1)));
            }
            return telefonos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

