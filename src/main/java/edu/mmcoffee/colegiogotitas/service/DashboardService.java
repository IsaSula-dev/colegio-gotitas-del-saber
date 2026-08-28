package main.java.edu.mmcoffee.colegiogotitas.service;

import javafx.collections.ObservableList;
import main.java.edu.mmcoffee.colegiogotitas.model.Estudiante;
import main.java.edu.mmcoffee.colegiogotitas.repository.EstudianteRepository;
import java.sql.SQLException;

public class DashboardService {

    private EstudianteRepository estudianteRepository;

    public DashboardService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public ObservableList<Estudiante> listStudent() throws SQLException {
        if (estudianteRepository.findAll() == null) {
            throw new RuntimeException("Sin datos que mostrar");
        } else {
            return estudianteRepository.findAll();
        }
    }

}
