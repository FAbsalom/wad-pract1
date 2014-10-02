/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.CRUD;

import DAO.CarreraDAO;
import DTO.Carrera;
import Utilerias.Conexion;
import Utilerias.ConfiguraSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
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
public class CarreraCRUD extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            out.println("<title>CarreraUpdate</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n"
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"CarreraCRUD\" method=\"POST\">\n<input type=\"hidden\" value=\"\"" + " name=\"idCarrera\" >"
                    + "          <input type=\"hidden\" value=\"create\" name=\"accion\" >"
                    + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th colspan=\"2\" align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td>nombre: </td>\n"
                    + "        				<td><input type=\"text\" name=\"nombre\" value=\"\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "                                    <td><label>duracion:</label></td>\n"
                    + "        				<td> <input type=\"text\" name= \"duracion\" value=\"\"" + "></td>\n"
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
        Carrera dto = new Carrera();
        String duracion = request.getParameter("duracion").trim();
        String nombre = request.getParameter("nombre").trim();
/*
        if (fechaN.isEmpty() | materia.isEmpty() | periodo.isEmpty()) {
            response.sendRedirect("login.html");
        }
*/
        dto.setDuracion(Integer.parseInt(duracion));
        dto.setNombre(nombre);

        CarreraDAO edao = new CarreraDAO();
        //System.out.println(exam.toString());
        try {
            edao.create(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
            // System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(ex);
        }
        //System.out.println(user.toString());
        response.sendRedirect("CarreraCRUD");
    }

    public void read(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String retorno = request.getParameter("retorno");

        CarreraDAO udao = new CarreraDAO();
        List examList = null;
        try {
            examList = udao.loadAll(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CarreraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarreraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Carrera</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/stylesheet.css\"/>");
            out.println("<script type=\"text/javascript\" src=\"js/jquery-1.11.1.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/anim.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Carreras registrados:</h1>");
            out.println("<table style=\"border: navy dashed\">"
                    + "<thead>"
                    + "<tr>"
                    + "<th>Id</th>"
                    + "<th>Fecha</th>"
                    + "<th>Materia</th>"
                    + "</tr>"
                    + "</thead>"
                    + "<tbody>");
            if (retorno != null) {
                out.print(retorno);
            }
            if (examList != null) {
                for (Object object : examList) {
                    out.println("<form ><input type=\"hidden\" name=\"idItem\"  value=" + ((Carrera) object).getIdcarrera() + ">");
                    out.println("<input type=\"hidden\" name=\"accion\"  value=\"read\" >");

                    out.print("<tr>"
                            + "<td><div >" + ((Carrera) object).getIdcarrera() + "</div></td>"
                            + "<td><div >" + ((Carrera) object).getDuracion()+ "</div></td>"
                            + "<td><div >" + ((Carrera) object).getNombre()+ "</div></td>"
                            + "<td>" + "<input type=\"submit\" value=\"editar\" formaction=\"CarreraCRUD\" formmethod=\"post\">" + "</td>"
                            + "<td>" + "<input type=\"submit\" value=\"eliminar\" formaction=\"CarreraCRUD\" formmethod=\"post\">" + "</td>"
                            + "</tr>");
                    out.print("</form>");
                }
            }

            out.println("</tbody>"
                    + "</table>");
            out.println("<br><form  >");
            out.println("<input type=\"hidden\" name=\"accion\"  value=\"createR\" >");
            out.println("<input type=\"submit\" value=\"Add\" formaction=\"CarreraCRUD\" formmethod=\"post\">");
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

        Carrera dto = new Carrera(), dto2 = null;
        dto.setIdcarrera(Integer.parseInt(key));

        CarreraDAO dao = new CarreraDAO();
        try {
            dto2 = dao.load(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CarreraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarreraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (dto2 == null) {
            response.sendRedirect("CarreraCRUD");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CarreraUpdate</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n" 
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"CarreraCRUD\" method=\"POST\">\n<input type=\"hidden\" value=" + dto2.getIdcarrera() + " name=\"idCarrera\" >"
                    + "          <input type=\"hidden\" value=\"update\" name=\"accion\" >"
                    + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th colspan=\"2\" align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td>id: </td>\n"
                    + "        				<td><input disable type=\"text\" name=\"id\" value=" + dto2.getIdcarrera() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "                                    <td><label>nombre</label></td>\n"
                    + "        				<td> <input type=\"text\" name= \"nombre\" value=" + dto2.getNombre()+ "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td>duracion:</td>\n"
                    + "        				<td><input type=\"text\" name=\"duracion\" value=" + dto2.getDuracion()+ "></td>\n"
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
        Carrera dto = new Carrera();


        String duracion = request.getParameter("duracion").trim();
        String nombre = request.getParameter("nombre").trim();
/*
        if (fechaN.isEmpty() | materia.isEmpty() | periodo.isEmpty()) {
            response.sendRedirect("login.html");
        }
*/
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
        response.sendRedirect("CarreraCRUD");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response, String key)
            throws ServletException, IOException {
        Carrera exam = new Carrera(), exam2 = null;
        exam.setIdcarrera(Integer.parseInt(key));

        CarreraDAO examDAO = new CarreraDAO();
        try {
            examDAO.delete(exam, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CarreraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarreraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("CarreraCRUD");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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