
package DAO;

import DTO.Alumno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;


public class AlumnoDAO   {

    public AlumnoDAO() {
    }
    private static String SQL_LOGIN="{call getAlumnoPass(?,?)}";
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO alumno ("
        + "matriculaA, nombre, paterno, materno, fechaN, calle, colonia, "
        + "num, cp, sexo, email, clave, idCarrera"
        + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "matriculaA, nombre, paterno, materno, fechaN, calle, colonia, "
        + "num, cp, sexo, email, clave, idCarrera "
        + "FROM alumno WHERE "
        + "matriculaA = ?";
    private static final String SQL_SELECTALL =
        "SELECT "
        + "matriculaA, nombre, paterno, materno, fechaN, calle, colonia, "
        + "num, cp, sexo, email, clave, idCarrera "
        + "FROM alumno";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE alumno SET "
        + "nombre = ?, paterno = ?, materno = ?, fechaN = ?, calle = ?, colonia = ?, num = ?,  "
        + "cp = ?, sexo = ?, email = ?, clave = ?, idCarrera = ? "
        + "WHERE "
        + "matriculaA = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM alumno WHERE "
        + "matriculaA = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Alumno bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setLong(1, bean.getMatriculaa());
            ps.setString(2, bean.getNombre());
            ps.setString(3, bean.getPaterno());
            ps.setString(4, bean.getMaterno());
            if (bean.getFechan() != null)
                ps.setDate(5, new java.sql.Date(bean.getFechan().getTime()));
            else
                ps.setNull(5, Types.DATE);
            ps.setString(6, bean.getCalle());
            ps.setString(7, bean.getColonia());
            ps.setInt(8, bean.getNum());
            ps.setLong(9, bean.getCp());
            ps.setString(10, bean.getSexo());
            ps.setString(11, bean.getEmail());
            ps.setString(12, bean.getClave());
            ps.setInt(13, bean.getIdcarrera());
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
    public Alumno load(Alumno key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setLong(1, key.getMatriculaa());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Alumno) results.get(0);
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
    public List loadALL( Connection conn) throws SQLException {
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
    public void update(Alumno bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getPaterno());
            ps.setString(3, bean.getMaterno());
            if (bean.getFechan() != null)
                ps.setDate(4, new java.sql.Date(bean.getFechan().getTime()));
            else
                ps.setNull(4, Types.DATE);
            ps.setString(5, bean.getCalle());
            ps.setString(6, bean.getColonia());
            ps.setInt(7, bean.getNum());
            ps.setLong(8, bean.getCp());
            ps.setString(9, bean.getSexo());
            ps.setString(10, bean.getEmail());
            ps.setString(11, bean.getClave());
            ps.setInt(12, bean.getIdcarrera());
            ps.setLong(13, bean.getMatriculaa());
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
    public void delete(Alumno key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setLong(1, key.getMatriculaa());
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
    protected List<Alumno> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Alumno>();
        while (rs.next()) {
            Alumno bean = new Alumno();
            bean.setMatriculaa(rs.getLong("matriculaA"));
            bean.setNombre(rs.getString("nombre"));
            bean.setPaterno(rs.getString("paterno"));
            bean.setMaterno(rs.getString("materno"));
            bean.setFechan(rs.getDate("fechaN"));
            bean.setCalle(rs.getString("calle"));
            bean.setColonia(rs.getString("colonia"));
            bean.setNum(rs.getInt("num"));
            bean.setCp(rs.getLong("cp"));
            bean.setSexo(rs.getString("sexo"));
            bean.setEmail(rs.getString("email"));
           bean.setClave(rs.getString("clave"));
            bean.setIdcarrera(rs.getInt("idCarrera"));
            results.add(bean);
        }
        return results;
    }
    
    public Alumno findByUserNameAndPassword(String user, String clave, Connection conn) throws SQLException{
        
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareCall(SQL_LOGIN);
            ps.setString(1, user);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            List resultado = getResults(rs);
            if (resultado.size() > 0) {
                return (Alumno) resultado.get(0);
            }
            return null;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
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