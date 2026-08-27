package main.java.edu.mmcoffee.colegiogotitas.service;

import main.java.edu.mmcoffee.colegiogotitas.repository.DashboardRepository;

public class DashboardService {
    
    private DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }
    
}
