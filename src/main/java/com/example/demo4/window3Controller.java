package com.example.demo4;

import javafx.beans.value.ObservableValue;
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

public class window3Controller {
    public Button btk;
    public Button bk;
    public TextField tf;
    public PasswordField pf;
    public Label lab;

    public window3Controller() {
        // TODO Auto-generated constructor stub
    }

    @FXML
    public void initialize() {
        btk.setOnAction(event -> {
            String logTxt = tf.getText().trim();
            String passw = pf.getText().trim();
            if (!logTxt.equals("") && !passw.equals("")){
                if (logTxt.equals("admin") && passw.equals("adminus")){
                    try {
                        changeWindow2();
                    } catch (Exception e) {
                        e.printStackTrace();}}
                try {
                    logup(logTxt, passw);
                } catch (Exception e) {
                    e.printStackTrace();}}
            else {
                lab.setText("Ошибка:Поля не заполнены");}});
    }

    private void logup(String logTxt, String passw) throws Exception {
        Database dbDB = new Database();
        User user = new User();
        user.setUn(logTxt);
        user.setPw(passw);
        ResultSet res = dbDB.getUs(user);
        int count = 0;
        try {
            while (res.next()) {
                count++;}}
        catch (SQLException e) {
            e.printStackTrace();}

        if (count >= 1 && !logTxt.equals("admin") && !passw.equals("adminus")){
            try {
                changeWindow();}
            catch (Exception e) {
                e.printStackTrace();}
            System.out.println("Nice");}
        else {
            lab.setText("Ошибка:Таких данных не существует");}
    }

    public void changeWindow() throws Exception {
            com.example.demo4.window4 second=new window4();
            second.showWindow();
            Stage stage = (Stage) btk.getScene().getWindow();
            stage.close();
        }
    public void changeWindow2() throws Exception {
        com.example.demo4.window7 second=new window7();
        second.showWindow();
        Stage stage = (Stage) btk.getScene().getWindow();
        stage.close();
    }}