package com.example.demo4;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class window5Controller{
    public Button bn;
    public Button bt;
    public Label np;
    public Label vp;
    public Label zn;

    public window5Controller() {
        // TODO Auto-generated constructor stub
    }

    public void initialize() {
        // TODO Auto-generated method stub
        bt.setOnAction(event -> {
                try {
                    prim();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        });}

    private void prim() {
        Database dbDB = new Database();
        Value value = new Value();
        ArrayList<String> tasks = dbDB.getVa(value);
        for (int i = 0; i < tasks.size(); i++) {
            np.setText(tasks.get(0));
            vp.setText(tasks.get(1));
            zn.setText(tasks.get(2) + "dx");
        }
        Value p = new Value();
        System.out.println(p);
        }


    public void changeWindow() throws Exception {
        com.example.demo4.window6 second=new window6();
        second.showWindow();
        Stage stage = (Stage) bn.getScene().getWindow();
        stage.close();

    }
}