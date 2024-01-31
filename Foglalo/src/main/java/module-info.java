module com.example.foglalo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.foglalo to javafx.fxml;
    exports com.example.foglalo;
}