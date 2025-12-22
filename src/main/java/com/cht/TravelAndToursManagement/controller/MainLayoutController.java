package com.cht.TravelAndToursManagement.controller;

import com.cht.TravelAndToursManagement.navigation.NavigationService;
import com.cht.TravelAndToursManagement.service.DashboardService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainLayoutController {
    public static final Logger logger = LoggerFactory.getLogger(MainLayoutController.class);

    protected final DashboardService dashboardService;
    protected final NavigationService navigationService;


    // Root BorderPane from MainLayout-view.fxml (sidebar + center area)
    @FXML
    private BorderPane contentArea;

    @FXML
    public Label totalCustomer;
    @FXML
    public Label ongoingTrips;
    @FXML
    public Label upcomingTrips;
    @FXML
    public Label completedTrips;

    @FXML
    public Button addBookingButton;


    public MainLayoutController(DashboardService dashboardService, NavigationService navigationService) {
        this.dashboardService = dashboardService;
        this.navigationService = navigationService;
    }





}
