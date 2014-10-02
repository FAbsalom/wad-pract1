/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Tue Sep 16 23:29:22 CDT 2014
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package DAO;
import DTO.Respuesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;

/**
 * This class provides methods to populate DB Table of respuesta
 */
public class RespuestaDAO{
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO respuesta ("
        + "idRespuesta, respuesta, idPregunta"
        + ") VALUES (?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idRespuesta, respuesta, idPregunta "
        + "FROM respuesta WHERE "
        + "idRespuesta = ?";

     private static final String SQL_SELECTALL =
        "SELECT "
        + "idRespuesta, respuesta, idPregunta "
        + "FROM respuesta ";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE respuesta SET "
        + "respuesta = ?, idPregunta = ? "
        + "WHERE "
        + "idRespuesta = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM respuesta WHERE "
        + "idRespuesta = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Respuesta bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdrespuesta());
            ps.setString(2, bean.getRespuesta());
            ps.setInt(3, bean.getIdpregunta());
            ps.executeUpdate();
        }finally {
            close(ps);
            if(conn!=null){
                conn.close();
            }
        }
    }

    public List loadALL(Connection conn) throws SQLException {
      PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECTALL);            
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
    
    public Respuesta load(Respuesta key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdrespuesta());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Respuesta) results.get(0);
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
    public void update(Respuesta bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getRespuesta());
            ps.setInt(2, bean.getIdpregunta());
            ps.setInt(3, bean.getIdrespuesta());
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
    public void delete(Respuesta key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdrespuesta());
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
    protected List<Respuesta> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Respuesta>();
        while (rs.next()) {
            Respuesta bean = new Respuesta();
            bean.setIdrespuesta(rs.getInt("idRespuesta"));
            bean.setRespuesta(rs.getString("respuesta"));
            if (rs.wasNull())
                bean.setRespuesta(null);     
            bean.setIdpregunta(rs.getInt("idPregunta"));
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