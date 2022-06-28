package com.example.demo4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

import java.util.ArrayList;


public class window1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("window1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Window 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
class config {
    protected String dbHost = "localhost";
    protected String dbPort = "3306";
    protected String dbUser = "root";
    protected String dbPass = "01116003";
    protected String dbName = "doom";
}
class Database extends config {

    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionStr = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift" +
                "=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionStr, dbUser, dbPass);
        return dbConnection;
    }
    public void signup(String username, String password) {
        if (!username.equals("") && !password.equals("")){
            String insert = "INSERT users(Username, Password)" +
                    "VALUES(?,?)";
            try{
                PreparedStatement ps = getDbConnection().prepareStatement(insert);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.executeUpdate();
            }
            catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
    public void resul(String res1) {
            String insert = "INSERT otres(res)" +
                    "VALUES(?)";
            try{
                PreparedStatement ps = getDbConnection().prepareStatement(insert);
                ps.setString(1, res1);
                ps.executeUpdate();
            }
            catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
    }
    public void otv(String otvet) {
            String insert = "INSERT otres(otvet)" +
                    "VALUES(?)";
            try{
                PreparedStatement ps = getDbConnection().prepareStatement(insert);
                ps.setString(1, otvet);
                ps.executeUpdate();
            }
            catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
    }
    public void vvod(String np, String vp, String integ) {
        String insert = "INSERT val(nizhpredel, verhpredel, integral)" +
                "VALUES(?,?,?)";
        try{
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ps.setString(1, np);
            ps.setString(2, vp);
            ps.setString(3, integ);
            ps.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
    public ArrayList<String> getVa(Value value){
        String select2 = "select * from val";
        try {
            Statement ps2 = getDbConnection().createStatement();
            ResultSet rs2 = ps2.executeQuery(select2);
            ArrayList<String> val = new ArrayList<>();
            while(rs2.next()){
                val.add(rs2.getString("nizhpredel"));
                val.add(rs2.getString("verhpredel"));
                val.add(rs2.getString("integral"));

            }
            return val;
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> resu(Res re){
        String select2 = "select * from otres";
        try {
            Statement ps2 = getDbConnection().createStatement();
            ResultSet rs2 = ps2.executeQuery(select2);
            ArrayList<String> val = new ArrayList<>();
            while(rs2.next()){
                val.add(rs2.getString("res"));

            }
            return val;
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet getUs(User user) {
        ResultSet rs = null;
        String select = "select * from users where Username =? AND Password =?";
        try{
            PreparedStatement ps = getDbConnection().prepareStatement(select);
            ps.setString(1, user.getUn());
            ps.setString(2, user.getPw());
            rs = ps.executeQuery();}
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();}
        return rs;
    }
    public void delotres() {
        String del = "TRUNCATE TABLE otres";
        try{
            PreparedStatement ps = getDbConnection().prepareStatement(del);
            ps.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void delval() {
        String del = "TRUNCATE TABLE val";
        try{
            PreparedStatement ps = getDbConnection().prepareStatement(del);
            ps.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public ArrayList<String> otv2(Otvet otvet){
        String select2 = "select * from otres";
        try {
            Statement ps2 = getDbConnection().createStatement();
            ResultSet rs2 = ps2.executeQuery(select2);
            ArrayList<String> val = new ArrayList<>();
            while(rs2.next()){
                val.add(rs2.getString("otvet"));

            }
            return val;
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
class cl {
    private static int Cl;


    public cl() {

    }

    public static int isCl() {
        return Cl;
    }

    public static void setCl(int cl) {
        Cl = cl;
        System.out.println(cl);
    }
}
class Res{
    private  String re;

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }
}
class Otvet {
    private static String otvet;
    public Otvet() {

    }

    public static String getOtvet() {
        return otvet;
    }

    public void setOtvet(String otvet) {
        this.otvet = otvet;
    }
}
class Value {
    private String np1;
    private String vp1;
    private String zn1;

    public Value(String np1, String vp1, String zn1) {
        this.np1 = np1;
        this.vp1 = vp1;
        this.zn1 = zn1;
    }

    public Value() {

    }

    public String getNp1() {
        return np1;
    }

    public void setNp1(String np1) {
        this.np1 = np1;
    }

    public String getVp1() {
        return vp1;
    }

    public void setVp1(String vp1) {
        this.vp1 = vp1;
    }

    public String getZn1() {
        return zn1;
    }

    public void setZn1(String zn1) {
        this.zn1 = zn1;
    }
}
class User {
    private String un;
    private String pw;

    public User(String un, String pw) {
        this.un = un;
        this.pw = pw;
    }

    public User() {

    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
