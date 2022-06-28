package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class window6Controller{
    public Button bn;
    public TextField tf;

    public window6Controller() {
        // TODO Auto-generated constructor stub
    }

    public void initialize() {
        // TODO Auto-generated method stub
        Database dbDB = new Database();
        bn.setOnAction(event -> {
            if (!tf.getText().equals("")){
            dbDB.otv(tf.getText());
                try {
                    calc();
                } catch (Exception e) {
                    e.printStackTrace();
                }}
        });

    }
    public void calc() {
            int x = cl.isCl();
            Database dbDB = new Database();
            Otvet val = new Otvet();
            ArrayList<String> tas = dbDB.otv2(val);
            for (int i = 0; i < tas.size(); i++) {
                double r = Double.parseDouble(tas.get(0));
            if(x == 0) {
                System.out.println("Метод трапеций");
                Value value = new Value();
                ArrayList<String> tasks = dbDB.getVa(value);
                for (int q = 0; q < tasks.size(); q++) {
                    double a = Double.parseDouble(tasks.get(0));
                    double j = Double.parseDouble(tasks.get(1));
                    double n = Double.parseDouble(tasks.get(2));
                    double h = 1;
                    double z = 0;
                    for (int p = 0; p < (j - a) / h; p++) {
                        z += h * (0.5 * (n + n));
                    }
                    System.out.print(z);
                    if (z == r) {
                        Database dbres = new Database();
                        dbres.resul("Верно");
                    } else {
                        Database dbres = new Database();
                        dbres.resul("Неверно");
                    }
                break;}
            }
            else if (x == 1){
                System.out.println("Метод прямоугольников");
                Value value = new Value();
                ArrayList<String> tasks = dbDB.getVa(value);
                for (int d = 0; d < tasks.size(); d++) {
                    double f = Double.parseDouble(tasks.get(0));
                    double g = Double.parseDouble(tasks.get(1));
                    double l = Double.parseDouble(tasks.get(2));
                    double o = 0.1;
                    double s = 0;
                    for (int c = 0; c < (g - f) / o; c++) {
                        s += o * l;
                    }
                    System.out.printf(" S = %.3f\n", s);
                    if (s == r) {
                        Database dbres = new Database();
                        dbres.resul("Верно");
                    } else {
                        Database dbres = new Database();
                        dbres.resul("Неверно");
                    }
                break;}
                }
            else {
                System.out.println("Что то пошло не так");
            }
        break;}}
    public void changeWindow() throws Exception {
        Database db = new Database();
        db.delval();
        System.exit(1);

    }}