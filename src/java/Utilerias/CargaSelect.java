package Utilerias;

import DAO.AlumnoDAO;
import DAO.CarreraDAO;
import DAO.ExamenDAO;
import DAO.MateriaDAO;
import DAO.PreguntaDAO;
import DAO.ProfesorDAO;
import DAO.RespuestaDAO;
import DTO.Alumno;
import DTO.Carrera;
import DTO.Examen;
import DTO.Materia;
import DTO.Pregunta;
import DTO.Profesor;
import DTO.Respuesta;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author absalom
 */
public class CargaSelect {
    static Conexion conn=new Conexion();
    public static String conAlumno() {
        
        String resp="<select  class=\"form-control\" name=\"combo\" >";
        List lista=null;
        AlumnoDAO dao= new AlumnoDAO();
        try{
        lista=dao.loadALL(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lista==null){
        return resp+="<option value=\"none\">"+"No hay Datos"+"</option>";    
        }
        for (Object o : lista) {
            resp+="<option value=\""+((Alumno) o).getMatriculaa()+"\">"+((Alumno) o).getNombre()+" "+((Alumno) o).getPaterno()+"</option>";
//            resp+="</select>";
//            return resp;
        }
        resp+="</select>";
        return resp;
    }
    
    public static String conProfesor(){
        String resp="<select  class=\"form-control\" name=\"combo\" >";
        List lista=null;
        ProfesorDAO dao= new ProfesorDAO();
        try{
        lista=dao.loadALL(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lista==null){
        return resp+="<option value=\"none\">"+"No hay Datos"+"</option>";    
        }
        for (Object o : lista) {
            resp+="<option value=\""+((Profesor) o).getMatriculap()+"\">"+((Profesor) o).getNombre()+" "+((Profesor) o).getPaterno()+"</option>";
//            resp+="</select>";
//            return resp;
        }
        resp+="</select>";
        return resp;
    }
    
    public static String conExamen(){
        String resp="<select  class=\"form-control selectpicker \" name=\"combo\">";
        List lista=null;
        ExamenDAO dao= new ExamenDAO();
        try{
        lista=dao.loadALL(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lista==null){
         resp+="<option value=\"none\">"+"No hay Datos"+"</option>";    
             resp+="</select>";
            return resp;
        }
        for (Object o : lista) {
            resp+="<option value=\""+((Examen) o).getIdexamen()+"\">"+"periodo: "+
                    ((Examen) o).getPeriodo()+"| materia: "+((Examen) o).getIdmateria()+
                    "| fecha: "+((Examen) o).getFecha()+"</option>";
       
        }
        resp+="</select>";
        return resp;
    }
    
    public static String conCalificacion(){
        
        return null;
    }
    
    public static String conCarrera() {
        String resp="<select  class=\"form-control\" name=\"combo\" >";
        List lista=null;
        CarreraDAO dao= new CarreraDAO();
        try{
        lista=dao.loadAll(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lista==null){
        return resp+="<option value=\"none\">"+"No hay Datos"+"</option>";    
        }
        for (Object o : lista) {
            resp+="<option value=\""+((Carrera) o).getIdcarrera()+"\">"+
                    ((Carrera) o).getNombre()+"</option>";
//            resp+="</select>";
//            return resp;
        }
        resp+="</select>";
        return resp;
    }
    
    public static String conMateria() {
        String resp="<select   class=\"form-control\" name=\"combo\" >";
        List lista=null;
        MateriaDAO dao= new MateriaDAO();
       try{
        lista=dao.loadALL(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lista==null){
        return resp+="<option value=\"none\">"+"No hay Datos"+"</option>";    
        }
        for (Object o : lista) {
            resp+="<option value=\""+((Materia) o).getIdmateria()+"\">"+
                    ((Materia) o).getNombre()+"</option>";
//            resp+="</select>";
//            return resp;
        }
        resp+="</select>";
        return resp;
    }
    
    public static String conPregunta(){
        String resp="<select  class=\"form-control\" name=\"combo\" >";
        List lista=null;
        PreguntaDAO dao= new PreguntaDAO();
       try{
        lista=dao.loadALL(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lista==null){
        return resp+="<option value=\"none\">"+"No hay Datos"+"</option>";    
        }
        for (Object o : lista) {
            resp+="<option value=\""+((Pregunta) o).getIdpregunta()+"\">"+
                    ((Pregunta) o).getPregunta()+"</option>";
//            resp+="</select>";
//            return resp;
        }
        resp+="</select>";
        return resp;
    }
    
    public static String conRespuesta(){
        String resp="<select  class=\"form-control selectpicker \" name=\"combo\" >";
        List lista=null;
        RespuestaDAO dao= new RespuestaDAO();
       try{
        lista=dao.loadALL(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lista==null){
        return resp+="<option value=\"none\">"+"No hay Datos"+"</option>";    
        }
        for (Object o : lista) {
            resp+="<option value=\""+((Respuesta) o).getIdpregunta()+"\">"+
                    ((Respuesta) o).getRespuesta()+"</option>";
//            resp+="</select>";
//            return resp;
        }
        resp+="</select>";
        return resp;
    }
}
