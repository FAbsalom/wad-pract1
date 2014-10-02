package ProfesorCRUD;

import DAO.ProfesorDAO;
import DTO.Profesor;
import Reporte.GeneraPDFDinamico;
import Utilerias.Conexion;
import Utilerias.ConfiguraSession;
import Utilerias.EnvioEmail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pwned
 */
public class ProfesorModificar extends HttpServlet {

    Conexion conn = new Conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String se = "";
            ConfiguraSession s1 = new ConfiguraSession();
            if (s1.isSession(request)) {
                HttpSession sesion = request.getSession(false);  //getSession (false) comprobará la existencia de la sesión. Si existe la sesión, entonces se devuelve la referencia de ese objeto de sesión, si no es así, estos métodos se devolverá null.
//                se = (String) sesion.getAttribute(ConfiguraSession.login_name);
            } else {
                response.sendRedirect("Login.html");
                return;
            }
            ProfesorDAO dao = new ProfesorDAO();
            Profesor dto = new Profesor();
            String matricula, nombre, paterno, materno, fechaN, calle, colonia, num, cp, sexo, email = "";
            matricula = request.getParameter("matricula");
            nombre = request.getParameter("nombre");
            paterno = request.getParameter("paterno");
            materno = request.getParameter("materno");
            fechaN = request.getParameter("fechaN");
            calle = request.getParameter("calle");
            colonia = request.getParameter("colonia");
            num = request.getParameter("Numero");
            cp = request.getParameter("CP");
            sexo = request.getParameter("sexo");
            email = request.getParameter("email");      
            dto.setMatriculap(Long.valueOf(matricula));
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
            dao.update(dto, conn.ObtenerConexion());
            GeneraPDFDinamico pdf= new GeneraPDFDinamico();
            pdf.PDFUsuarioP(dto, "ACTUALIZACION DE DATOS ", response, request);
            EnvioEmail mail = new EnvioEmail();                   
            String ruta="C:\\Users\\Pwned\\JaspersoftWorkspace\\MyReports\\"+ matricula+".pdf";
            mail.processRequest(request, response, dto.getEmail(),"Correo generado por una actualizacion a sus datos", ruta, "Actualizacion de datos");            
            
            response.sendRedirect("ProfesorMostrar");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfesorAgregar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorAgregar.class.getName()).log(Level.SEVERE, null, ex);
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
