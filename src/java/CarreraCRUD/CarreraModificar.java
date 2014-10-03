/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CarreraCRUD;

import DAO.CarreraDAO;
import DTO.Carrera;
import Utilerias.Conexion;
import java.io.IOException;
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
public class CarreraModificar extends HttpServlet {

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
    Conexion conn=new Conexion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Carrera dto = new Carrera();

        String idcarrera=request.getParameter("idItem");
        String duracion = request.getParameter("duracion").trim();
        String nombre = request.getParameter("nombre").trim();
/*
        if (fechaN.isEmpty() | materia.isEmpty() | periodo.isEmpty()) {
            response.sendRedirect("login.html");
        }
*/      dto.setIdcarrera(Integer.parseInt(idcarrera));
        dto.setDuracion(Integer.parseInt(duracion));
        dto.setNombre(nombre);

        CarreraDAO edao = new CarreraDAO();
        //System.out.println(exam.toString());
        try {
            edao.update(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
            // System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(ex);
        }
        //System.out.println(user.toString());
        response.sendRedirect("CarreraMostrar");
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
