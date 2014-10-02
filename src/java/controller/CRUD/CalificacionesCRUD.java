package controller.CRUD;

import DAO.CalificacionesDAO;
import DTO.Calificaciones;
import Utilerias.Conexion;
import Utilerias.ConfiguraSession;
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

/**
 *
 * @author absalom
 */
public class CalificacionesCRUD extends HttpServlet {

    Conexion conn = new Conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ConfiguraSession se = new ConfiguraSession();
        if (!se.isSession(request)) {
            response.sendRedirect("Login.html");
        }
        if(!se.isType(request).equalsIgnoreCase("profesor")){
            response.sendRedirect("ErrorServletl");
        }


        String accion = request.getParameter("accion");

        //update(request, response, "45");

        if (accion == null) {
            read(request, response);
            return;
        }
        //int item=
        if (accion.equalsIgnoreCase("read")) {
            /*PrintWriter out = response.getWriter();
             out.print(request.getHeaderNames()+""+request.getParameterNames()+"");
             Enumeration<String> param= request.getParameterNames();
             out.println(param.toString());
            
             out.println("read");
             */

            update(request, response, request.getParameter("idItem"));
            return;
            /*
             if (request.getParameter("eliminar") != null) {
             delete(request, response, request.getParameter("idItem"));
             return;
             }*/
        }

        if (accion.equalsIgnoreCase("createR")) {
            create(request, response);
            return;
        }

        if (accion.equalsIgnoreCase("create")) {
            createResponse(request, response);
            return;
        }
        if (accion.equalsIgnoreCase("update")) {
            updateResponse(request, response);
            return;
        }

    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CalificacionesUpdate</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n"
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"CalificacionesCRUD\" method=\"POST\">\n<input type=\"hidden\" value=\"\"" + " name=\"idCalificaciones\" >"
                    + "          <input type=\"hidden\" value=\"create\" name=\"accion\" >"
                    + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th colspan=\"2\" align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td>Puntuaje: </td>\n"
                    + "        				<td><input type=\"text\" name=\"puntuaje\" value=\"\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "                                    <td><label>matricula al:</label></td>\n"
                    + "        				<td> <input type=\"text\" name= \"matriculaa\" value=\"\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td>matricula pr:</td>\n"
                    + "        				<td><input type=\"text\" name=\"matriculap\" value=\"\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td>idExamen:</td>\n"
                    + "        				<td><input type=\"text\" name=\"idexamen\" value=\"\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td colspan=\"2\" align=\"Center\"><input type=\"submit\" value=\"Add\"></td>\n"
                    + "        			</tr>\n"
                    + "        		</tbody>\n"
                    + "        	</table>\n"
                    + "        	</form>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>");
        } finally {
            out.close();
        }
    }

    public void createResponse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Calificaciones dto = new Calificaciones();
        String puntuaje = request.getParameter("puntuaje").trim();
        String matriculaa = request.getParameter("matriculaa").trim();
        String matriculap = request.getParameter("matriculap").trim();
        String idexamen = request.getParameter("idexamen").trim();
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
        response.sendRedirect("CalificacionesCRUD");
    }

    public void read(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String retorno = request.getParameter("retorno");

        CalificacionesDAO dao = new CalificacionesDAO();
        List list = null;
        try {
            list = dao.loadAll(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CalificacionesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calificaciones</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/stylesheet.css\"/>");
            out.println("<script type=\"text/javascript\" src=\"js/jquery-1.11.1.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/anim.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calificacioness registrados:</h1>");
            out.println("<table style=\"border: navy dashed\">"
                    + "<thead>"
                    + "<tr>"
                    + "<th>Id</th>"
                    + "<th>puntuaje</th>"
                    + "<th>Matricula Al</th>"
                    + "<th>Matricula Pr</th>"
                    + "<th>Id Examen</th>"
                    + "</tr>"
                    + "</thead>"
                    + "<tbody>");
            if (retorno != null) {
                out.print(retorno);
            }
            if (list != null) {
                for (Object object : list) {
                    out.println("<form ><input type=\"hidden\" name=\"idItem\"  value=" + ((Calificaciones) object).getIdcalificaciones() + ">");
                    out.println("<input type=\"hidden\" name=\"accion\"  value=\"read\" >");

                    out.print("<tr>"
                            + "<td><div >" + ((Calificaciones) object).getIdcalificaciones() + "</div></td>"
                            + "<td><div >" + ((Calificaciones) object).getPuntaje() + "</div></td>"
                            + "<td><div >" + ((Calificaciones) object).getMatriculaa() + "</div></td>"
                            + "<td><div >" + ((Calificaciones) object).getMatriculap() + "</div></td>"
                            + "<td><div >" + ((Calificaciones) object).getIdexamen() + "</div></td>"
                            + "<td>" + "<input type=\"submit\" value=\"editar\" formaction=\"CalificacionesCRUD\" formmethod=\"post\">" + "</td>"
                            + "<td>" + "<input type=\"submit\" value=\"eliminar\" formaction=\"CalificacionesCRUD\" formmethod=\"post\">" + "</td>"
                            + "</tr>");
                    out.print("</form>");
                }
            }

            out.println("</tbody>"
                    + "</table>");
            out.println("<br><form  >");
            out.println("<input type=\"hidden\" name=\"accion\"  value=\"createR\" >");
            out.println("<input type=\"submit\" value=\"Add\" formaction=\"CalificacionesCRUD\" formmethod=\"post\">");
            out.print("</form>");
            out.println("<a href=\"login.html\"><input type=\"submit\" value=\"return\"></a> ");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response, String key)
            throws ServletException, IOException {

        Calificaciones dto = new Calificaciones(), dto2 = null;
        dto.setIdcalificaciones(Integer.parseInt(key));

        CalificacionesDAO dao = new CalificacionesDAO();
        try {
            dto2 = dao.load(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CalificacionesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (dto2 == null) {
            response.sendRedirect("CalificacionesCRUD");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CalificacionesUpdate</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n"
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"CalificacionesCRUD\" method=\"POST\">\n<input type=\"hidden\" value=" + dto2.getIdcalificaciones() + " name=\"idCalificaciones\" >"
                    + "          <input type=\"hidden\" value=\"update\" name=\"accion\" >"
                    + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th colspan=\"2\" align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td>puntuaje: </td>\n"
                    + "        				<td><input type=\"text\" name=\"puntuaje\" value=" + dto2.getPuntaje() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "                                    <td><label>matriculaa</label></td>\n"
                    + "        				<td> <input type=\"text\" name= \"matriculaa\" value=" + dto2.getMatriculaa() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td>matriculap:</td>\n"
                    + "        				<td><input type=\"text\" name=\"matriculap\" value=" + dto2.getMatriculap() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td>idExamen:</td>\n"
                    + "        				<td><input type=\"text\" name=\"idexamen\" value=" + dto2.getIdexamen() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td colspan=\"2\" align=\"Center\"><input type=\"submit\" value=\"Update\"></td>\n"
                    + "        			</tr>\n"
                    + "        		</tbody>\n"
                    + "        	</table>\n"
                    + "        	</form>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>");
        } finally {
            out.close();
        }
    }

    public void updateResponse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Calificaciones dto = new Calificaciones();

        String puntuaje = request.getParameter("puntuaje").trim();
        String matriculaa = request.getParameter("matriculaa").trim();
        String matriculap = request.getParameter("matriculap").trim();
        String idexamen = request.getParameter("idexamen").trim();
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
            edao.update(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            // System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CalificacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(ex);
        }
        //System.out.println(user.toString());
        response.sendRedirect("CalificacionesCRUD");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response, String key)
            throws ServletException, IOException {
        Calificaciones exam = new Calificaciones(), exam2 = null;
        exam.setIdcalificaciones(Integer.parseInt(key));

        CalificacionesDAO examDAO = new CalificacionesDAO();
        try {
            examDAO.delete(exam, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CalificacionesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("CalificacionesCRUD");

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
