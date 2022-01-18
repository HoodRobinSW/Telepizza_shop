package DAO;

import Modelo.Pizza;
import Modelo.Tipo_pizza;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bd {
        private static String usuario="alejdnxu";
        private static String password="hFWucoCz1K26";
        private static String servidor="localhost:3306";
        private static String basedatos="telepizza";
        
    public static Connection CrearConexion() {
        Connection cnn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //invocamos al driver
            String url = "jdbc:mysql://" + servidor + "/" + basedatos;
            cnn = DriverManager.getConnection(url, usuario, password); //nos conectamos a la BD
        } catch (ClassNotFoundException c) {
            System.out.println("Controlador JDBC no encontrado"+c.toString());   
        } catch (SQLException ex) {
            System.out.println("Fallo en la conexion"+ex.toString()); 
        }
        return cnn;
    }
    
    public static ArrayList<Usuario> getUsuarios() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario = null;
        Connection conn = CrearConexion();
        String sql = "SELECT * FROM usuarios;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            listaUsuarios.add(usuario);
            usuario = null;
        }
        
        return listaUsuarios;
    }
    
    public static void registrarUsuario(Usuario usuario) throws SQLException {
        Connection conn = CrearConexion();
        String sql = "INSERT INTO usuarios VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 0);
        ps.setString(2, usuario.getUsuario());
        ps.setString(3, usuario.getPass());
        ps.setString(4, usuario.getAddress());
        ps.setString(5, usuario.getEmail());
        ps.setString(6, usuario.getPhone());
        ps.executeUpdate();
    }
    
    public static ArrayList<Tipo_pizza> getTipos_pizza() throws SQLException {
        ArrayList<Tipo_pizza> tipos = new ArrayList<>();
        Connection conn = CrearConexion();
        String sql = "SELECT * FROM tipo_pizza;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Tipo_pizza tipo = new Tipo_pizza(rs.getInt(1), rs.getString(2));
            tipos.add(tipo);
            tipo = null;
        }
        
        return tipos;
    }
    
    public static ArrayList<Pizza> getPizzas() throws SQLException {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        Connection conn = CrearConexion();
        String sql = "SELECT * FROM pizzas;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pizza pizza = new Pizza(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
            pizzas.add(pizza);
            pizza = null;
        }
        
        return pizzas;
    }
        
    public static Pizza getPizzasById(String id) throws SQLException {
        Connection conn = CrearConexion();
        String sql = "SELECT * FROM pizzas WHERE id = "+id+";";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Pizza pizza = new Pizza(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
        
        return pizza;
    }

}