/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class Koneksi {  
    Connection con;
    Statement state;

    public static Connection sambung(){
    String JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    String username = "root";
    String host = "localhost";
    String port = "3306";
    String password = "";
    String dbName = "userpass_admin";
    String url = "jdbc:mysql://"+host+":"+port+"/"+"userpass_admin"+"?useTimezone=true&serverTimezone=UTC";
    Connection kon = null;
    try {
    Class.forName(JDBC_DRIVER_CLASS).newInstance();
    kon = DriverManager.getConnection(url,username,password);

    System.out.println("Koneksi: Sukses!");

    return kon;

    }   catch (ClassNotFoundException | IllegalAccessException |

    InstantiationException | SQLException e) {
    System.err.println("Error: "+ e.getMessage());

    System.exit(0);

}
    return null;
}
    
}