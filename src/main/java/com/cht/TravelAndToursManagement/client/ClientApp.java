package com.cht.TravelAndToursManagement.client;

import com.cht.TravelAndToursManagement.client.controller.AuthController;
import com.cht.TravelAndToursManagement.client.navigation.ControllerFactory;
import com.cht.TravelAndToursManagement.client.navigation.NavigationService;
import com.cht.TravelAndToursManagement.client.repository.EmployeeRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ClientApp extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {

        // Navigation service
        ControllerFactory controllerFactory = new ControllerFactory();
        NavigationService navigationService = new NavigationService(primaryStage, controllerFactory);
    }

    public static void main(String[] args) {
        launch();
    }


}