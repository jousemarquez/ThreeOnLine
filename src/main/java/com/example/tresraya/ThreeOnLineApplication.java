package com.example.tresraya;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ThreeOnLineApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Una escena es una pantalla.
        FXMLLoader fxmlLoader = new FXMLLoader(ThreeOnLineApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 640);
        stage.setTitle("Título de la aplicación");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}