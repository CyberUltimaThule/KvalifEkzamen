package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class window1Controller implements Initializable {
    public Button btNok;
    public Button bt;

    public window1Controller() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

    public void changeWindow() throws Exception {
        com.example.demo4.window2 second = new window2();
        second.showWindow();
        Stage stage = (Stage) btNok.getScene().getWindow();
        stage.close();
    }

    public void winChange() throws Exception {
        com.example.demo4.window3 sec=new window3();
        sec.showWindow2();
        Stage tage = (Stage) bt.getScene().getWindow();
        tage.close();
        }

}