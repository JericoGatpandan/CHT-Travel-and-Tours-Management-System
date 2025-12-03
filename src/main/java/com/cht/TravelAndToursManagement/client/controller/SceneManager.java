package com.cht.TravelAndToursManagement.client.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {

//    private static SceneManager instance;
//    private Stage primaryStage;

    // Cache FXML loaders
//    private final Map<String, FXMLLoader> loaderCache = new HashMap<>();
//
//    private SceneManager() {
//    }
//
//    public static SceneManager getInstance() {
//        if (instance == null) instance = new SceneManager();
//        return instance;
//    }
//
//    public void setStage(Stage stage) {
//        this.primaryStage = stage;
//    }

    // Switch scene and reuse controller
//    public void switchScene(String fxmlPath) {
//        try {
//            FXMLLoader loader = loaderCache.computeIfAbsent(fxmlPath, path -> {
//                FXMLLoader l = new FXMLLoader(getClass().getResource(path));
//                try {
//                    l.load(); // load FXML only once
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return l;
//            });
//
//            Parent root = loader.getRoot();
//            primaryStage.setScene(new Scene(root));
//            primaryStage.show();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    private Map<String, FXMLLoader> loaderCache = new HashMap<>();
//
//    private void setCenter(String fxmlPath) {
//        try {
//            FXMLLoader loader = loaderCache.computeIfAbsent(fxmlPath, path -> {
//                FXMLLoader fx = new FXMLLoader(getClass().getResource(path));
//                try {
//                    fx.load();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return fx;
//            });
//            contentArea.getChildren().setAll(loader.getRoot());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
