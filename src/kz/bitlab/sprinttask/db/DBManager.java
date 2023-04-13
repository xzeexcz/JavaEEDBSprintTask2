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
    public static boolean addItem(Items item) {
        int rows = 0;
            try {
                PreparedStatement statement = connection.prepareStatement("" +
                        "INSERT INTO items(id,name,description,price)" +
                        "VALUES (NULL,?,?,?)");
                statement.setString(1, item.getName());
                statement.setString(2, item.getDescription());
                statement.setDouble(3, item.getPrice());
                rows = statement.executeUpdate();
                statement.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        return rows > 0;
    }
    public static Items getItemByID(Long id) {
        Items items = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT id, name, description,price FROM items WHERE id = ?");
            statement.setLong(1,id);
            ResultSet resultSet =statement.executeQuery();
            if(resultSet.next()) {
             items = new Items(
              resultSet.getLong("id"),
              resultSet.getString("name"),
              resultSet.getString("description"),
              resultSet.getDouble("price"));
            }
            statement.close();
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
    public static boolean editItem(Items item) {
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE items SET name = ?, description = ?, price = ? WHERE id = ?");
            statement.setString(1,item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3,item.getPrice());
            statement.setLong(4,item.getId());
            rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;
    }
    public static boolean deleteItem(Long id) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?");
            statement.setLong(1,id);
            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;
    }
}
