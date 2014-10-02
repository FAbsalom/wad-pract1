/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfesorCRUD;

import DAO.ExamenDAO;
import DAO.PreguntaDAO;
import DAO.ProfesorDAO;
import DTO.Pregunta;
import DTO.Profesor;
import Utilerias.Conexion;
import Utilerias.ConfiguraSession;
import controller.servlets.ExamenCRUD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
public class ProfesorModificarVista extends HttpServlet {

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
        ProfesorDAO dao = new ProfesorDAO();
        Profesor dto = new Profesor(), dato = null;
        dto.setMatriculap(Integer.parseInt(request.getParameter("idItem")));
        try {
            dato = dao.load(dto, conn.ObtenerConexion());
            if (dato == null) {
                response.sendRedirect("ProfesorMostrar");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String checkM="";
            if(dato.getSexo().equals("M"))
                checkM="checked";
            String checkF="";
            if(dato.getSexo().equals("F"))
                checkF="checked";
              out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "    <head>"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">       "
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                    + "        <title>PROFESOR</title>"
                    + ""
                    + "        <!-- Bootstrap -->"
                    + "        <link href = \"./Css/bootstrap.min.css\" rel = \"stylesheet\">"
                    + "        <link href = \"./Css/styles.css\" rel = \"stylesheet\">"
                    + "        <link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "        <script src=\"./js/jquery-2.1.1.js\" type=\"text/javascript\"><!--mce:0--><!--mce:0--></script>"
                    + "        <script src=\"js/jquery.validate.js\" type=\"text/javascript\"><!--mce:1--><!--mce:1--></script>"
                    + "    </head>"
                    + "    <body>"
                    + "<div class=\"logo\">  "
                    + "</div>"
                    + "    "
                    + "<form class=\"form-horizontal\" id=\"formulario_registro1\" action=\"ProfesorModificar\" method=\"post\">"
                    + "     "
                    + "    <h2>Registro de Profesores</h2>"
                    + "    <div class=\"line\" text-center></div>"
                    + "    <LABEL for=\"matricula\" style=\"text-align:center\">Matricula: </LABEL>            "
                    + "            <INPUT style=\"text-align:center\" type=\"hidden\" value=\""+dato.getMatriculap()+"\" name=\"matricula\" >                    "
                    + "            <INPUT style=\"text-align:center\" type=\"text\" value=\""+dato.getMatriculap()+"\" name=\"matricula\" disabled>                    "
                    + "        <LABEL for=\"nombre\" style=\"text-align:center\">Nombre: </LABEL>            "
                    + "            <INPUT style=\"text-align:center\" type=\"text\" value=\""+dato.getNombre()+"\"name=\"nombre\">                    "
                    + "        <LABEL for=\"apellidoP\" style=\"text-align:center\" >Apellido Paterno: </LABEL>"
                    + "             <INPUT  style=\"text-align:center\"  type=\"text\"  value=\""+dato.getPaterno()+"\"name=\"paterno\"> "
                    + "        <LABEL for=\"apellidoM\" style=\"text-align:center\">Apellido Materno: </LABEL>"
                    + "                <INPUT  style=\"text-align:center\" type=\"text\"  value=\""+dato.getMaterno()+"\" name=\"materno\"> "
                    + "        <LABEL for=\"email\" style=\"text-align:center\" >email: </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" value=\""+dato.getEmail()+"\" name=\"email\"> "
                    + "       <LABEL for=\"fechaN\" style=\"text-align:center\" >Fecha de Nacimiento </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\"  value=\""+dato.getFechan()+"\" name=\"fechaN\"> "
                    + "        <LABEL for=\"calle\" style=\"text-align:center\" >Callle </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\"  value=\""+dato.getCalle()+"\" name=\"calle\"> "
                    + "        <LABEL for=\"colonia\" style=\"text-align:center\" >Colonia </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\"  value=\""+dato.getColonia()+"\" name=\"colonia\"> "
                    + "       <LABEL for=\"Numero\" style=\"text-align:center\" >Número </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" value=\""+dato.getNum()+"\" name=\"Numero\"> "
                    + "        <LABEL for=\"Cp\" style=\"text-align:center\" >Codigo Postal </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\"  value=\""+dato.getCp()+"\"  name=\"CP\"> "
                    + "        <LABEL for=\"sexo\" style=\"text-align:center\" >Sexo </LABEL>"                    
                    + "               <input style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"M\""+checkM+"> Masculino\n"
                    + "               <input  style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"F\""+checkF+">Femenino\n"
                    + "               <br>"
                    + "    <button name=\"Registar\" type=\"submit\" class=\"btn btn-lg btn-primary btn-sign-in\" >Guardar Datos\n"
                    + "    </button>   "
                    + "</form>"
                    + "<a href=\"ProfesorMostrar\">"
                    + "<input class=\"btn btn-lg btn-primary btn-sign-in\" type=\"submit\" value=\"Cancelar\">"
                    + "</a>"
                    + "</body>"
                    + "</html>");
        } finally {
            out.close();
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
