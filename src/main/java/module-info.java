module com.example.functiondraw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.functiondraw to javafx.fxml;
    exports com.example.functiondraw;
}