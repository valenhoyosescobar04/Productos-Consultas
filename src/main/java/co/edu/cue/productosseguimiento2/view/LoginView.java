package co.edu.cue.productosseguimiento2.view;
import javax.swing.*;
import java.awt.*;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginView extends GridPane {


        private TextField usernameField;
        private PasswordField passwordField;
        private Button loginButton;
        private Hyperlink createAccountLink;
        private Hyperlink needHelpLink;

        public LoginView() {
            // Configurar el GridPane
            this.setPadding(new Insets(20));
            this.setVgap(10);
            this.setHgap(10);
            this.setAlignment(Pos.CENTER);

            // Establecer un fondo de color
            BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(255, 245, 245), CornerRadii.EMPTY, Insets.EMPTY);
            this.setBackground(new Background(backgroundFill));

            // Título de la aplicación
            Label appTitle = new Label("PRODUCTOS");
            appTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            appTitle.setTextFill(Color.rgb(150, 75, 75));
            this.add(appTitle, 0, 0, 2, 1);
            GridPane.setHalignment(appTitle, HPos.CENTER);
            GridPane.setMargin(appTitle, new Insets(0, 0, 20, 0));

            // Sección de inicio de sesión
            Label loginTitle = new Label("Iniciar sesión");
            loginTitle.setFont(Font.font("Arial", FontWeight.BOLD, 28));
            loginTitle.setTextFill(Color.rgb(200, 100, 100));
            this.add(loginTitle, 0, 1, 2, 1);
            GridPane.setHalignment(loginTitle, HPos.CENTER);
            GridPane.setMargin(loginTitle, new Insets(0, 0, 10, 0));


            // Campos de usuario y contraseña
            Label usernameLabel = new Label("Usuario:");
            usernameField = new TextField();
            usernameField.setPromptText("Ingrese su usuario");
            usernameField.setStyle("-fx-background-color: #ffd6d6; -fx-border-radius: 10; -fx-background-radius: 10;");

            Label passwordLabel = new Label("Contraseña:");
            passwordField = new PasswordField();
            passwordField.setPromptText("Ingrese su contraseña");
            passwordField.setStyle("-fx-background-color: #ffd6d6; -fx-border-radius: 10; -fx-background-radius: 10;");

            this.add(usernameLabel, 0, 3);
            this.add(usernameField, 1, 3);
            this.add(passwordLabel, 0, 4);
            this.add(passwordField, 1, 4);

            // Botón de inicio de sesión
            loginButton = new Button("Ingresar");
            loginButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #e67373; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15; -fx-background-radius: 15;");
            this.add(loginButton, 1, 5);
            GridPane.setMargin(loginButton, new Insets(20, 0, 20, 0));

            // Enlaces de Crear Cuenta y Necesito Ayuda
            createAccountLink = new Hyperlink("Crear cuenta");
            needHelpLink = new Hyperlink("Necesita ayuda?");
            createAccountLink.setTextFill(Color.rgb(200, 100, 100));
            needHelpLink.setTextFill(Color.rgb(200, 100, 100));

            HBox linksBox = new HBox(10, createAccountLink, needHelpLink);
            linksBox.setAlignment(Pos.CENTER);
            this.add(linksBox, 1, 6);
            GridPane.setHalignment(linksBox, HPos.CENTER);
        }

        public TextField getUsernameField() {
            return usernameField;
        }

        public PasswordField getPasswordField() {
            return passwordField;
        }

        public Button getLoginButton() {
            return loginButton;
        }

        public Hyperlink getCreateAccountLink() {
            return createAccountLink;
        }

        public Hyperlink getNeedHelpLink() {
            return needHelpLink;
        }
    }
