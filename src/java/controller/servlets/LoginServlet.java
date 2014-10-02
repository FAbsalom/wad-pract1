package controller.servlets;

import DTO.Profesor;
import DTO.Alumno;
import DAO.AlumnoDAO;
import DAO.ProfesorDAO;
import DTO.*;
import Utilerias.ConfiguraSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Utilerias.Conexion;
import java.sql.SQLException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usr = request.getParameter("NombreUsr").trim();
        String clave = request.getParameter("Clave").trim();
        Alumno alumnos = null;
        Profesor profesores = null;
        boolean isStudent = false, isTeacher = false;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            Conexion con = new Conexion();
            AlumnoDAO daoalumno = new AlumnoDAO();
            ProfesorDAO daoprofe = new ProfesorDAO();
            alumnos = daoalumno.findByUserNameAndPassword(usr, clave, con.ObtenerConexion());
            profesores = daoprofe.findByUserNameAndPassword(usr, clave, con.ObtenerConexion());
            
            if (alumnos != null) {
                isStudent = true;
            }
            if (profesores != null) {
                isTeacher = true;
            }
            if (isStudent && isTeacher) {
                response.sendRedirect("ServletPerfil");
                return;
            }
            

            if (isStudent) {
                ConfiguraSession sesion = new ConfiguraSession();
                sesion.CreaSession(request, response, alumnos,"alumno");
                response.sendRedirect("ServletAlumno");
                return;
            }
            if (isTeacher) {
                ConfiguraSession sesion = new ConfiguraSession();
                sesion.CreaSession(request, response, profesores,"profesor");
                response.sendRedirect("ServletProfesor");
                return;
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <link href=\"./Css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "<link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">");
            out.println("<title>Servlet Inicio de Sesion</title>");
            out.println("</head>");
            out.println("<body> ");
            out.println("<br/> <br/> <br/> <br/> <br/> ");
            out.println("<h2 class=\"logo\">" + "No se encontro el Usuario" + "</h2>");
            out.println("</body>");
            out.println("</html>");
            out.println("  <a  href=\"Login.html\"> <input class=\"btn  regresar\" type=\"submit\" value=\"Regresar\" name=\"return\" /></a>");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
