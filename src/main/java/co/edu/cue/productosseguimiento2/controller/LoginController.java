package co.edu.cue.productosseguimiento2.controller;

import co.edu.cue.productosseguimiento2.view.LoginView;
import co.edu.cue.productosseguimiento2.view.ProductosView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class LoginController {


        private LoginView loginView;

        public LoginController(LoginView loginView, Stage primaryStage) {
            this.loginView = loginView;
            initializeListeners();
        }

        private void initializeListeners() {
            loginView.getLoginButton().setOnAction(e -> handleLogin());
        }

        private void handleLogin() {
            String username = loginView.getUsernameField().getText();
            String password = loginView.getPasswordField().getText();

            if ("Valen".equals(username) && "2828".equals(password)) {
                showAlert("Éxito", "Inicio de sesión exitoso", Alert.AlertType.INFORMATION);
                openProductosWindow();
            } else {
                showAlert("Error", "Usuario o contraseña incorrectos", Alert.AlertType.ERROR);
            }
        }

        private void showAlert(String title, String content, Alert.AlertType alertType) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            alert.showAndWait();
        }

        private void openProductosWindow() {
            ProductosView productosView = new ProductosView();
            ProductosController productosController = new ProductosController(productosView);
            Stage productosStage = new Stage();
            productosStage.setTitle("Consulta de Productos");
            productosStage.setScene(new Scene(productosView, 700, 400));
            productosStage.show();
            // Cerrar la ventana de login
            ((Stage) loginView.getScene().getWindow()).close();
        }
    }

