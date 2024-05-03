module org.example.sheet7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.sheet7 to javafx.fxml;
    exports org.example.sheet7;
}