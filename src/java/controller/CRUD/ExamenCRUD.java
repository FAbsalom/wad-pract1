/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.CRUD;

import DAO.ExamenDAO;
import DTO.Examen;
import Utilerias.Conexion;
import Utilerias.ConfiguraSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;


/**
 *
 * @author absalom
 */
public class ExamenCRUD extends HttpServlet {

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
        //create(request,response);
         ConfiguraSession se = new ConfiguraSession();
        if (!se.isSession(request)) {
            response.sendRedirect("Login.html");
        }
        if(!se.isType(request).equalsIgnoreCase("profesor")){
            response.sendRedirect("ErrorServletl");
        }
        
        
        String accion = request.getParameter("accion");
        
        //update(request, response, "45");
                
        if (accion == null ) {
            read(request,response);
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
        
        if(accion.equalsIgnoreCase("createR")){
            create(request,response);
            return;
        }
        
        if(accion.equalsIgnoreCase("create")){
            createResponse(request,response);
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
            out.println("<title>ExamenUpdate</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n"
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"ExamenCRUD\" method=\"POST\">\n<input type=\"hidden\" value=\"\"" + " name=\"idExamen\" >"
                    + "          <input type=\"hidden\" value=\"create\" name=\"accion\" >"
                    + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th colspan=\"2\" align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td>fecha: </td>\n"
                    + "        				<td><input type=\"text\" name=\"fecha\" value=\"\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "                                    <td><label>materia:</label></td>\n"
                    + "        				<td> <input type=\"text\" name= \"materia\" value=\"\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td>periodo:</td>\n"
                    + "        				<td><input type=\"text\" name=\"periodo\" value=\"\"" + "></td>\n"
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
        Examen exam = new Examen();
        String  fechaN = request.getParameter("fecha").trim();
        Date date=new Date(request.getParameter("fecha").trim());
        String materia = request.getParameter("materia").trim();
        String periodo = request.getParameter("periodo").trim();

        if (fechaN.isEmpty() | materia.isEmpty() | periodo.isEmpty()) {
            response.sendRedirect("login.html");
        }
        
        exam.setFecha(date);
        exam.setIdmateria(Integer.parseInt(materia));
        exam.setPeriodo(Integer.parseInt(periodo));

        ExamenDAO edao = new ExamenDAO();
        //System.out.println(exam.toString());
        try {
            edao.create(exam, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(ExamenDAO.class.getName()).log(Level.SEVERE, null, ex);
            // System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenDAO.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(ex);
        }
        //System.out.println(user.toString());
        response.sendRedirect("ExamenCRUD");
    }

    public void read(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String retorno = request.getParameter("retorno");

        ExamenDAO udao = new ExamenDAO();
        List examList = null;
        try {
            examList = udao.loadALL(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Examen</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/stylesheet.css\"/>");
            out.println("<script type=\"text/javascript\" src=\"js/jquery-1.11.1.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/anim.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Examens registrados:</h1>");
            out.println("<table style=\"border: navy dashed\">"
                    + "<thead>"
                    + "<tr>"
                    + "<th>Id</th>"
                    + "<th>Fecha</th>"
                    + "<th>Materia</th>"
                    + "<th>Periodo</th>"
                    + "</tr>"
                    + "</thead>"
                    + "<tbody>");
            if (retorno != null) {
                out.print(retorno);
            }
            if (examList != null) {
                for (Object object : examList) {
                    out.println("<form ><input type=\"hidden\" name=\"idItem\"  value=" + ((Examen) object).getIdexamen() + ">");
                    out.println("<input type=\"hidden\" name=\"accion\"  value=\"read\" >");

                    out.print("<tr>"
                            + "<td><div >" + ((Examen) object).getIdexamen() + "</div></td>"
                            + "<td><div >" + ((Examen) object).getFecha() + "</div></td>"
                            + "<td><div >" + ((Examen) object).getIdmateria() + "</div></td>"
                            + "<td><div >" + ((Examen) object).getPeriodo() + "</div></td>"
                            + "<td>" + "<input type=\"submit\" value=\"editar\" formaction=\"ExamenCRUD\" formmethod=\"post\">" + "</td>"
                            + "<td>" + "<input type=\"submit\" value=\"eliminar\" formaction=\"ExamenCRUD\" formmethod=\"post\">" + "</td>"
                            + "</tr>");
                    out.print("</form>");
                }
            }

            out.println("</tbody>"
                    + "</table>");
            out.println("<br><form  >");
            out.println("<input type=\"hidden\" name=\"accion\"  value=\"createR\" >");
            out.println("<input type=\"submit\" value=\"Add\" formaction=\"ExamenCRUD\" formmethod=\"post\">");
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

        Examen exam = new Examen(), exam2 = null;
        exam.setIdexamen(Integer.parseInt(key));

        ExamenDAO examDAO = new ExamenDAO();
        try {
            exam2 = examDAO.load(exam, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (exam2 == null) {
            response.sendRedirect("ExamenCRUD");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ExamenUpdate</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n" + exam2.getIdexamen()
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"ExamenCRUD\" method=\"POST\">\n<input type=\"hidden\" value=" + exam2.getIdexamen() + " name=\"idExamen\" >"
                    + "          <input type=\"hidden\" value=\"update\" name=\"accion\" >"
                    + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th colspan=\"2\" align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td>fecha: </td>\n"
                    + "        				<td><input type=\"text\" name=\"fecha\" value=" + exam2.getFecha() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "                                    <td><label>materia</label></td>\n"
                    + "        				<td> <input type=\"text\" name= \"materi\" value=" + exam2.getIdmateria() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td>periodo:</td>\n"
                    + "        				<td><input type=\"text\" name=\"periodo\" value=" + exam2.getPeriodo() + "></td>\n"
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
        Examen exam = new Examen();
        
        
        
          Date fecha  =  new Date(request.getParameter("fecha").trim());
        
        String materia = request.getParameter("materia").trim();
        String periodo = request.getParameter("periodo").trim();

        if ((fecha == null) | materia.isEmpty() | periodo.isEmpty()) {
            response.sendRedirect("login.html");
        }

        exam.setFecha(fecha);
        exam.setIdmateria(Integer.parseInt(materia));
        exam.setPeriodo(Integer.parseInt(periodo));

        ExamenDAO edao = new ExamenDAO();
        //System.out.println(exam.toString());
        try {
            edao.update(exam, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(ExamenDAO.class.getName()).log(Level.SEVERE, null, ex);
            // System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenDAO.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(ex);
        }
        //System.out.println(user.toString());
        response.sendRedirect("ExamenCRUD");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response, String key)
            throws ServletException, IOException {
        Examen exam = new Examen(), exam2 = null;
        exam.setIdexamen(Integer.parseInt(key));

        ExamenDAO examDAO = new ExamenDAO();
        try {
            examDAO.delete(exam, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            response.sendRedirect("ExamenCRUD");
        
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
