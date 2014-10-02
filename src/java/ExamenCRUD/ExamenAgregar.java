/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenCRUD;

import DAO.ExamenDAO;
import DTO.Examen;
import Utilerias.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
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
public class ExamenAgregar extends HttpServlet {
Conexion conn = new Conexion();
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Examen exam = new Examen();
        String  fechaN = request.getParameter("fecha").trim();
        Date date=new Date(request.getParameter("fecha").trim());
        String materia = request.getParameter("materia").trim();
        String periodo = request.getParameter("periodo").trim();

        if (fechaN.isEmpty() | materia.isEmpty() | periodo.isEmpty()) {
            response.sendRedirect("login.html");
        }
        
        exam.setFecha(date);
        exam.setIdmateria(Integer.parseInt(materia));
        exam.setPeriodo(Integer.parseInt(periodo));

        ExamenDAO edao = new ExamenDAO();
        //System.out.println(exam.toString());
        try {
            edao.create(exam, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(ExamenDAO.class.getName()).log(Level.SEVERE, null, ex);
            // System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenDAO.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(ex);
        }
        //System.out.println(user.toString());
        response.sendRedirect("ExamenCRUD");
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
