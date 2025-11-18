package com.cht.TravelAndToursManagement.controller;

import com.cht.TravelAndToursManagement.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


import java.io.IOException;
import java.util.Objects;

public class SceneChanger {
    public SceneChanger(StackPane currentView, String fxml) throws IOException {
        Pane nextView = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource(fxml)));

        currentView.getChildren().setAll(nextView);

    }
    public SceneChanger(BorderPane currentView, String fxml) throws IOException {
        BorderPane nextView = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource(fxml)));
        currentView.getChildren().removeAll();
        currentView.setCenter(nextView);
    }




}
