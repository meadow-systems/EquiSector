package org.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {

        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label message = new Label("Hello World!");
        Scene scene = new Scene(message);

        stage.setTitle("Title bar");
        stage.setScene(scene);
        stage.show();
    }
}