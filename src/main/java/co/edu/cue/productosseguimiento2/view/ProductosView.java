package co.edu.cue.productosseguimiento2.view;

import co.edu.cue.productosseguimiento2.model.Producto;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.awt.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.swing.*;


public class ProductosView extends VBox {


        private TableView<Producto> tablaProductos;
        private Button btnConsultar;
        private Button btnListarProductos;
        private Button btnMostrarProductosCaros;
        private Button btnLacteos;
        private Button btnPasillo2;
        private Button btnPrimerosProductos;
        private Button btnNombreComienzaA;
        private Button btnBuscarArroz;
        private Button btnSinUbicacion;
        private Button btnSalir;
        private TextField txtNombre;
        private TextField txtPrecio;
        private TextField txtUbicacion;

        public ProductosView() {
            this.setPadding(new Insets(20));
            this.setSpacing(10);
            this.setStyle("-fx-background-color: #FFF0F0;");
            this.setAlignment(Pos.CENTER);

            // Campos de búsqueda
            txtNombre = new TextField();
            txtNombre.setPromptText("Nombre");
            txtPrecio = new TextField();
            txtPrecio.setPromptText("Precio");
            txtUbicacion = new TextField();
            txtUbicacion.setPromptText("Ubicación");

            HBox searchBox = new HBox(10);
            searchBox.setAlignment(Pos.CENTER);
            searchBox.getChildren().addAll(
                    new Label("Nombre:"), txtNombre,
                    new Label("Precio:"), txtPrecio,
                    new Label("Ubicación:"), txtUbicacion
            );

            btnConsultar = new Button("Consultar Productos");
            btnConsultar.setStyle("-fx-background-color: #e67373; -fx-text-fill: #ffffff; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15; -fx-background-radius: 15;");

            // Botones para consultas específicas
            btnListarProductos = new Button("Listar Productos");
            btnListarProductos.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #e67373; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15; -fx-background-radius: 15;");

            btnMostrarProductosCaros = new Button("Productos > $10,000");
            btnMostrarProductosCaros.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #e67373; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15; -fx-background-radius: 15;");

            btnLacteos = new Button("Lácteos");
            btnLacteos.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #e67373; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15; -fx-background-radius: 15;");

            btnPasillo2 = new Button("Pasillo 2");
            btnPasillo2.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #e67373; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15; -fx-background-radius: 15;");

            btnPrimerosProductos = new Button("Primeros 5 Productos");
            btnPrimerosProductos.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #e67373; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15; -fx-background-radius: 15;");

            btnNombreComienzaA = new Button("Nombre empieza con A");
            btnNombreComienzaA.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #e67373; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15; -fx-background-radius: 15;");

            btnBuscarArroz = new Button("Buscar 'Arroz'");
            btnBuscarArroz.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #e67373; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15; -fx-background-radius: 15;");

            btnSinUbicacion = new Button("Sin Ubicación");
            btnSinUbicacion.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #e67373; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15; -fx-background-radius: 15;");

            btnSalir = new Button("Salir");
            btnSalir.setStyle("-fx-background-color: #e67373; -fx-text-fill:#ffffff; -fx-font-size: 14px; -fx-font-weight: bold; -fx-border-radius: 15; -fx-background-radius: 15;");

            HBox buttonBox = new HBox(10);
            buttonBox.setAlignment(Pos.CENTER);
            buttonBox.getChildren().addAll(
                    btnListarProductos, btnMostrarProductosCaros, btnLacteos, btnPasillo2,
                    btnPrimerosProductos, btnNombreComienzaA, btnBuscarArroz, btnSinUbicacion
            );

            // Tabla de productos
            tablaProductos = new TableView<>();
            TableColumn<Producto, Number> colId = new TableColumn<>("ID");
            colId.setCellValueFactory(cellData -> cellData.getValue().idProductoProperty());

            TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
            colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());

            TableColumn<Producto, Number> colPrecio = new TableColumn<>("Precio");
            colPrecio.setCellValueFactory(cellData -> cellData.getValue().precioProperty());

            TableColumn<Producto, String> colTipo = new TableColumn<>("Tipo");
            colTipo.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());

            TableColumn<Producto, String> colUbicacion = new TableColumn<>("Ubicación");
            colUbicacion.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());

            tablaProductos.getColumns().addAll(colId, colNombre, colPrecio, colTipo, colUbicacion);

            // Estilo de textos y botones
            Label title = new Label("PRODUCTOS");
            title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            title.setAlignment(Pos.CENTER);
            title.setStyle("-fx-text-fill: #C71585;");

            Label createdBy = new Label("Trabajo Realizado por: Valentina Hoyos Escobar\nCiudad: Armenia, Quindío\nAño: 2024");
            createdBy.setTextAlignment(TextAlignment.LEFT);
            createdBy.setStyle("-fx-text-fill: #8B0000;");


            this.getChildren().addAll(title, searchBox, btnConsultar, buttonBox, tablaProductos, createdBy, btnSalir);
            this.setAlignment(Pos.CENTER);
        }

        public TextField getTxtNombre() {
            return txtNombre;
        }

    public TextField getTxtPrecio() {
        return txtPrecio;
    }

    public TextField getTxtUbicacion() {
        return txtUbicacion;
    }


        public TableView<Producto> getTablaProductos() {
            return tablaProductos;
        }

        public Button getBtnConsultar() {
            return btnConsultar;
        }

        public Button getBtnListarProductos() {
            return btnListarProductos;
        }

        public Button getBtnMostrarProductosCaros() {
            return btnMostrarProductosCaros;
        }

        public Button getBtnLacteos() {
            return btnLacteos;
        }

        public Button getBtnPasillo2() {
            return btnPasillo2;
        }

        public Button getBtnPrimerosProductos() {
            return btnPrimerosProductos;
        }

        public Button getBtnNombreComienzaA() {
            return btnNombreComienzaA;
        }

        public Button getBtnBuscarArroz() {
            return btnBuscarArroz;
        }

        public Button getBtnSinUbicacion() {
            return btnSinUbicacion;
        }

        public Button getBtnSalir() {
            return btnSalir;
        }

}
