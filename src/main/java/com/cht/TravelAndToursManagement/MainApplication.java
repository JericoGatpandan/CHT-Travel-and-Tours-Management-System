package com.cht.TravelAndToursManagement;

import com.cht.TravelAndToursManagement.config.DatabaseConfig;
import com.cht.TravelAndToursManagement.controller.*;
import com.cht.TravelAndToursManagement.controller.booking.BookingController;
import com.cht.TravelAndToursManagement.controller.booking.BookingStep1Controller;
import com.cht.TravelAndToursManagement.navigation.ControllerFactory;
import com.cht.TravelAndToursManagement.navigation.NavigationService;
import com.cht.TravelAndToursManagement.navigation.Route;
import com.cht.TravelAndToursManagement.repository.BookingRepository;
import com.cht.TravelAndToursManagement.repository.ClientRepository;
import com.cht.TravelAndToursManagement.repository.EmployeeRepository;
import com.cht.TravelAndToursManagement.repository.impl.BookingRepositoryImpl;
import com.cht.TravelAndToursManagement.repository.impl.ClientRepositoryImpl;
import com.cht.TravelAndToursManagement.repository.impl.EmployeeRepositoryImpl;
import com.cht.TravelAndToursManagement.service.AuthenticationService;
import com.cht.TravelAndToursManagement.service.DashboardService;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import javax.sql.DataSource;


public class MainApplication extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Create infrastructure
            DataSource dataSource = DatabaseConfig.getDataSource();

            // Create repositories
            EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(dataSource);
            BookingRepository bookingRepository = new BookingRepositoryImpl(dataSource);
            ClientRepository clientRepository = new ClientRepositoryImpl(dataSource);

            // Create services
            AuthenticationService authService = new AuthenticationService(employeeRepository);
            DashboardService dashboardService = new DashboardService(bookingRepository, clientRepository);

            // Create controller factory and navigation service
            ControllerFactory controllerFactory = new ControllerFactory();
            NavigationService navigationService = new NavigationService(primaryStage, controllerFactory);

            // Register controllers
            controllerFactory.registerController(AuthController.class, new AuthController(authService, navigationService));
            controllerFactory.registerController(MainLayoutController.class, new MainLayoutController(dashboardService, navigationService));
            controllerFactory.registerController(EmployeeController.class, new EmployeeController(employeeRepository, navigationService));
            controllerFactory.registerController(BookingController.class, new BookingController(dashboardService, navigationService, controllerFactory));
            controllerFactory.registerController(SidebarController.class, new SidebarController(navigationService, controllerFactory));
            controllerFactory.registerController(BookingStep1Controller.class, new BookingStep1Controller(navigationService, clientRepository));

            // Start navigation
            navigationService.navigateTo(Route.LOGIN);

            primaryStage.setTitle("CHT Travel & Tours");
            primaryStage.show();

        } catch (Exception e) {
            showErrorDialog("Failed to start application", e);
        }
    }

    private void showErrorDialog(String message, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }


}