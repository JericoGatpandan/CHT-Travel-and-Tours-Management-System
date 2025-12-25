package com.cht.TravelAndToursManagement.navigation;

public final class FXMLPaths {
    private FXMLPaths() {
    }

    // Main layout shell that contains the sidebar and center content area
    public static final String MAIN_LAYOUT = "/com/cht/TravelAndToursManagement/view/MainLayout-view.fxml";

    // Route mappings
    public static final String LOGIN = "/com/cht/TravelAndToursManagement/view/auth/Login-view.fxml";
    public static final String DASHBOARD = MAIN_LAYOUT;
    public static final String EMPLOYEE = "/com/cht/TravelAndToursManagement/view/Employee-view.fxml";
    public static final String REGISTER = "/com/cht/TravelAndToursManagement/view/auth/Register-view.fxml";

    public static final String SIDEBAR = "/com/cht/TravelAndToursManagement/view/reusableComponents/Sidebar-view.fxml";

    public static final String BOOKING = "/com/cht/TravelAndToursManagement/view/booking/Booking-view.fxml";
    public static final String BOOKING_STEP1 = "/com/cht/TravelAndToursManagement/view/booking/AddBooking1-view.fxml";
    public static final String BOOKING_STEP2 = "/com/cht/TravelAndToursManagement/view/booking/AddBooking2-view.fxml";

}
