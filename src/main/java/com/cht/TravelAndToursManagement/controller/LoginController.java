package com.cht.TravelAndToursManagement.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private StackPane loginContainer;

    public void loginButton(ActionEvent actionEvent) throws IOException {
        new SceneChanger(loginContainer,"view/Dashboard.fxml");
        Stage stage = (Stage) loginContainer.getScene().getWindow();
        stage.setMaximized(true);

    }









}
