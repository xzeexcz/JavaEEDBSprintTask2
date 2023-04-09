package kz.bitlab.sprinttask.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager{
    private static Connection connection;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sprinttask?useUnicode=true&serverTimeZone=UTC",
                    "root",
                    "");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Items> getItems() {
        ArrayList<Items> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, name, description, price FROM items");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                items.add(new Items(
                          resultSet.getLong("id"),
                          resultSet.getString("name"),
                          resultSet.getString("description"),
                          resultSet.getDouble("price")));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
    public static String isOk(String email, String password) {
        String full_name = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT email, password, full_name FROM users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String email1 = resultSet.getString("email");
                String password1 = resultSet.getString("password");
                if(email.equals(email1)) {
                    if(password.equals(password1)) {
                        full_name = resultSet.getString("full_name");
                    } else {
                        full_name = null;
                    }
                } else {
                    full_name = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return full_name;
    }
    public static String isOk2(String email,  String password) {
        String full_name = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT full_name FROM users WHERE email = ? AND password = ?");
            statement.setString(1,email);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                full_name = resultSet.getString("full_name");
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return full_name;
    }
}
