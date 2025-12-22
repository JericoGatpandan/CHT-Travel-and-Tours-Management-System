package com.cht.TravelAndToursManagement.controller.booking;

import com.cht.TravelAndToursManagement.controller.MainLayoutController;
import com.cht.TravelAndToursManagement.navigation.ControllerFactory;
import com.cht.TravelAndToursManagement.navigation.FXMLPaths;
import com.cht.TravelAndToursManagement.navigation.NavigationService;
import com.cht.TravelAndToursManagement.service.DashboardService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookingController extends MainLayoutController implements Initializable {

    public Button cancelButton;
    public Button nextButton;
    @FXML
    private Button closeButton;
    @FXML
    private Button addBookingButton;

    private final ControllerFactory controllerFactory;


    public BookingController(DashboardService dashboardService, NavigationService navigationService, ControllerFactory controllerFactory) {
        super(dashboardService, navigationService);
        this.controllerFactory = controllerFactory;
    }


    public void addBooking() {
        try {
            Stage owner = (Stage) addBookingButton.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLPaths.BOOKING_STEP1));
            loader.setControllerFactory(controllerFactory);
            Parent modalRoot = loader.load();

            Stage modalStage = new Stage();
            modalStage.setTitle("Add New Booking");

            modalStage.initOwner(owner);
            modalStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(modalRoot);

            modalStage.setScene(scene);
            scene.setUserAgentStylesheet("/com/cht/TravelAndToursManagement/view/css/styles.css");
            modalStage.setMinWidth(1000);
            modalStage.setMinHeight(800);
            modalStage.centerOnScreen();

            modalStage.showAndWait();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addBookingButton.setOnAction(actionEvent -> {
            addBooking();
        });


    }

}
