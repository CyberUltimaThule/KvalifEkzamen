package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class window9Controller implements Initializable {
    public Button bb;

    public window9Controller() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

    public void changeWindow() throws Exception {
        com.example.demo4.window7 second = new window7();
        second.showWindow();
        Stage stage = (Stage) bb.getScene().getWindow();
        stage.close();

    }}

