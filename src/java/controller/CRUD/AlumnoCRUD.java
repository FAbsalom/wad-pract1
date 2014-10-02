/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.CRUD;

import DAO.AlumnoDAO;
import DTO.Alumno;
import Utilerias.CargaSelect;
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
public class AlumnoCRUD extends HttpServlet {

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
            out.println("<title>AlumnoUpdate</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n"
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"AlumnoCRUD\" method=\"POST\">\n<input type=\"hidden\" value=\"\"" + " name=\"idAlumno\" >"
                    + "          <input type=\"hidden\" value=\"create\" name=\"accion\" >"
                    + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th  align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"matricula\" value=\"\" placeholder=\"Matricula\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"nombre\" value=\"\" placeholder=\"Nombre\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"paterno\" value=\"\" placeholder=\"Paterno\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"materno\" value=\"\" placeholder=\"Materno\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"fecha\" value=\"\" placeholder=\"Fecha\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"calle\" value=\"\" placeholder=\"Calle\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"colonia\" value=\"\" placeholder=\"Colonia\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"numero\" value=\"\" placeholder=\"Numero\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"cp\" value=\"\" placeholder=\"C.P.\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"sexo\" value=\"\" placeholder=\"Sexo\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"email\" value=\"\" placeholder=\"E-mail\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"hidden\" name= \"clave\" value=\"-\" placeholder=\"clave\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    //+ "        				<td><input type=\"text\" name=\"idcarrera\" value=\"\" placeholder=\"Carrera\"" + "></td>\n"
                    + CargaSelect.conCarrera()
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td align=\"Center\"><input type=\"submit\" value=\"Add\"></td>\n"
                    + "        			</tr>\n"
                    + "        		</tbody>\n"
                    + "        	</table>\n"
                    + "        	</form>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>");
        }finally {
            out.close();
        }
    }

    public void createResponse(HttpServletRequest request, HttpServletResponse response)
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
        dto.setFechan(new Date(fechaN));
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
        response.sendRedirect("AlumnoCRUD");
    }

    public void read(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String retorno = request.getParameter("retorno");

        AlumnoDAO dao = new AlumnoDAO();
        List listItems = null;
        try {
            listItems = dao.loadALL(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alumno</title>");
            
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/stylesheet.css\"/>");
            out.println("<script type=\"text/javascript\" src=\"js/jquery-1.11.1.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/anim.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Alumnos registrados:</h1>");
            out.println("<table style=\"border: navy dashed\">"
                    + "<thead>"
                    + "<tr>"
                    + "<th>Matricula</th>"
                    + "<th>Nombre</th>"
                    + "<th>Paterno</th>"
                    + "<th>Materno</th>"
                    + "<th>Fecha</th>"
                    + "<th>Calle</th>"
                    + "<th>Colonia</th>"
                    + "<th>Numero</th>"
                    + "<th>C.P.</th>"
                    + "<th>Sexo</th>"
                    + "<th>E-mail</th>"
                    + "<th>idCarrera</th>"
                    + "</tr>"
                    + "</thead>"
                    + "<tbody>");
            if (retorno != null) {
                out.print(retorno);
            }
            if (listItems != null) {
                for (Object object : listItems) {
                    out.println("<form ><input type=\"hidden\" name=\"idItem\"  value=" + ((Alumno) object).getMatriculaa() + ">");
                    out.println("<input type=\"hidden\" name=\"accion\"  value=\"read\" >");

                    out.print("<tr>"
                            + "<td><div >" + ((Alumno) object).getMatriculaa() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getNombre() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getPaterno() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getMaterno() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getFechan() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getCalle() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getColonia() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getNum() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getCp() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getSexo() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getEmail() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getIdcarrera() + "</div></td>"
                            + "<td>" + "<input type=\"submit\" value=\"editar\" formaction=\"AlumnoCRUD\" formmethod=\"post\">" + "</td>"
                            + "<td>" + "<input type=\"submit\" value=\"eliminar\" formaction=\"AlumnoCRUD\" formmethod=\"post\">" + "</td>"
                            + "</tr>");
                    out.print("</form>");
                }
            }

            out.println("</tbody>"
                    + "</table>");
            out.println("<br><form  >");
            out.println("<input type=\"hidden\" name=\"accion\"  value=\"createR\" >");
            out.println("<input type=\"submit\" value=\"Add\" formaction=\"AlumnoCRUD\" formmethod=\"post\">");
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
            response.sendRedirect("AlumnoCRUD");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>AlumnoUpdate</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/stylesheet.css\"/>");
            out.println("<script type=\"text/javascript\" src=\"js/jquery-1.11.1.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/anim.js\"></script>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n"
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"AlumnoCRUD\" method=\"POST\">\n<input type=\"hidden\" value=" + dto2.getMatriculaa() + " name=\"idAlumno\" >"
                    + "          <input type=\"hidden\" value=\"update\" name=\"accion\" >" + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th  align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td><input disable type=\"text\" name=\"matricula\" value=\"" + dto2.getMatriculaa() + "\" placeholder=\"Matricula\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"nombre\" value=\"" + dto2.getNombre() + "\" placeholder=\"Nombre\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"paterno\" value=\"" + dto2.getPaterno() + "\" placeholder=\"Paterno\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"materno\" value=\"" + dto2.getMaterno() + "\" placeholder=\"Materno\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"fecha\" value=\"" + dto2.getFechan().toString() + "\" placeholder=\"Fecha\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"calle\" value=\"" + dto2.getCalle() + "\" placeholder=\"Calle\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"colonia\" value=\"" + dto2.getColonia() + "\" placeholder=\"Colonia\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"numero\" value=\"" + dto2.getNum() + "\" placeholder=\"Numero\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"cp\" value=\"" + dto2.getCp() + "\" placeholder=\"C.P.\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"sexo\" value=\"" + dto.getSexo() + "\" placeholder=\"Sexo\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"email\" value=\"" + dto2.getEmail() + "\" placeholder=\"E-mail\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"hidden\" name= \"clave\" value=\"-\" placeholder=\"clave\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"idcarrera\" value=\"" + dto2.getIdcarrera() + "\" placeholder=\"Carrera\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td align=\"Center\"><input type=\"submit\" value=\"Add\"></td>\n"
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
        Alumno dto = new Alumno();
        String matricula, nombre, paterno, materno, fechaN, calle, colonia, num, cp, sexo, email = "", idcarrera;
        matricula = request.getParameter("idAlumno");
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
        idcarrera = request.getParameter("idcarrera");
        Date date=null;
            
         date=new Date(fechaN);
        /*
         if ((fecha == null) | materia.isEmpty() | periodo.isEmpty()) {
         response.sendRedirect("login.html");
         }
         */
        dto.setMatriculaa(Integer.parseInt(matricula));
        dto.setNombre(nombre);
        dto.setPaterno(paterno);
        dto.setMaterno(materno);
        dto.setFechan(date);
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
            dao.update(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            // System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(ex);
        }
        //System.out.println(user.toString());
        response.sendRedirect("AlumnoCRUD");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response, String key)
            throws ServletException, IOException {
        Alumno dto = new Alumno(), exam2 = null;
        dto.setMatriculaa(Integer.parseInt(key));

        AlumnoDAO examDAO = new AlumnoDAO();
        try {
            examDAO.delete(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("AlumnoCRUD");

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
