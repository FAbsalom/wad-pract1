package ProfesorCRUD;

import DAO.ProfesorDAO;
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

public class ProfesorMostrar extends HttpServlet {

    Conexion conn = new Conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProfesorDAO dao = new ProfesorDAO();
        List listaDatos = null;
        String usuario, pass;


        Profesor dto = new Profesor(), dato = null;
        try {
            String se = "";
            ConfiguraSession s1 = new ConfiguraSession();
            Profesor dto1;
            if (s1.isSession(request)) {
                HttpSession sesion = request.getSession(false);  //getSession (false) comprobará la existencia de la sesión. Si existe la sesión, entonces se devuelve la referencia de ese objeto de sesión, si no es así, estos métodos se devolverá null.
                pass = (String) sesion.getAttribute(ConfiguraSession.password);
                Object obj = s1.getObjeto(request);
                dto1 = (Profesor) obj;
            } else {
                response.sendRedirect("Login.html");
                return;
            }
            dato = dao.load(dto1, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String checkM = "";
            if (dato.getSexo().equals("M")) {
                checkM = "checked";
            }
            String checkF = "";
            if (dato.getSexo().equals("F")) {
                checkF = "checked";
            }
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "	<head>"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
                    + "    <title>Inicio de Sesión</title>"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                    + "    <!-- Bootstrap -->"
                    + "    <link href=\"./Css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "    <link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "    <script src=\"./js/jquery-2.1.1.js\" type=\"text/javascript\"><!--mce:0--><!--mce:0--> </script>"
                    + "    <script src=\"js/jquery.validate.js\" type=\"text/javascript\"><!--mce:1--><!--mce:1--></script>"
                    + "</head>"
                    + "<body>"
                    + "<div class=\"logo\">  "
                    + "</div>"
                    + "    "
                    + "<form class=\"form-horizontal\" id=\"formulario_registro1\" action=\"ProfesorModificarVista\" method=\"post\">"
                    + "     "
                    + "    <h2>Detalles de mi cuenta</h2>"
                    + "    <div class=\"line\" text-center></div>"
                    + "    <LABEL for=\"matricula\" style=\"text-align:center\">Matricula: </LABEL>            "
                    + "            <INPUT style=\"text-align:center\" type=\"hidden\" value=\"" + dato.getMatriculap() + "\" name=\"idItem\" >                    "
                    + "            <INPUT style=\"text-align:center\" type=\"text\" value=\"" + dato.getMatriculap() + "\" name=\"matricula\" disabled>                    "
                    + "        <LABEL for=\"nombre\" style=\"text-align:center\">Nombre: </LABEL>            "
                    + "            <INPUT style=\"text-align:center\" type=\"text\" value=\"" + dato.getNombre() + "\"name=\"nombre\" disabled>                    "
                    + "        <LABEL for=\"apellidoP\" style=\"text-align:center\" >Apellido Paterno: </LABEL>"
                    + "             <INPUT  style=\"text-align:center\"  type=\"text\"  value=\"" + dato.getPaterno() + "\"name=\"paterno\" disabled> "
                    + "        <LABEL for=\"apellidoM\" style=\"text-align:center\">Apellido Materno: </LABEL>"
                    + "                <INPUT  style=\"text-align:center\" type=\"text\"  value=\"" + dato.getMaterno() + "\" name=\"materno\" disabled> "
                    + "        <LABEL for=\"email\" style=\"text-align:center\" >email: </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" value=\"" + dato.getEmail() + "\" name=\"email\" disabled> "
                    + "       <LABEL for=\"fechaN\" style=\"text-align:center\" >Fecha de Nacimiento </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\"  value=\"" + dato.getFechan() + "\" name=\"fechaN\" disabled> "
                    + "        <LABEL for=\"calle\" style=\"text-align:center\" >Callle </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\"  value=\"" + dato.getCalle() + "\" name=\"calle\" disabled> "
                    + "        <LABEL for=\"colonia\" style=\"text-align:center\" >Colonia </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\"  value=\"" + dato.getColonia() + "\" name=\"colonia\" disabled> "
                    + "       <LABEL for=\"Numero\" style=\"text-align:center\" >Número </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" value=\"" + dato.getNum() + "\" name=\"Numero\" disabled> "
                    + "        <LABEL for=\"Cp\" style=\"text-align:center\" >Codigo Postal </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\"  value=\"" + dato.getCp() + "\"  name=\"CP\" disabled> "
                    + "        <LABEL for=\"sexo\" style=\"text-align:center\" >Sexo </LABEL>"
                    + "               <input style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"M\"" + checkM + "> Masculino\n"
                    + "               <input  style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"F\"" + checkF + " >Femenino\n"
                    + "               <br>"
                    + "  <button name=\"Modificar\" type=\"submit\" class=\"btn btn-lg btn-primary btn-sign-in\" >Modificar\n"
                    + "            </button>"
                    + "</form>"
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
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Examen</title>");
//            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/stylesheet.css\"/>");
//            out.println("<script type=\"text/javascript\" src=\"js/jquery-1.11.1.js\"></script>");
//            out.println("<script type=\"text/javascript\" src=\"js/anim.js\"></script>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Preguntas Registradas:</h1>");
//            out.println("<table style=\"border: navy dashed\">"
//                    + "<thead>"
//                    + "<tr>"
//                    + "<th>Pregunta </th>"
//                    + "<th>IdExamen</th>"
//                    + "</tr>"
//                    + "</thead>"
//                    + "<tbody>");
//
//            if (listaDatos != null) {
//                for (Object object : listaDatos) {
//                    out.println("<form >"
//                            + "<input type=\"hidden\" name=\"idItem\"  value=" + ((Profesor) object).getMatriculap() + ">");
//                    out.print("<tr>"
//                            + "<td ><div >" + ((Profesor) object).getMatriculap() + "</div></td>"
//                            + "<td><div >" + ((Profesor) object).getNombre() + "</div></td>"
//                            + "<td><div >" + ((Profesor) object).getPaterno() + "</div></td>"
//                            + "<td><div >" + ((Profesor) object).getMaterno() + "</div></td>"
//                            + "<td><div >" + ((Profesor) object).getEmail() + "</div></td>"
//                            + "<td><div >" + ((Profesor) object).getFechan() + "</div></td>"
//                            + "<td><div >" + ((Profesor) object).getCalle() + "</div></td>"
//                            + "<td><div >" + ((Profesor) object).getColonia() + "</div></td>"
//                            + "<td><div >" + ((Profesor) object).getNum() + "</div></td>"
//                            + "<td><div >" + ((Profesor) object).getCp() + "</div></td>"
//                            + "<td><div >" + ((Profesor) object).getSexo() + "</div></td>"
//                            + "<td>" + "<input type=\"submit\" value=\"editar\" formaction=\"ProfesorModificarVista\" formmethod=\"post\">" + "</td>"
//                            + "<td>" + "<input type=\"submit\" value=\"eliminar\" formaction=\"ProfesorEliminar\" formmethod=\"post\">" + "</td>"
//                            + "</tr>");
//                    out.print("</form>");
//                }
//            }
//            out.println("</tbody>"
//                    + "</table>");
//            out.println("<br><form  >");
//            out.println("<input type=\"submit\" value=\"Agregar\" formaction=\"ProfesorAgregarVista\" formmethod=\"post\">");
//            out.print("</form>");
//            out.println("<a href=\" \"><input type=\"submit\" value=\"Regresar\"></a> ");
//            out.println("</body>");
//            out.println("</html>");
