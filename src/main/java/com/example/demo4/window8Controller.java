package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.zip.InflaterInputStream;

public class window8Controller{
    public Button bn;
    public Button b;
    public Label lb;

    public window8Controller() {
        // TODO Auto-generated constructor stub
    }


    public void initialize() {
        // TODO Auto-generated method stub
        b.setOnAction(event -> {
            Database dbDB = new Database();
            Res re = new Res();
            ArrayList<String> res = dbDB.resu(re);
            for (int i = 0; i < res.size(); i++) {
                lb.setText(res.get(i));
            }
        });
    }

    public void changeWindow() throws Exception {
        Database db = new Database();
        db.delotres();
        System.exit(1);

    }
}