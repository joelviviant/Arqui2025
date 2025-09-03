package org.example;


import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDeDatos {
    public static void main(String[] args) {
        String driver ="org.apache.derby.jdbc.EmbeddedDriver";
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String uri = "jdbc:derby:MyDerbyDB;create=true";

        try {
            Connection conn = DriverManager.getConnection(uri);
            createTables(conn);
            addPerson(conn, 1 , "Juan", 20);
            addPerson(conn, 2 , "Jose", 30);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addPerson(Connection conn, int id, String name, int age) throws SQLException {
        String sql = "insert into persona (id, nombre, edad) values (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        ps.executeUpdate();
        ps.close();
        conn.commit();
    }

    private static void createTables(Connection conn) throws SQLException {
        String table = "CREATE TABLE persona(" + "id INT," + "nombre VARCHAR(500), " + "edad INT, " + "PRIMARY KEY (id))";
        conn.prepareStatement(table).execute();
        conn.commit();
    }
}
