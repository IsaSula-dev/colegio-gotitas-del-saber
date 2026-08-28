package main.java.edu.mmcoffee.colegiogotitas.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.edu.mmcoffee.colegiogotitas.model.Estudiante;
import main.java.edu.mmcoffee.colegiogotitas.service.DashboardService;
import main.java.edu.mmcoffee.colegiogotitas.util.SceneManager;

public class DashboardController implements Initializable {
    
    private DashboardService dashboardService;
    private SceneManager sceneManager;
    
    @FXML
    private TableView<Estudiante> tvEstudiantes;
    @FXML
    private TableColumn<Estudiante, String> tvColumnIdEstudiante;
    @FXML
    private TableColumn<Estudiante, String> tvColumnNombreEstudiante;
    @FXML
    private TableColumn<Estudiante, String> tvColumnApellidoEstudiante;
    @FXML
    private TableColumn<Estudiante, String> tvColumnCorreo;
    @FXML
    private TableColumn<Estudiante, String> tvColumnSeccion;
    @FXML
    private TableColumn<Estudiante, String> tvColumnCurso;
    @FXML
    private TableColumn<Estudiante, String> tvColumnNombreDocente;
    @FXML
    private TableColumn<Estudiante, String> tvColumnApellidoDocente;
    
    public DashboardController(DashboardService dashboardService, SceneManager sceneManager) {
        this.dashboardService = dashboardService;
        this.sceneManager = sceneManager;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            handleLoadTableStudents();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }

    }
    
    private void handleLoadTableStudents()throws SQLException {
        tvColumnIdEstudiante.setCellValueFactory(new PropertyValueFactory<>("idEstudiante"));
        tvColumnNombreEstudiante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tvColumnApellidoEstudiante.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tvColumnCorreo.setCellValueFactory(new PropertyValueFactory<>("correoElectronico"));
        tvColumnSeccion.setCellValueFactory(new PropertyValueFactory<>("nombreSeccion"));
        tvColumnCurso.setCellValueFactory(new PropertyValueFactory<>("nombreCurso"));
        tvColumnNombreDocente.setCellValueFactory(new PropertyValueFactory<>("nombreDocente"));
        tvColumnApellidoDocente.setCellValueFactory(new PropertyValueFactory<>("apellidoDocente"));
        tvEstudiantes.setItems(dashboardService.listStudent());
    }
    
}
