/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CalificacionesCRUD;

import DAO.CalificacionesDAO;
import DTO.Calificaciones;
import Utilerias.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pwned
 */
public class CalificacionesAgregar extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Conexion conn = new Conexion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Calificaciones dto = new Calificaciones();
        
        String puntuaje = request.getParameter("puntuaje").trim();
        String matriculaa = request.getParameter("comboAlumno").trim();
        String matriculap = request.getParameter("comboProfesor").trim();
        String idexamen = request.getParameter("comboExamen").trim();
        /*
         if (fechaN.isEmpty() | materia.isEmpty() | periodo.isEmpty()) {
         response.sendRedirect("login.html");
         }
         */
        dto.setPuntaje(Integer.parseInt(puntuaje));
        dto.setIdexamen(Integer.parseInt(idexamen));
        dto.setMatriculaa(Integer.parseInt(matriculaa));
        dto.setMatriculap(Integer.parseInt(matriculap));

        CalificacionesDAO edao = new CalificacionesDAO();
        //System.out.println(exam.toString());
        try {
            edao.create(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            // System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CalificacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(ex);
        }
        //System.out.println(user.toString());
        response.sendRedirect("CalificacionesMostrar");
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
        processRequest(request, response);
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
