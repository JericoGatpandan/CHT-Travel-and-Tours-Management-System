module com.cht.TravelAndToursManagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.j;
    requires jdk.httpserver;
    requires org.slf4j;
    requires com.zaxxer.hikari;
    requires java.desktop;

    opens com.cht.TravelAndToursManagement.controller to javafx.fxml;
    exports com.cht.TravelAndToursManagement;
    opens com.cht.TravelAndToursManagement.utils to javafx.fxml;
    exports com.cht.TravelAndToursManagement.utils;
    exports com.cht.TravelAndToursManagement.model;
    opens com.cht.TravelAndToursManagement.model to javafx.fxml;
    exports com.cht.TravelAndToursManagement.controller;
    opens com.cht.TravelAndToursManagement.navigation to javafx.fxml;
    exports com.cht.TravelAndToursManagement.navigation;
    exports com.cht.TravelAndToursManagement.service;
    opens com.cht.TravelAndToursManagement.service to javafx.fxml;
    exports com.cht.TravelAndToursManagement.controller.booking;
    opens com.cht.TravelAndToursManagement.controller.booking to javafx.fxml;

}
