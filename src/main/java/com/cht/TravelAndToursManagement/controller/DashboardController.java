package com.cht.TravelAndToursManagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class DashboardController {
    @FXML
    public BorderPane DashboardContainer;


    public void addBooking() throws IOException {
        new SceneChanger(DashboardContainer, "view/AddBooking.fxml");

    }
    public void homeButton() throws IOException {
        new SceneChanger(DashboardContainer, "view/Home.fxml");

    }
}
