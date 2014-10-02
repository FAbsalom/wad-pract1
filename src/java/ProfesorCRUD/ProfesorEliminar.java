package ProfesorCRUD;

import DAO.PreguntaDAO;
import DAO.ProfesorDAO;
import DTO.Pregunta;
import DTO.Profesor;
import MateriaCRUD.MostrarMateria;
import Utilerias.Conexion;
import Utilerias.ConfiguraSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfesorEliminar extends HttpServlet {

    Conexion conn = new Conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String se = "";
            ConfiguraSession s1 = new ConfiguraSession();
            if (s1.isSession(request)) {
                HttpSession sesion = request.getSession(false);  //getSession (false) comprobará la existencia de la sesión. Si existe la sesión, entonces se devuelve la referencia de ese objeto de sesión, si no es así, estos métodos se devolverá null.
//                se = (String) sesion.getAttribute(ConfiguraSession.login_name);
            } else {
                response.sendRedirect("Login.html");
                return;
            }
        Profesor dto = new Profesor();
        String getIdpregunta = request.getParameter("idItem");
        dto.setMatriculap(Integer.parseInt(getIdpregunta));
        ProfesorDAO dao = new ProfesorDAO();
        try {
            dao.delete(dto, conn.ObtenerConexion());
            response.sendRedirect("ProfesorMostrar");
        } catch (SQLException ex) {
            Logger.getLogger(MostrarMateria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MostrarMateria.class.getName()).log(Level.SEVERE, null, ex);
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
