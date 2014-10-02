
package DAO;


import DTO.Examen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;

/**
 * This class provides methods to populate DB Table of examen
 */
public class ExamenDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO examen ("
        + "idExamen, fecha, periodo, idMateria"
        + ") VALUES (?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idExamen, fecha, periodo, idMateria "
        + "FROM examen WHERE "
        + "idExamen = ?";

    private static final String SQL_SELECTALL =
        "SELECT "
        + "idExamen, fecha, periodo, idMateria "
        + "FROM examen";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE examen SET "
        + "fecha = ?, periodo = ?, idMateria = ? "
        + "WHERE "
        + "idExamen = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM examen WHERE "
        + "idExamen = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Examen bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIdexamen());
            if (bean.getFecha() != null)
                ps.setDate(2, new java.sql.Date(bean.getFecha().getTime()));
            else
                ps.setNull(2, Types.DATE);
            ps.setInt(3, bean.getPeriodo());
            ps.setInt(4, bean.getIdmateria());
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
    public Examen load(Examen key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIdexamen());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Examen) results.get(0);
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
       public List loadALL(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECTALL);        
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return results;
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
    public void update(Examen bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            if (bean.getFecha() != null)
                ps.setDate(1, new java.sql.Date(bean.getFecha().getTime()));
            else
                ps.setNull(1, Types.DATE);
            ps.setInt(2, bean.getPeriodo());
            ps.setInt(3, bean.getIdmateria());
            ps.setInt(4, bean.getIdexamen());
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
    public void delete(Examen key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIdexamen());
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
    protected List<Examen> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Examen>();
        while (rs.next()) {
            Examen bean = new Examen();
            bean.setIdexamen(rs.getInt("idExamen"));
            bean.setFecha(rs.getDate("fecha"));
            if (rs.wasNull())
                bean.setFecha(null);     
            bean.setPeriodo(rs.getInt("periodo"));
            bean.setIdmateria(rs.getInt("idMateria"));
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