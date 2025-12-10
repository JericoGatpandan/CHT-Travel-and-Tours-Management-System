package com.cht.TravelAndToursManagement.client.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;


public class NavigationService {
    private final Stage primaryStage;
    private final Map<Route, String> routeMap;
    private final ControllerFactory controllerFactory;

    public NavigationService(Stage primaryStage, ControllerFactory factory) {
        this.primaryStage = primaryStage;
        this.controllerFactory = factory;
        this.routeMap = initializedRoutes();
    }


    public void navigateTo(Route route) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(routeMap.get(route)));
            loader.setControllerFactory(controllerFactory);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            throw new NavigationException("Failed to navigate to " + route, e);
        }
    }
}

