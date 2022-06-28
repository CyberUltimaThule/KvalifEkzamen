package com.example.demo4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class window9 extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(window9.class.getResource("window9.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Window 9");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void showWindow() throws Exception {
        start(stage);
    }
}