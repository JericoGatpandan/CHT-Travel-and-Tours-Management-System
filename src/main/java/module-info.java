module com.cht.TravelAndToursManagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.j;

    opens com.cht.TravelAndToursManagement.controller to javafx.fxml;
    exports com.cht.TravelAndToursManagement;
}
