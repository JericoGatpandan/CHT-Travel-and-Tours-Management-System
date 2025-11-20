    package com.cht.TravelAndToursManagement;

    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import javafx.stage.StageStyle;

    import java.io.IOException;
    import java.util.Objects;


    public class MainApplication extends Application {


        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("view/Login.fxml")));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 600, 400);
            stage.setTitle("Travel and Tours Management System");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }



    }