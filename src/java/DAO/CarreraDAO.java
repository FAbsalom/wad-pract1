package DAO;

import DTO.Carrera;
import DTO.GraficaDTO;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;

public class CarreraDAO{
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO carrera ("
        + "idCarrera, nombre, duracion"
        + ") VALUES (?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idCarrera, nombre, duracion "
        + "FROM carrera WHERE "
        + "idCarrera = ?";
    private static final String SQL_SELECT_ALL =
        "SELECT "
        + "idCarrera, nombre, duracion "
        + "FROM carrera";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE carrera SET "
        + "nombre = ?, duracion = ? "
        + "WHERE "
        + "idCarrera = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM carrera WHERE "
        + "idCarrera = ?";
    
    private static final String sql_GraficaCarrera="{call AlumnosxCarrera()}";    
    
    public List grafica( Connection conn) throws SQLException, ClassNotFoundException{
       CallableStatement cs=null;       
       ResultSet rs = null; 
       List lista = new ArrayList(); 
       try { 
        cs = (CallableStatement) conn.prepareCall(sql_GraficaCarrera); 
        rs = cs.executeQuery(); 
        while (rs.next()) { 
        GraficaDTO grafica = new GraficaDTO(); 
        grafica.setCantidad(Integer.parseInt(rs.getString("numAlum"))); 
        grafica.setNombre(rs.getString("nomCarrera")); 
        lista.add(grafica); 
        }
       }finally{
           if(rs!=null)
               rs.close();           
           if(cs!=null)
               cs.close();
           if(conn!=null)
                conn.close();
       }
        return lista;       
        }
    
    
    public void create(Carrera bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdcarrera());
            ps.setString(2, bean.getNombre());
            ps.setInt(3, bean.getDuracion());
            ps.executeUpdate();
        }finally {
            close(ps);
            if(conn!=null){
                conn.close();
            }
        }
    }

   
    public Carrera load(Carrera key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdcarrera());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Carrera) results.get(0);
            else
                return null;
        }finally {
            close(rs);
            close(ps);
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public List loadAll( Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return  results;
            else
                return null;
        }finally {
            close(rs);
            close(ps);
            if(conn!=null){
                conn.close();
            }
        }
    }

    /**
     * Update a record in Database.
     * @param bean   The Object to be saved.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void update(Carrera bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getNombre());
            ps.setInt(2, bean.getDuracion());
            ps.setInt(3, bean.getIdcarrera());
            ps.executeUpdate();
        }finally {
            close(ps);
            if(conn!=null){
                conn.close();
            }
        }
    }

    /**
     * Create a new record in Database.
     * @param bean   The PK Object to be deleted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void delete(Carrera key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdcarrera());
            ps.executeUpdate();
        }finally {
            close(ps);
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    /**
     * Populate the ResultSet.
     * @param rs     The ResultSet.
     * @return       The Object to retrieve from DB.
     * @exception    SQLException if something is wrong.
     */
    protected List<Carrera> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Carrera>();
        while (rs.next()) {
            Carrera bean = new Carrera();
            bean.setIdcarrera(rs.getInt("idCarrera"));
            bean.setNombre(rs.getString("nombre"));
            if (rs.wasNull())
                bean.setNombre(null);     
            bean.setDuracion(rs.getInt("duracion"));
            results.add(bean);
        }
        return results;
    }

    /**
     * Close JDBC Statement.
     * @param stmt  Statement to be closed.
     */
    protected void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            }catch(SQLException e){}
        }
    }

    /**
     * Close JDBC ResultSet.
     * @param rs  ResultSet to be closed.
     */
    protected void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }catch(SQLException e){}
        }
    }

    
}