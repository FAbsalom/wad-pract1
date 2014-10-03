/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlumnoCRUD;

import DAO.AlumnoDAO;
import DTO.Alumno;
import Utilerias.CargaSelect;
import Utilerias.Conexion;
import controller.CRUD.AlumnoCRUD;
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
public class AlumnoModficarVista extends HttpServlet {

    Conexion conn = new Conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String key = request.getParameter("idItem");
        Alumno dto = new Alumno(), dto2 = null;
        dto.setMatriculaa(Integer.parseInt(key));

        AlumnoDAO dao = new AlumnoDAO();
        try {
            dto2 = dao.load(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (dto2 == null) {
            response.sendRedirect("AlumnoMostrar");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
     
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "	<head>\n"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n"
                    + "    <title> Inicio de Sesión </title>\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    <!-- Bootstrap -->\n"
                    + "    <link href=\"./Css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n"
                    + "    <link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">\n"
                    + "    <script src=\"./js/jquery-2.1.1.js\" type=\"text/javascript\"><!--mce:0--><!--mce:0--> </script>\n"
                    + "    <script src=\"js/jquery.validate.js\" type=\"text/javascript\"><!--mce:1--><!--mce:1--></script>    \n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<div class=\"logo\">  \n"
                    + "</div>\n"
                    + "    \n"
                    + "<form class=\"form-horizontal\" id=\"formulario_registro1\" action=\"AlumnoModificar\" method=\"post\">     \n"+
                    "<input type=\"hidden\" value=" + dto2.getMatriculaa() + " name=\"idAlumno\" >"
                    + "          <input type=\"hidden\" value=\"update\" name=\"accion\" >"
                    + "    <h2>Registro de Usuario</h2>\n"
                    + "\n"
                    + "    <div class=\"line\" text-center></div>\n"
                    + "    <LABEL for=\"matricula\" style=\"text-align:center\">Matricula: </LABEL>            \n"
                    + "            <INPUT style=\"text-align:center\" type=\"text\" name=\"matricula\" id=\"matricula\" value=\""+dto2.getMatriculaa()+"\" disabled>                    \n"
                    + "        <LABEL for=\"nombre\" style=\"text-align:center\">Nombre: </LABEL>            \n"
                    + "            <INPUT style=\"text-align:center\" type=\"text\" name=\"nombre\" id=\"nombre\" value=\"" + dto2.getNombre() + "\">                    \n"
                    + "        <LABEL for=\"apellidoP\" style=\"text-align:center\" >Apellido Paterno: </LABEL>\n"
                    + "             <INPUT  style=\"text-align:center\"  type=\"text\" name=\"paterno\" id=\"paterno\" value=\"" + dto2.getPaterno() + "\"> \n"
                    + "        <LABEL for=\"apellidoM\" style=\"text-align:center\">Apellido Materno: </LABEL>\n"
                    + "                <INPUT  style=\"text-align:center\" type=\"text\" name=\"materno\" id=\"materno\" value=\"" + dto2.getMaterno() + "\">  \n"
                    + "       <LABEL for=\"fechaN\" style=\"text-align:center\" >Fecha de Nacimiento </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"date\" name=\"fecha\" id=\"fechaN\" value=\"" + dto2.getFechan()+ "\" > \n"
                    + "        <LABEL for=\"calle\" style=\"text-align:center\" >Callle </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"calle\" id=\"calle\" value=\"" + dto2.getCalle() + "\"> \n"
                    + "        <LABEL for=\"colonia\" style=\"text-align:center\" >Colonia </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"colonia\" id=\"colonia\" value=\"" + dto2.getColonia() + "\"> \n"
                    + "       <LABEL for=\"Numero\" style=\"text-align:center\" >Número </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"numero\" id=\"Numero\" value=\"" + dto2.getNum() + "\"> \n"
                    + "        <LABEL for=\"Cp\" style=\"text-align:center\" >Codigo Postal </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"cp\" id=\"CP\" value=\"" + dto2.getCp() + "\"> \n"
                    + "        <LABEL for=\"sexo\" style=\"text-align:center\" >Sexo </LABEL>\n");
                    if(dto2.getSexo().equalsIgnoreCase("M")){
                    out.print("               <input style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"M\" checked> Masculino\n"
                    + "               <input  style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"F\"> Femenino\n");
                        
                    }else{
                    out.print("               <input style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"M\"> Masculino\n"
                    + "               <input  style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"F\" checked> Femenino\n");
                        
                    }
                    out.println( "               <br>\n"
                    + "        <LABEL for=\"email\" style=\"text-align:center\" >E-mail: </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"email\" id=\"email\" value=\"" + dto2.getEmail()+ "\">\n"
                    +CargaSelect.conCarrera(dto2.getIdcarrera())
                    + "\n"
                    + "    <button name=\"Registar\" type=\"submit\" class=\"btn btn-lg btn-primary btn-sign-in\" >Guardar Datos\n"
                    + "    </button>    \n"
                    + "</form>\n"
                    + "    <a href=\"login.html\">	\n"
                    + "<input class=\"btn btn-lg btn-primary btn-sign-in\" type=\"submit\" value=\"Regresar\"></a>\n"
                    + "</body>\n"
                    + "</html>\n"
                    + "");
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
