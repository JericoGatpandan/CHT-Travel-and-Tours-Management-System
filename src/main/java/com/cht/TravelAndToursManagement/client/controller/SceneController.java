package com.cht.TravelAndToursManagement.client.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController {
    @FXML
    public BorderPane contentArea;

    protected void setCenter(String fxmlPath) {
        try {
            BorderPane page = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));


            contentArea.setCenter(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
