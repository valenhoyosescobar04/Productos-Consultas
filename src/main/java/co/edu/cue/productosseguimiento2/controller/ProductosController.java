package co.edu.cue.productosseguimiento2.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import co.edu.cue.productosseguimiento2.model.Producto;
import co.edu.cue.productosseguimiento2.util.DataBaseConnection;
import co.edu.cue.productosseguimiento2.view.ProductosView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.SQLException;

public class ProductosController {


        private ProductosView productosView;
        private ObservableList<Producto> productos = FXCollections.observableArrayList();

        public ProductosController(ProductosView productosView) {
            this.productosView = productosView;
            initializeListeners();
        }

        private void initializeListeners() {
            productosView.getBtnConsultar().setOnAction(e -> consultarProductos());
            productosView.getBtnListarProductos().setOnAction(e -> listarProductos());
            productosView.getBtnMostrarProductosCaros().setOnAction(e -> mostrarProductosCaros());
            productosView.getBtnLacteos().setOnAction(e -> obtenerLacteos());
            productosView.getBtnPasillo2().setOnAction(e -> listarProductosPasillo2());
            productosView.getBtnPrimerosProductos().setOnAction(e -> mostrarPrimerosProductos());
            productosView.getBtnNombreComienzaA().setOnAction(e -> consultarNombreComienzaA());
            productosView.getBtnBuscarArroz().setOnAction(e -> buscarArroz());
            productosView.getBtnSinUbicacion().setOnAction(e -> obtenerProductosSinUbicacion());
            productosView.getBtnSalir().setOnAction(e -> Platform.exit());
        }

        private void consultarProductos() {
            productos.clear();
            String nombre = productosView.getTxtNombre().getText().trim();
            String precioStr = productosView.getTxtPrecio().getText().trim();
            String ubicacion = productosView.getTxtUbicacion().getText().trim();
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM productos WHERE 1=1");
            List<Object> parameters = new ArrayList<>();

            if (!nombre.isEmpty()) {
                queryBuilder.append(" AND nombre LIKE ?");
                parameters.add("%" + nombre + "%");
            }
            if (!precioStr.isEmpty()) {
                queryBuilder.append(" AND precio > ?");
                try {
                    double precio = Double.parseDouble(precioStr);
                    parameters.add(precio);
                } catch (NumberFormatException e) {
                    // Controlar error de formato de número
                    return;
                }
            }
            if (!ubicacion.isEmpty()) {
                queryBuilder.append(" AND ubicacion LIKE ?");
                parameters.add("%" + ubicacion + "%");
            }

            executeQuery(queryBuilder.toString(), parameters);
        }

        private void listarProductos() {
            productos.clear();
            String query = "SELECT * FROM productos ORDER BY nombre";
            executeQuery(query, new ArrayList<>());
        }

        private void mostrarProductosCaros() {
            productos.clear();
            String query = "SELECT * FROM productos WHERE precio > 10000";
            executeQuery(query, new ArrayList<>());
        }

        private void obtenerLacteos() {
            productos.clear();
            String query = "SELECT * FROM productos WHERE tipo = 'Lácteos'";
            executeQuery(query, new ArrayList<>());
        }

        private void listarProductosPasillo2() {
            productos.clear();
            String query = "SELECT * FROM productos WHERE ubicacion = 'Pasillo 2'";
            executeQuery(query, new ArrayList<>());
        }

        private void mostrarPrimerosProductos() {
            productos.clear();
            String query = "SELECT * FROM productos LIMIT 5";
            executeQuery(query, new ArrayList<>());
        }

        private void consultarNombreComienzaA() {
            productos.clear();
            String query = "SELECT * FROM productos WHERE nombre LIKE 'A%'";
            executeQuery(query, new ArrayList<>());
        }

        private void buscarArroz() {
            productos.clear();
            String query = "SELECT * FROM productos WHERE nombre LIKE '%Arroz%'";
            executeQuery(query, new ArrayList<>());
        }

        private void obtenerProductosSinUbicacion() {
            productos.clear();
            String query = "SELECT * FROM productos WHERE ubicacion IS NULL";
            executeQuery(query, new ArrayList<>());
        }

        private void listarClientesPorFechaNacimiento() {
            productos.clear();
            String query = "SELECT * FROM clientes ORDER BY fecha_nacimiento";
            executeQuery(query, new ArrayList<>());
        }

        private void listarClientesAno1990() {
            productos.clear();
            String query = "SELECT * FROM clientes WHERE YEAR(fecha_nacimiento) >= 1990";
            executeQuery(query, new ArrayList<>());
        }

        private void executeQuery(String query, List<Object> parameters) {
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                for (int i = 0; i < parameters.size(); i++) {
                    pstmt.setObject(i + 1, parameters.get(i));
                }
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        productos.add(new Producto(
                                rs.getInt("id_producto"),
                                rs.getString("nombre"),
                                rs.getDouble("precio"),
                                rs.getString("tipo"),
                                rs.getString("ubicacion")
                        ));
                    }
                    Platform.runLater(() -> {
                        productosView.getTablaProductos().setItems(null);
                        productosView.getTablaProductos().setItems(productos);
                        System.out.println("Tabla actualizada con " + productos.size() + " productos");
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al ejecutar la consulta: " + e.getMessage());
            }
        }
    }
