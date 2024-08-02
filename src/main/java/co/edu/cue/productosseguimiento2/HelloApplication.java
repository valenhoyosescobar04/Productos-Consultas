package co.edu.cue.productosseguimiento2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import co.edu.cue.productosseguimiento2.controller.LoginController;
import co.edu.cue.productosseguimiento2.controller.ProductosController;
import co.edu.cue.productosseguimiento2.view.LoginView;
import co.edu.cue.productosseguimiento2.view.ProductosView;
import javax.swing.*;

public class HelloApplication extends Application {


    @Override
    public void start(Stage primaryStage) {
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView, primaryStage);

        Scene scene = new Scene(loginView, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inicio de Sesión");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
