package com.cht.TravelAndToursManagement.controller.booking;

import com.cht.TravelAndToursManagement.navigation.NavigationService;
import javafx.fxml.FXML;
import javafx.fxml. Initializable;
import javafx. scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BookingStep1Controller implements Initializable {

    @FXML
    private Button closeButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button nextButton;

    @FXML
    private VBox existingCustomerCard;

    @FXML
    private VBox newCustomerCard;

    private String selectedCustomerType = null;
    private final NavigationService navigationService;

    public BookingStep1Controller(NavigationService navigationService) {
        this.navigationService = navigationService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupCardHoverEffects();
        updateNextButtonState();
    }

    private void setupCardHoverEffects() {
        // Existing Customer Card Hover
        existingCustomerCard.setOnMouseEntered(event -> {
            if (selectedCustomerType == null || !selectedCustomerType.equals("existing")) {
                existingCustomerCard.setStyle(
                        "-fx-border-color: #0066CC; " +
                                "-fx-border-radius: 8; " +
                                "-fx-border-width: 2; " +
                                "-fx-padding: 24; " +
                                "-fx-background-color: #F0F7FF; " +
                                "-fx-background-radius:  8; " +
                                "-fx-cursor: hand; " +
                                "-fx-effect: dropshadow(gaussian, rgba(0, 102, 204, 0.2), 8, 0, 0, 4);"
                );
            }
        });

        existingCustomerCard.setOnMouseExited(event -> {
            if (selectedCustomerType == null || !selectedCustomerType.equals("existing")) {
                existingCustomerCard.setStyle(
                        "-fx-border-color: #E0E0E0; " +
                                "-fx-border-radius: 8; " +
                                "-fx-border-width: 1; " +
                                "-fx-padding: 24; " +
                                "-fx-background-color:  white; " +
                                "-fx-background-radius: 8; " +
                                "-fx-cursor: hand;"
                );
            }
        });

        // New Customer Card Hover
        newCustomerCard.setOnMouseEntered(event -> {
            if (selectedCustomerType == null || !selectedCustomerType.equals("new")) {
                newCustomerCard.setStyle(
                        "-fx-border-color:  #0066CC; " +
                                "-fx-border-radius: 8; " +
                                "-fx-border-width:  2; " +
                                "-fx-padding: 24; " +
                                "-fx-background-color: #F0F7FF; " +
                                "-fx-background-radius: 8; " +
                                "-fx-cursor: hand; " +
                                "-fx-effect:  dropshadow(gaussian, rgba(0, 102, 204, 0.2), 8, 0, 0, 4);"
                );
            }
        });

        newCustomerCard.setOnMouseExited(event -> {
            if (selectedCustomerType == null || ! selectedCustomerType.equals("new")) {
                newCustomerCard.setStyle(
                        "-fx-border-color: #E0E0E0; " +
                                "-fx-border-radius: 8; " +
                                "-fx-border-width: 1; " +
                                "-fx-padding: 24; " +
                                "-fx-background-color: white; " +
                                "-fx-background-radius: 8; " +
                                "-fx-cursor:  hand;"
                );
            }
        });
    }

    @FXML
    private void selectExistingCustomer(MouseEvent event) {
        selectedCustomerType = "existing";
        updateCardSelection();
    }

    @FXML
    private void selectNewCustomer(MouseEvent event) {
        selectedCustomerType = "new";
        updateCardSelection();
    }

    private void updateCardSelection() {
        if (selectedCustomerType.equals("existing")) {
            existingCustomerCard.setStyle(
                    "-fx-border-color: #0066CC; -fx-border-radius: 8; -fx-border-width:  2; " +
                            "-fx-padding: 24; -fx-background-color: #E8F4FD; -fx-background-radius: 8; -fx-cursor: hand;"
            );
            newCustomerCard.setStyle(
                    "-fx-border-color: #E0E0E0; -fx-border-radius:  8; -fx-border-width: 1; " +
                            "-fx-padding: 24; -fx-background-color: white; -fx-background-radius: 8; -fx-cursor: hand;"
            );
        } else if (selectedCustomerType.equals("new")) {
            newCustomerCard.setStyle(
                    "-fx-border-color: #0066CC; -fx-border-radius: 8; -fx-border-width: 2; " +
                            "-fx-padding: 24; -fx-background-color:  #E8F4FD; -fx-background-radius: 8; -fx-cursor: hand;"
            );
            existingCustomerCard.setStyle(
                    "-fx-border-color: #E0E0E0; -fx-border-radius: 8; -fx-border-width:  1; " +
                            "-fx-padding: 24; -fx-background-color: white; -fx-background-radius:  8; -fx-cursor:  hand;"
            );
        }
        updateNextButtonState();
    }

    private void updateNextButtonState() {
        nextButton.setDisable(selectedCustomerType == null);
        nextButton.setStyle(selectedCustomerType != null
                ? "-fx-padding: 10 16; -fx-font-family: 'Inter'; -fx-font-size: 14; -fx-font-weight:  500; -fx-text-fill: white; -fx-background-color: #0066CC; -fx-border-radius: 6; -fx-cursor: hand;"
                : "-fx-padding: 10 16; -fx-font-family: 'Inter'; -fx-font-size:  14; -fx-font-weight: 500; -fx-text-fill: #999999; -fx-background-color: #CCCCCC; -fx-border-radius: 6; -fx-cursor: default;"
        );
    }

    @FXML
    private void handleClose() {
        closeStage();
    }

    @FXML
    private void handleCancel() {
        closeStage();
    }

    @FXML
    private void handleNextStep() {
        if (selectedCustomerType == null) return;
        System.out.println("Proceeding with: " + selectedCustomerType + " customer");
//         navigationService.navigateTo(Route. BOOKING_STEP2);
        closeStage();
    }

    private void closeStage() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public String getSelectedCustomerType() {
        return selectedCustomerType;
    }
}