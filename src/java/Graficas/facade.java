package Graficas;

import DAO.CarreraDAO;
import Utilerias.Conexion;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Pwned
 */
public class facade {
    
     static public List grafica() throws SQLException, ClassNotFoundException { 
         CarreraDAO dao= new  CarreraDAO();
         Conexion conn=new Conexion();         
        return  dao.grafica(conn.ObtenerConexion());
    } 
    
}