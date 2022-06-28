package com.example.demo4;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class window4Controller{
    public Button b;
    public Button bb;


    public window4Controller() {
        // TODO Auto-generated constructor stub
    }

    public void initialize() {
        // TODO Auto-generated method stub
        
        bb.setOnAction(event -> {
            System.out.println("Метод прямоугольников");
            cl.setCl(1);
            try {
                changeWindow();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        b.setOnAction(event -> {
            System.out.println("Метод трапеций");
            cl.setCl(0);
            try {
                changeWindow2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    public void changeWindow() throws Exception {
        com.example.demo4.window5 second = new window5();
        second.showWindow();
        Stage stage = (Stage) bb.getScene().getWindow();
        stage.close();
    }


    public void changeWindow2() throws Exception {
        com.example.demo4.window5 second = new window5();
        second.showWindow2();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.close();
    }
}
