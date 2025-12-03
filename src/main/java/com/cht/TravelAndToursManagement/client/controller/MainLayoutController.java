package com.cht.TravelAndToursManagement.client.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class MainLayoutController {
    @FXML
    public BorderPane contentArea;

    private void setCenter(String fxmlPath) {
        try {
            BorderPane page = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
            contentArea.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addBooking() throws IOException {
        setCenter("/com/cht/TravelAndToursManagement/view/AddBooking1-view.fxml");

    }

    @FXML
    public void addBookingStep2() throws IOException {
        setCenter("/com/cht/TravelAndToursManagement/view/AddBooking2-view.fxml");
    }

    @FXML
    public void goToDashboard() throws IOException {
        setCenter("/com/cht/TravelAndToursManagement/view/MainLayout-view.fxml");
    }
}
