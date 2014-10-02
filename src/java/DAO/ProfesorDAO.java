package DAO;

import DTO.Alumno;
import DTO.Profesor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;


public class ProfesorDAO{

    public ProfesorDAO() {
    }
    private static String SQL_LOGIN="{call getProfesorPass(?,?)}";
    /* SQL to insert data */
      private static final String SQL_SELECTALL =
       "SELECT "
        + "matriculaP, nombre, paterno, materno, fechaN, calle, colonia, "
        + "num, cp, sexo, email "
        + "FROM profesor";
      
    private static final String SQL_INSERT =
        "INSERT INTO profesor ("
        + "matriculaP, nombre, paterno, materno, fechaN, calle, colonia, "
        + "num, cp, sexo, email"
        + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "matriculaP, nombre, paterno, materno, fechaN, calle, colonia, "
        + "num, cp, sexo, email "
        + "FROM profesor WHERE "
        + "matriculaP = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE profesor SET "
        + "nombre = ?, paterno = ?, materno = ?, fechaN = ?, calle = ?, colonia = ?, num = ?,  "
        + "cp = ?, sexo = ?, email = ? "
        + "WHERE "
        + "matriculaP = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM profesor WHERE "
        + "matriculaP = ?";


   
    public void create(Profesor bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setLong(1, bean.getMatriculap());
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
    public Profesor load(Profesor key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setLong(1, key.getMatriculap());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Profesor) results.get(0);
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
    public void update(Profesor bean, Connection conn) throws SQLException {
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
            ps.setLong(11, bean.getMatriculap());
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
    public void delete(Profesor key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setLong(1, key.getMatriculap());
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

    protected List<Profesor> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Profesor>();
        while (rs.next()) {
            Profesor bean = new Profesor();
            bean.setMatriculap(rs.getLong("matriculaP"));
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
            results.add(bean);
        }
        return results;
    }
    
    public Profesor findByUserNameAndPassword(String user, String clave, Connection conn) throws SQLException{
        
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareCall(SQL_LOGIN);
            ps.setString(1, user);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            List resultado = getResults(rs);
            if (resultado.size() > 0) {
                return (Profesor) resultado.get(0);
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