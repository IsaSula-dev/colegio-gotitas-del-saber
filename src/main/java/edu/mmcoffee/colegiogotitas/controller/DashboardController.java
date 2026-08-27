
package main.java.edu.mmcoffee.colegiogotitas.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import main.java.edu.mmcoffee.colegiogotitas.service.DashboardService;
import main.java.edu.mmcoffee.colegiogotitas.util.SceneManager;


public class DashboardController implements Initializable {
    
    private DashboardService dashboardService;
    private SceneManager sceneManager;

    public DashboardController(DashboardService dashboardService, SceneManager sceneManager) {
        this.dashboardService = dashboardService;
        this.sceneManager = sceneManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
