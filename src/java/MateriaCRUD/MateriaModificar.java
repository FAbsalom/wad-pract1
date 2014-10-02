/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MateriaCRUD;

import DAO.MateriaDAO;
import DTO.Materia;
import Utilerias.Conexion;
import controller.servlets.ExamenCRUD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MateriaModificar extends HttpServlet {
        Conexion conn = new Conexion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Materia mate = new Materia();
        String idmateria=request.getParameter("idItem");
        String nombre=request.getParameter("getNombre");
        String creditos=request.getParameter("getCreditos");
        mate.setIdmateria(Integer.parseInt(idmateria));
        mate.setCreditos(creditos);
        mate.setNombre(nombre);        
        MateriaDAO dao = new MateriaDAO();
        try {
            dao.update(mate, conn.ObtenerConexion());
            response.sendRedirect("MostrarMateria");           
        } catch (SQLException ex) {
            Logger.getLogger(MostrarMateria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MostrarMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{            
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
