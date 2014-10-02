
package DAO;

import DTO.Calificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to populate DB Table of calificaciones
 */
public class CalificacionesDAO{
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO calificaciones ("
        + "idCalificaciones, puntaje, matriculaA, matriculaP, idExamen"
        + ") VALUES (?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idCalificaciones, puntaje, matriculaA, matriculaP, idExamen "
        + "FROM calificaciones WHERE "
        + "idCalificaciones = ?";
private static final String SQL_SELECT_ALL =
        "SELECT "
        + "idCalificaciones, puntaje, matriculaA, matriculaP, idExamen "
        + "FROM calificaciones ";
    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE calificaciones SET "
        + "puntaje = ?, matriculaA = ?, matriculaP = ?, idExamen = ? "
        + "WHERE "
        + "idCalificaciones = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM calificaciones WHERE "
        + "idCalificaciones = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Calificaciones bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdcalificaciones());
            ps.setDouble(2, bean.getPuntaje());
            ps.setLong(3, bean.getMatriculaa());
            ps.setLong(4, bean.getMatriculap());
            ps.setInt(5, bean.getIdexamen());
            ps.executeUpdate();
        }finally {
            close(ps);
            if(conn!=null){
                conn.close();
            }
        }
    }

    /**
     * Retrive a record from Database.
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    public Calificaciones load(Calificaciones key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdcalificaciones());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Calificaciones) results.get(0);
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
    public void update(Calificaciones bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setDouble(1, bean.getPuntaje());
            ps.setLong(2, bean.getMatriculaa());
            ps.setLong(3, bean.getMatriculap());
            ps.setInt(4, bean.getIdexamen());
            ps.setInt(5, bean.getIdcalificaciones());
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
    public void delete(Calificaciones key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdcalificaciones());
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
    protected List<Calificaciones> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Calificaciones>();
        while (rs.next()) {
            Calificaciones bean = new Calificaciones();
            bean.setIdcalificaciones(rs.getInt("idCalificaciones"));
            bean.setPuntaje(rs.getDouble("puntaje"));
            bean.setMatriculaa(rs.getLong("matriculaA"));
            bean.setMatriculap(rs.getLong("matriculaP"));
            bean.setIdexamen(rs.getInt("idExamen"));
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