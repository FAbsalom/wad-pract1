/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pwned
 */
public class Conexion {
    
     public Connection ObtenerConexion() throws ClassNotFoundException, SQLException{         
         Connection con=null;
         Class.forName("com.mysql.jdbc.Driver");
         con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");   
         return con;
    }
     public void CerrarConexion(Connection con){
         if(con!=null)
            try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
