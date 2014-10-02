/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pwned
 */
public class VentanaModal extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!-- @ Crear ventanas modales usando solo css y su selector target\n"
                    + "     @ author Agustín Baraza (contacto@nosolocss.com)\n"
                    + "     @ Copyright 2014 nosolocss.com. All rights reserved\n"
                    + "     @ http://www.gnu.org/licenses/gpl-2.0.html GNU/GPL\n"
                    + "     @ link http://www.nosolocss.com -->\n"
                    + "\n"
                    + "<!DOCTYPE HTML>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
                    + "<meta name=\"keywords\" content=\"ventana modal, css, css3, modal\" />\n"
                    + "<meta name=\"description\" content=\"Ejemplo que muestra ventanas modales animadas solo con css y su selector target. No solo CSS\" lang=\"ES\" />\n"
                    + "<link href='http://fonts.googleapis.com/css?family=Black+Ops+One' rel='stylesheet' type='text/css'>\n"
                    + "<title>Crear ventanas modales usando solo css y su selector target</title>\n"
                    + "<style type=\"text/css\">\n"
                    + "\n"
                    + "body{font-family: Arial,sans-serif;color:#333;}\n"
                    + ".center{\n"
                    + "	position:absolute;\n"
                    + "	width:700px;\n"
                    + "	height:600px;\n"
                    + "	top:50%;\n"
                    + "	left:50%;\n"
                    + "	margin-left:-350px;\n"
                    + "	margin-top:-250px;	\n"
                    + "\n"
                    + "}\n"
                    + "h1{\n"
                    + "	font-size:20px;\n"
                    + "}\n"
                    + ".modalmask {\n"
                    + "	position: fixed;\n"
                    + "	font-family: Arial, sans-serif;\n"
                    + "	top: 0;\n"
                    + "	right: 0;\n"
                    + "	bottom: 0;\n"
                    + "	left: 0;\n"
                    + "	background: rgba(0,0,0,0.8);\n"
                    + "	z-index: 99999;\n"
                    + "	opacity:0;\n"
                    + "	-webkit-transition: opacity 400ms ease-in;\n"
                    + "	-moz-transition: opacity 400ms ease-in;\n"
                    + "	transition: opacity 400ms ease-in;\n"
                    + "	pointer-events: none;\n"
                    + "}\n"
                    + ".modalmask:target {\n"
                    + "	opacity:1;\n"
                    + "	pointer-events: auto;\n"
                    + "}\n"
                    + ".modalbox{\n"
                    + "	width: 400px;\n"
                    + "	position: relative;\n"
                    + "	padding: 5px 20px 13px 20px;\n"
                    + "	background: #fff;\n"
                    + "	border-radius:3px;\n"
                    + "	-webkit-transition: all 500ms ease-in;\n"
                    + "	-moz-transition: all 500ms ease-in;\n"
                    + "	transition: all 500ms ease-in;\n"
                    + "	\n"
                    + "}\n"
                    + "\n"
                    + ".movedown {\n"
                    + "	margin: 0 auto;\n"
                    + "}\n"
                    + ".rotate {\n"
                    + "	margin: 10% auto;\n"
                    + "	-webkit-transform: scale(-5,-5); \n"
                    + "	transform: scale(-5,-5);\n"
                    + "}\n"
                    + ".resize {\n"
                    + "	margin: 10% auto;\n"
                    + "	width:0;\n"
                    + "	height:0;\n"
                    + "\n"
                    + "}\n"
                    + ".modalmask:target .movedown{		\n"
                    + "	margin:10% auto;\n"
                    + "}\n"
                    + ".modalmask:target .rotate{		\n"
                    + "	transform: rotate(360deg) scale(1,1);\n"
                    + "    -webkit-transform: rotate(360deg) scale(1,1);\n"
                    + "}\n"
                    + "\n"
                    + ".modalmask:target .resize{\n"
                    + "	width:400px;\n"
                    + "	height:200px;\n"
                    + "}\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + ".close {\n"
                    + "	background: #606061;\n"
                    + "	color: #FFFFFF;\n"
                    + "	line-height: 25px;\n"
                    + "	position: absolute;\n"
                    + "	right: 1px;\n"
                    + "	text-align: center;\n"
                    + "	top: 1px;\n"
                    + "	width: 24px;\n"
                    + "	text-decoration: none;\n"
                    + "	font-weight: bold;\n"
                    + "	border-radius:3px;\n"
                    + "	font-size:16px;\n"
                    + "}\n"
                    + "\n"
                    + ".close:hover { \n"
                    + "	background: #FAAC58; \n"
                    + "	color:#222;\n"
                    + "}\n"
                    + "\n"
                    + "ul{\n"
                    + "	width:500px;\n"
                    + "	margin:20% auto;\n"
                    + "	list-style:none;\n"
                    + "}\n"
                    + "ul li{\n"
                    + "\n"
                    + "	float:left;\n"
                    + "	margin-right:35px;\n"
                    + "\n"
                    + "}\n"
                    + "ul li a{\n"
                    + "	font-family: Arial, sans-serif;\n"
                    + "	font-size:16px;\n"
                    + "	text-decoration:none;\n"
                    + "	background:#222;\n"
                    + "	padding:20px;\n"
                    + "	color:#fff;\n"
                    + "	font-weight:bold;\n"
                    + "	border-radius:3px;\n"
                    + "	-webkit-transition: all 200ms ease-in;\n"
                    + "	-moz-transition: all 200ms ease-in;\n"
                    + "	transition: all 200ms ease-in;\n"
                    + "}\n"
                    + "ul li a:hover{\n"
                    + "	background:#FAAC58;\n"
                    + "	color:#222;\n"
                    + "\n"
                    + "}\n"
                    + "\n"
                    + "a{\n"
                    + "	text-decoration:none;\n"
                    + "	font-family: 'Black Ops One', cursive;\n"
                    + "	font-size:25px;\n"
                    + "	color:#222;\n"
                    + "\n"
                    + "}\n"
                    + "a:hover{\n"
                    + "\n"
                    + "	color:#DF7401;\n"
                    + "	\n"
                    + "}\n"
                    + ".nsc{\n"
                    + "	position:absolute;\n"
                    + "	bottom:40%;\n"
                    + "	right:0;\n"
                    + "}\n"
                    + "</style>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "\n"
                    + "<div class=\"center\">\n"
                    + "	 \n"
                    + "	 \n"
                    + "		\n"
                    + "	<h1 align=\"center\"><p style=\"background:#222;color:#fff;padding:4px;\">Pulsa los botones para ver las ventanas modales</p></h1>\n"
                    + "	<ul>\n"
                    + "		<li><a href=\"#modal1\">DESLIZAR</a></li>\n"
                    + "		<li><a href=\"#modal2\">ROTAR</a></li>\n"
                    + "		<li><a href=\"#modal3\">REDIMENSIONAR</a></li>\n"
                    + "	</ul>\n"
                    + "	<div id=\"modal1\" class=\"modalmask\">\n"
                    + "		<div class=\"modalbox movedown\">\n"
                    + "			<a href=\"#close\" title=\"Close\" class=\"close\">X</a>\n"
                    + "			<h2>DESLIZAR</h2>\n"
                    + "			<p>La ventana modal aparece por arriba y se desliza hasta su posición. Un efecto simple pero elegante.</p>\n"
                    + "			<p>Aquí puedes incluir cualquier cosa como vídeos, mapas, formularios...</p>\n"
                    + "\n"
                    + "		</div>\n"
                    + "	</div>\n"
                    + "	<div id=\"modal2\" class=\"modalmask\">\n"
                    + "		<div class=\"modalbox rotate\">\n"
                    + "			<a href=\"#close\" title=\"Close\" class=\"close\">X</a>\n"
                    + "			<h2>ROTAR</h2>\n"
                    + "			<p>Usando la propiedad transform de CSS3, podemos hacer que las ventanas aparezcan rotando.</p>\n"
                    + "			<p>No hay nada de Javascript, solo unas pocas lineas de CSS.</p>\n"
                    + "		</div>\n"
                    + "	</div>\n"
                    + "		<div id=\"modal3\" class=\"modalmask\">\n"
                    + "		<div class=\"modalbox resize\">\n"
                    + "			<a href=\"#close\" title=\"Close\" class=\"close\">X</a>\n"
                    + "			<h2>REDIMENSIONAR</h2>\n"
                    + "			<p>También puedes redimensionar la ventana hasta hacerla desaparecer.</p>\n"
                    + "			<p>Las posibilidades que ofrece CSS3 son múltiples, tan solo hace falta un poco de imaginación para crear efectos realmente llamativos.</p>\n"
                    + "		</div>\n"
                    + "	</div>\n"
                    + "		\n"
                    + "	<div class=\"nsc\"><a href=\"http://www.nosolocss.com/blog/css/crear-ventanas-modales-usando-solo-css-y-su-selector-target\">NOSOLOCSS</a></div>	\n"
                    + "</div>\n"
                    + "\n"
                    + "</body>\n"
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
