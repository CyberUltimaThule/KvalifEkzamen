package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class window7Controller {
    public Button bnt;
    public Button bt;
    public TextField tf;
    public TextField tf2;
    public TextField tf3;
    public Label lab;

    public window7Controller() {
        // TODO Auto-generated constructor stub
    }

    public void initialize() {
        // TODO Auto-generated method stub
        Database dbDB2 = new Database();
        bnt.setOnAction(event -> {
            if (!tf.getText().equals("") && !tf2.getText().equals("") && !tf3.getText().equals("")){
                dbDB2.vvod(tf.getText(), tf2.getText(), tf3.getText());
            }
            else {
                lab.setText("Ошибка:Поля не заполнены");
            }
        });

    }

    public void changeWindow2() throws Exception {
        com.example.demo4.window8 second=new window8();
        second.showWindow();
        Stage stage = (Stage) bt.getScene().getWindow();
        stage.close();

    }
}