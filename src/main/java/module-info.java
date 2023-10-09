module com.aryan.connect4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.aryan.connect4 to javafx.fxml;
    exports com.aryan.connect4;
}