package com.cht.TravelAndToursManagement.client.controller;

import com.cht.TravelAndToursManagement.client.navigation.FXMLPaths;
import com.cht.TravelAndToursManagement.client.navigation.Route;
import com.cht.TravelAndToursManagement.client.service.DashboardService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

public class MainLayoutController {
    private static final Logger logger = LoggerFactory.getLogger(MainLayoutController.class);

    private final DashboardService dashboardService;

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

    public MainLayoutController(DashboardService dashboardService, com.cht.TravelAndToursManagement.client.navigation.NavigationService navigationService) {
        this.dashboardService = dashboardService;
    }

    /**
     * Swap the center content of the main layout while keeping the sidebar intact.
     */
    private void setCenterContent(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(fxmlPath)));
            Node node = loader.load();
            if (contentArea != null) {
                contentArea.setCenter(node);
            }
        } catch (IOException e) {
            logger.error("Failed to load center content FXML: {}", fxmlPath, e);
            showError("Failed to load content");
        }
    }

    @FXML
    public void goToEmployee() {
        // Load Employee center content inside the existing main layout (sidebar preserved)
        setCenterContent(FXMLPaths.EMPLOYEE);
    }

    @FXML
    public void addBooking() {
        // Load first booking step inside the existing main layout (sidebar preserved)
        setCenterContent(FXMLPaths.BOOKING_STEP1);
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }
}
