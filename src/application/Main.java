package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
    @Override

    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Main.fxml"));
        Scene scene = new Scene(root, 300, 300);
        scene.getStylesheets().add("/views/application.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("LAB 5 - Ref. i Adn.");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(Main.class, args);
    }
}