package controller.servlets;

import DAO.AlumnoDAO;
import DAO.ProfesorDAO;
import DTO.Alumno;
import DTO.Profesor;
import Reporte.GeneraPDFDinamico;
import Utilerias.Conexion;
import Utilerias.EnvioEmail;
import Utilerias.SubirArchivo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

public class RegistroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException {

        try {        
            Conexion con= new Conexion();         
            AlumnoDAO daoalumno= new AlumnoDAO();
            Alumno alumno= new Alumno();
            String  matricula,nombre,paterno,materno,fechaN,calle,colonia,num,cp,sexo,email="";
            matricula=request.getParameter("matricula");
            nombre=request.getParameter("nombre");
            paterno=request.getParameter("paterno");
            materno=request.getParameter("materno");
            fechaN=request.getParameter("fechaN");
            calle=request.getParameter("calle");
            colonia=request.getParameter("colonia");
            num=request.getParameter("Numero");
            cp=request.getParameter("CP");
            sexo=request.getParameter("sexo");
            email=request.getParameter("email");
            Alumno bean = new Alumno();
            alumno.setMatriculaa(Long.valueOf(matricula));
            alumno.setNombre(nombre);
            alumno.setPaterno(paterno);
            alumno.setMaterno(materno);
            alumno.setFechan(Date.valueOf(fechaN));
            alumno.setCalle(calle);
            alumno.setColonia(colonia);
            alumno.setNum(Integer.parseInt(num));
            alumno.setCp(Integer.parseInt(cp));
            alumno.setSexo(sexo);
            alumno.setEmail(email);
            alumno.setClave("-");
            alumno.setIdcarrera(1);     
            GeneraPDFDinamico pdf= new GeneraPDFDinamico();
            pdf.PDFUsuario(alumno, "REGISTRO DE USUARIO ", response, request);
            EnvioEmail mail = new EnvioEmail();                   
            String ruta="C:\\Users\\Pwned\\JaspersoftWorkspace\\MyReports\\"+ String.valueOf(alumno.getMatriculaa())+".pdf";
            mail.processRequest(request, response, alumno.getEmail(),"Correo generado autoaticamente al momento de su registro", ruta, "REGISTRO DE USUARIO");
            daoalumno.create(alumno, con.ObtenerConexion());
            
            response.sendRedirect("Login.html");
       
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println(ex);
        } finally {
            
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP
 * <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            ex.printStackTrace();            
            System.err.println(ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
