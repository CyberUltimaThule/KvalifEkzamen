module com.example.demo4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires org.junit.jupiter.api;
    requires junit;


    opens com.example.demo4 to javafx.fxml;
    exports com.example.demo4;
}