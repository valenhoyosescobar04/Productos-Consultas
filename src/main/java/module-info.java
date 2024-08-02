module co.edu.cue.productosseguimiento2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens co.edu.cue.productosseguimiento2 to javafx.fxml;
    exports co.edu.cue.productosseguimiento2;
}