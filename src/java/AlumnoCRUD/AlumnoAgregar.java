/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlumnoCRUD;

import DAO.AlumnoDAO;
import DTO.Alumno;
import Utilerias.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Date;
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
public class AlumnoAgregar extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */ Conexion conn = new Conexion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Alumno dto = new Alumno();
        String matricula, nombre, paterno, materno, fechaN, calle, colonia, num, cp, sexo, email = "", idcarrera;
        matricula = request.getParameter("matricula");
        nombre = request.getParameter("nombre");
        paterno = request.getParameter("paterno");
        materno = request.getParameter("materno");
        fechaN = request.getParameter("fecha");
        calle = request.getParameter("calle");
        colonia = request.getParameter("colonia");
        num = request.getParameter("numero");
        cp = request.getParameter("cp");
        sexo = request.getParameter("sexo");
        email = request.getParameter("email");
        idcarrera = request.getParameter("combo");

        /*if (fechaN.isEmpty() | materia.isEmpty() | periodo.isEmpty()) {
         response.sendRedirect("login.html");
         }*/
        dto.setMatriculaa(Long.valueOf(matricula));
        dto.setNombre(nombre);
        dto.setPaterno(paterno);
        dto.setMaterno(materno);
        dto.setFechan(Date.valueOf(fechaN));
        dto.setCalle(calle);
        dto.setColonia(colonia);
        dto.setNum(Integer.parseInt(num));
        dto.setCp(Integer.parseInt(cp));
        dto.setSexo(sexo);
        dto.setEmail(email);
        dto.setClave("-");
        dto.setIdcarrera(Integer.parseInt(idcarrera));
        AlumnoDAO dao = new AlumnoDAO();
        //System.out.println(exam.toString());
        try {
            dao.create(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            // System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(ex);
        }
        //System.out.println(user.toString());
        response.sendRedirect("AlumnoMostrar");
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
