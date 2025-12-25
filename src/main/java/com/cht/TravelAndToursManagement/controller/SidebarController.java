package com.cht.TravelAndToursManagement.controller;

import com.cht.TravelAndToursManagement.navigation.ControllerFactory;
import com.cht.TravelAndToursManagement.navigation.FXMLPaths;
import com.cht.TravelAndToursManagement.navigation.NavigationService;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SidebarController {

    @FXML
    private BorderPane root;

    @FXML
    private VBox titleBox;

    @FXML
    private VBox profileBox;

    private boolean collapsed = false;

    protected final NavigationService navigationService;

    public SidebarController(NavigationService navigationService, ControllerFactory controllerFactory) {
        this.navigationService = navigationService;
    }

    @FXML
    private void toggleSidebar() {
        collapsed = !collapsed;

        if (collapsed) {
            root.setPrefWidth(80);
            titleBox.setVisible(false);
            profileBox.setVisible(false);
        } else {
            root.setPrefWidth(280);
            titleBox.setVisible(true);
            profileBox.setVisible(true);
        }
    }

    @FXML
    private void onDashboard() {
        System.out.println("Dashboard clicked");
    }

//    @FXML
//    public void goToEmployee() {
//        navigationService.setCenterContent(FXMLPaths.EMPLOYEE);
//    }

    @FXML
    public void goToBookingView() {
        navigationService.setCenterContent(FXMLPaths.BOOKING);
    }

}
