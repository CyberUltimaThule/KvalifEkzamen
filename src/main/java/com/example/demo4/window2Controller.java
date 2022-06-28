package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class window2Controller{
    public Button btok;
    public TextField tf;
    public PasswordField pf;
    public Label lab;

    public window2Controller() {
        // TODO Auto-generated constructor stub
    }

    public void initialize() {
        // TODO Auto-generated method stub
        btok.setOnAction(event -> {
            Database db = new Database();
            User user = new User();
            user.setUn(tf.getText());
            user.setPw(pf.getText());
            ResultSet res = db.getUs(user);
            int count = 0;
            try {
                while (res.next()) {
                    count++;
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            if (count >= 1){
                lab.setText("Ошибка:Такие данные уже существуют");
            }

            else if (!tf.getText().equals("") && !pf.getText().equals("")){
                db.signup(tf.getText(), pf.getText());
                try {
                    changeWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }}
            else {
                lab.setText("Ошибка:Поля не заполнены");
            }
        });

    }

    public void changeWindow() throws Exception {
        com.example.demo4.window3 second=new window3();
        second.showWindow();
        Stage stage = (Stage) btok.getScene().getWindow();
        stage.close();

    }}