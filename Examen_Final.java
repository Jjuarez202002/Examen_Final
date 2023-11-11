/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Examen_Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Información de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
        String usuario = "tu_usuario";
        String contraseña = "tu_contraseña";

        // Datos del nuevo profesor
        int codigo = 101;
        String nombre = "Juan Perez";
        String profesion = "Matemáticas";

        try {
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Consulta SQL para la inserción
            String sql = "INSERT INTO PROFESOR (CODIGO, NOMBRE, PROFESION) VALUES (?, ?, ?)";

            // Crear una declaración preparada
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                // Establecer los valores de los parámetros
                statement.setInt(1, codigo);
                statement.setString(2, nombre);
                statement.setString(3, profesion);

                // Ejecutar la inserción
                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Inserción exitosa.");
                } else {
                    System.out.println("No se pudo insertar el profesor.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}