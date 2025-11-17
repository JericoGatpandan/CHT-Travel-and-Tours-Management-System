module com.cht.TravelAndToursManagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.cht.TravelAndToursManagement.controller to javafx.fxml;
    exports com.cht.TravelAndToursManagement;
}
