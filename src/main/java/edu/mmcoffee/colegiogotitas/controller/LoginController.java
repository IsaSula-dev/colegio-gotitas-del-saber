package main.java.edu.mmcoffee.colegiogotitas.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import main.java.edu.mmcoffee.colegiogotitas.config.DataBaseConnection;
import main.java.edu.mmcoffee.colegiogotitas.dto.request.LoginRequest;
import main.java.edu.mmcoffee.colegiogotitas.dto.response.LoginResponse;
import main.java.edu.mmcoffee.colegiogotitas.service.AuthService;
import main.java.edu.mmcoffee.colegiogotitas.util.SceneManager;

public class LoginController implements Initializable {

    private final AuthService authService;
    private final SceneManager sceneManager;

    @FXML
    private TextField txtFieldEmail;
    @FXML
    private TextField txtFieldPass;

    public LoginController(AuthService authService, SceneManager sceneManager) {
        this.authService = authService;
        this.sceneManager = sceneManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("TODO LO QUE ESTE ACÁ SE EJECUTA CUANDO SE MUESTRA LA VISTA");
    }

    public void handleLogin() throws Exception {
        if (txtFieldEmail.getText().isEmpty() || txtFieldPass.getText().isEmpty()) {
            sceneManager.showInfoAlert("CAMPOS FALTANTES", "Revisar Informacion", "Uno de los campo está vaacio", Alert.AlertType.CONFIRMATION);
        } else {
            try{
                LoginResponse responseService = authService.login(new LoginRequest(txtFieldEmail.getText(), txtFieldPass.getText()));
                LoginResponse userLogged = new LoginResponse(responseService.getNombre(), responseService.getApellido()); 
                sceneManager.showDashboardView();
            }catch(RuntimeException e){
                e.printStackTrace();
                sceneManager.showInfoAlert("DATOS INCORRECTOS", "REVISA TU INFORMACION", "intenta de Nuevo", Alert.AlertType.INFORMATION);
            
            }
        }
    }

}
