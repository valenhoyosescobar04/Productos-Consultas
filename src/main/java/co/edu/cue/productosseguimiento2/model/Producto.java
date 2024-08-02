package co.edu.cue.productosseguimiento2.model;

    import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
    import javafx.beans.property.*;

public class Producto {


        private IntegerProperty idProducto;
        private StringProperty nombre;
        private DoubleProperty precio;
        private StringProperty tipo;
        private StringProperty ubicacion;

        public Producto(int idProducto, String nombre, double precio, String tipo, String ubicacion) {
            this.idProducto = new SimpleIntegerProperty(idProducto);
            this.nombre = new SimpleStringProperty(nombre);
            this.precio = new SimpleDoubleProperty(precio);
            this.tipo = new SimpleStringProperty(tipo);
            this.ubicacion = new SimpleStringProperty(ubicacion);
        }

        public int getIdProducto() {
            return idProducto.get();
        }

        public IntegerProperty idProductoProperty() {
            return idProducto;
        }

        public void setIdProducto(int idProducto) {
            this.idProducto.set(idProducto);
        }

        public String getNombre() {
            return nombre.get();
        }

        public StringProperty nombreProperty() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre.set(nombre);
        }

        public double getPrecio() {
            return precio.get();
        }

        public DoubleProperty precioProperty() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio.set(precio);
        }

        public String getTipo() {
            return tipo.get();
        }

        public StringProperty tipoProperty() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo.set(tipo);
        }

        public String getUbicacion() {
            return ubicacion.get();
        }

        public StringProperty ubicacionProperty() {
            return ubicacion;
        }

        public void setUbicacion(String ubicacion) {
            this.ubicacion.set(ubicacion);
        }
    }



