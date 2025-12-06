package com.cht.TravelAndToursManagement.client.controller;

import com.cht.TravelAndToursManagement.client.config.DatabaseConnection;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.Connection;
import java.util.Objects;

public class DashboardController {
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
    public void addBookingStep3() throws IOException {
        setCenter("/com/cht/TravelAndToursManagement/view/AddBooking3-view.fxml");
    }
    @FXML
    public void addBookingStep4() throws IOException {
        setCenter("/com/cht/TravelAndToursManagement/view/AddBooking4-view.fxml");
    }
    @FXML
    public void addBookingStep5() throws IOException {
        setCenter("/com/cht/TravelAndToursManagement/view/AddBooking5-view.fxml");
    }

    @FXML
    public void goToDashboard() throws IOException {
        setCenter("/com/cht/TravelAndToursManagement/view/Dashboard-view.fxml");
    }

    public void displayTrips() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String tripsQuery = "SELECT\n" +
                "    trip.Trip_ID,\n" +
                "    customer.Name AS CustomerName,\n" +
                "    package.Name AS PackageName,\n" +
                "    package.Destination,\n" +
                "    trip.StartDate,\n" +
                "    trip.EndDate,\n" +
                "    trip.IsActive\n" +
                "FROM customer\n" +
                "INNER JOIN booking\n" +
                "    ON customer.Customer_ID = booking.Customer_ID\n" +
                "INNER JOIN package\n" +
                "    ON booking.Package_ID = package.Package_ID\n" +
                "INNER JOIN package_trips\n" +
                "    ON package.Package_ID = package_trips.Package_ID\n" +
                "INNER JOIN trip\n" +
                "    ON package_trips.Trip_ID = trip.Trip_ID;";



    }

}
