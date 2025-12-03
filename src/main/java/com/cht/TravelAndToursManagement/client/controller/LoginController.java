package com.cht.TravelAndToursManagement.client.controller;


import com.cht.TravelAndToursManagement.client.config.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {
    @FXML
    private BorderPane loginContainer;

    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    public void loginButton() throws IOException {
        loginMessageLabel.setText("You try to Login!");

        if (!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Username or Password is empty!");
        }
        // Stage stage = (Stage) loginContainer.getScene().getWindow();
        // stage.setMaximized(true);

    }

    public void cancelButton() throws IOException {
        Stage stage = (Stage) loginContainer.getScene().getWindow();
        stage.close();

    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT COUNT(1) FROM Employee WHERE Username = '" + usernameTextField.getText() + "' AND Password = '" + passwordPasswordField.getText() + "';";


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cht/TravelAndToursManagement/view/MainLayout-view.fxml"));
                        BorderPane mainRoot = loader.load();
                        Scene mainScene = new Scene(mainRoot, 1200, 800);
                        Stage stage = (Stage) loginButton.getScene().getWindow(); // reuse stage
                        stage.setScene(mainScene);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                    loginMessageLabel.setText("Login Successfully!");
                } else {
                    loginMessageLabel.setText("Invalid Login. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
