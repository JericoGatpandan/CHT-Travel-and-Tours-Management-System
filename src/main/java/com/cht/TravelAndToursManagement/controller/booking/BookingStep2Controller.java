package com.cht.TravelAndToursManagement.controller.booking;

import com.cht.TravelAndToursManagement.navigation.NavigationService;
import com.cht.TravelAndToursManagement.repository.ClientRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene. control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;

public class BookingStep2Controller {

    @FXML
    private Button closeButton;

    @FXML
    private Button nextButton;

    @FXML
    private GridPane packageGrid;

    @FXML
    private ImageView packageImage1;

    @FXML
    private ImageView packageImage2;

    @FXML
    private ImageView packageImage3;

    private String selectedPackageId;

    public BookingStep2Controller(NavigationService navigationService, ClientRepository clientRepository) {

    }

    @FXML
    public void initialize() {
        // TODO: Initialize component
        // Load packages from database/service
        // Set up responsive grid columns
        setupResponsiveGrid();
        loadPackages();
    }

    private void setupResponsiveGrid() {
        // TODO: Configure responsive grid layout
        // Adjust columns based on window size
        System.out.println("Setting up responsive grid.. .");
    }

    private void loadPackages() {
        // TODO: Load tour packages from service/database
        // Populate package cards dynamically
        System.out.println("Loading tour packages...");
    }

    @FXML
    private void handleClose() {
        // TODO: Close dialog with confirmation
        // Ask user if they want to save draft
        System.out.println("Closing dialog...");
    }

    @FXML
    private void handleViewDetails1() {
        // TODO: Show detailed view of Tropical Paradise package
        System.out.println("Viewing details for Tropical Paradise Escape...");
        showPackageDetails("tropical-paradise-001");
    }

    @FXML
    private void handleViewDetails2() {
        // TODO: Show detailed view of Mountain Adventure package
        System.out.println("Viewing details for Mountain Adventure Trek...");
        showPackageDetails("mountain-adventure-002");
    }

    @FXML
    private void handleViewDetails3() {
        // TODO: Show detailed view of European City package
        System.out.println("Viewing details for European City Explorer.. .");
        showPackageDetails("european-city-003");
    }

    @FXML
    private void handleSelectPackage1() {
        // TODO: Select Tropical Paradise package
        System.out.println("Selected:  Tropical Paradise Escape");
        selectPackage("tropical-paradise-001");
    }

    @FXML
    private void handleSelectPackage2() {
        // TODO: Select Mountain Adventure package
        System.out.println("Selected: Mountain Adventure Trek");
        selectPackage("mountain-adventure-002");
    }

    @FXML
    private void handleSelectPackage3() {
        // TODO: Select European City package
        System.out.println("Selected: European City Explorer");
        selectPackage("european-city-003");
    }

    private void selectPackage(String packageId) {
        // TODO: Store selected package
        // Enable next button
        // Highlight selected card
        this.selectedPackageId = packageId;
        nextButton.setDisable(false);
        highlightSelectedCard(packageId);
    }

    private void showPackageDetails(String packageId) {
        // TODO: Open modal/dialog with full package details
        // Show itinerary, inclusions, exclusions, etc.
        System. out.println("Showing details for package: " + packageId);
    }

    private void highlightSelectedCard(String packageId) {
        // TODO: Add visual feedback for selected package
        // Update card styling
        System.out.println("Highlighting package card: " + packageId);
    }

    @FXML
    private void handleBack() {
        // TODO: Navigate back to Step 1 (Customer Information)
        // Save current selection as draft
        System.out.println("Navigating back to Customer step...");
    }

    @FXML
    private void handleNextStep() {
        // TODO: Validate selection
        // Navigate to Step 3 (Travel Details)
        // Pass selected package data
        if (selectedPackageId != null) {
            System.out.println("Proceeding to Travel Details with package: " + selectedPackageId);
            navigateToTravelDetails();
        }
    }

    private void navigateToTravelDetails() {
        // TODO: Load Step 3 view
        // Pass booking context
        System.out.println("Loading Travel Details view...");
    }

    public void handleSelectPackage(ActionEvent actionEvent) {
    }

    public void handleNext(ActionEvent actionEvent) {
    }
    public void handleClose(ActionEvent actionEvent) {
    }
}
