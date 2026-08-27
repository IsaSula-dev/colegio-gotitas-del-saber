package main.java.edu.mmcoffee.colegiogotitas.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.edu.mmcoffee.colegiogotitas.config.DataBaseConnection;
import main.java.edu.mmcoffee.colegiogotitas.dto.request.LoginRequest;
import main.java.edu.mmcoffee.colegiogotitas.dto.response.LoginResponse;

public class AuthRepository {
    
    private boolean sqlStatus = false;

    /*DIVIDE Y VENCERAS: Un método debe ser encargado
    de realizar una tarea especifica, el nombre de ese
    metodo debe ser modular, directo*/
    public LoginResponse findUserByEmail(LoginRequest loginRequest) throws Exception {
        String sql = "SELECT d.nombre, d.apellido, u.contrasena_hash "
                   + "FROM usuarios AS u "
                   + "RIGHT JOIN docentes AS d "
                   + "ON d.id_docente = u.id_docente "
                   + "WHERE u.email = ?";
        
        try (PreparedStatement pstm = DataBaseConnection.getConnectionDataBase().prepareStatement(sql)) {
            pstm.setString(1, loginRequest.getEmail());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new LoginResponse(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("contrasena_hash")
                );
            }
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR EMAIL: " + e.getMessage());
        }
        return null;
    }
    
}
