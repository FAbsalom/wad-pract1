package controller.servlets;

import Utilerias.ConfiguraSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author absalom
 */
public class ServletProfesor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConfiguraSession se = new ConfiguraSession();
        if (!se.isSession(request)) {
            response.sendRedirect("Login.html");
        }
        if (!se.isType(request).equalsIgnoreCase("profesor")) {
            response.sendRedirect("ErrorServletl");
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
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
                    + "        <div class = \"navbar navbar-inverse navbar-static-top\">"
                    + "            <div class = \"container\">                               "
                    + "                <a href = \"Imagenes.html\" target=\"Frame_Contenido\" class = \"navbar-brand\">WEB APPILCATION </a>                               "
                    + "                <button class = \"navbar-toggle\" data-toggle = \"collapse\" data-target = \".navHeaderCollapse\">"
                    + "                    <span class = \"icon-bar\"></span>"
                    + "                    <span class = \"icon-bar\"></span>"
                    + "                    <span class = \"icon-bar\"></span>"
                    + "                </button>                               "
                    + "                <div class = \"collapse navbar-collapse navHeaderCollapse\">                               "
                    + "                    <ul class = \"nav navbar-nav navbar-right\">                                       "
                    + "                        <li class = \"active\" ><a href = \"Imagenes.html\"  target=\"Frame_Contenido\" >INICIO</a></li>                        "
                    + "                        <li class = \"dropdown\">                                                       "
                    + "                            <a href = \"\" class = \"dropdown-toggle\" data-toggle = \"dropdown\">MATERIAS <b class = \"caret\"></b></a>"
                    + "                            <ul class = \"dropdown-menu\">"
                    + "                                <li><a href = \"MostrarMateria\" target=\"Frame_Contenido\"  >VER MATERIAS</a></li>"
                    + "                                <li><a href = \"MateriaAgregarVista\"    target=\"Frame_Contenido\"  >AGREGAR MATERIAS</a></li>"
                    + "                            </ul>                                               "
                    + "                        </li>"
                    + "                        <li class = \"dropdown\">                                                       "
                    + "                            <a href = \"\" class = \"dropdown-toggle\" data-toggle = \"dropdown\">PREGUNTA <b class = \"caret\"></b></a>"
                    + "                            <ul class = \"dropdown-menu\">"
                    + "                                <li><a href = \"PreguntaMostrar\" target=\"Frame_Contenido\" >VER PREGUNTAS</a></li>"
                    + "                                <li><a href = \"PreguntaCrearVista\" target=\"Frame_Contenido\" >AGREGAR PREGUNTAS</a></li>"
                    + "                            </ul>                                               "
                    + "                        </li>"
                    + ""
                    + "                        <li class = \"dropdown\">                                                       "
                    + "                            <a href = \"\" class = \"dropdown-toggle\" data-toggle = \"dropdown\">RESPUESTAS <b class = \"caret\"></b></a>"
                    + "                            <ul class = \"dropdown-menu\">"
                    + "                                <li><a href = \"RespuestaMostrar\" target=\"Frame_Contenido\" >VER RESPUESTAS</a></li>"
                    + "                                <li><a href = \"RespuestaCrearVista\"    target=\"Frame_Contenido\"  >AGREGAR RESPUESTAS</a></li>"
                    + "                            </ul>                                               "
                    + "                        </li>"
                    + "                        <li class = \"dropdown\">                                                       "
                    + "                            <a href = \"\" class = \"dropdown-toggle\" data-toggle = \"dropdown\">EXAMEN <b class = \"caret\"></b></a>"
                    + "                            <ul class = \"dropdown-menu\">"
                    + "                                <li><a href = \"ExamenMostrar\"  target=\"Frame_Contenido\"  >VER EXAMEN</a></li>"
                    + "                                <li><a href = \"ExamenAgregarVista\"  target=\"Frame_Contenido\" >AGREGAR EXAMEN</a></li>"
                    + "                            </ul>                                               "
                    + "                        </li>"
                    + "                        <li class = \"dropdown\">                                                       "
                    + "                            <a href = \"\" class = \"dropdown-toggle\" data-toggle = \"dropdown\">PROFESOR <b class = \"caret\"></b></a>"
                    + "                            <ul class = \"dropdown-menu\">"
                    + "                                <li><a href = \"ProfesorMostrar\"  target=\"Frame_Contenido\"    >Mostrar MIS DATOS</a></li>"
                    + "                                <li><a href = \"ProfesorAgregarVista\"  target=\"Frame_Contenido\" >AGREGAR A UN NUEVO PROFESOR</a></li>"
                    + "                            </ul>                                               "
                    + "                        </li>"
                    + ""
                    + "                             <li class = \"dropdown\">                                                       "
                    + "                            <a href = \"CarreraCRUD\" class = \"dropdown-toggle\" data-toggle = \"dropdown\">CARRERA <b class = \"caret\"></b></a>                            "
                    + "                            <ul class = \"dropdown-menu\">"
                    + "                                <li><a href = \"CarreraMostrar\" target=\"Frame_Contenido\"  >Mostrar Carreras</a></li>"
                    + "                            </ul>                                               "
                    + "                        </li>"
                    + "                        <li class = \"dropdown\">                                                       "
                    + "                            <a href = \"AlumnoCRUD\" class = \"dropdown-toggle\" data-toggle = \"dropdown\">ALUMNO <b class = \"caret\"></b></a>                            "
                    + "                            <ul class = \"dropdown-menu\">"
                    + "                                <li><a href = \"AlumnoMostrar \"  target=\"Frame_Contenido\">Mostrar Alumnos</a></li>"
                    + "                            </ul>                                               "
                    + "                        </li>"
                    + "                        <li class = \"dropdown\">                                                       "
                    + "                            <a href = \"CalificacionesCRUD\" class = \"dropdown-toggle\" data-toggle = \"dropdown\">CALIFICACIONES <b class = \"caret\"></b></a>                            "
                    + "                            <ul class = \"dropdown-menu\">"
                    + "                                <li><a href = \"CalificacionesMostrar\"  target=\"Frame_Contenido\">Mostrar Calificaciones</a></li>"
                    + "                                <li><a href = \"CalificacionesAgregarVista\"  target=\"Frame_Contenido\">Agregar Calificaciones</a></li>"
                    + "                            </ul>  "
                    + "                        </li>"
                    + "                        <li class = \"dropdown\">                                                       "
                    + "                            <a href = \"\" class = \"dropdown-toggle\" data-toggle = \"dropdown\">REPORTES<b class = \"caret\"></b></a>"
                    + "                            <ul class = \"dropdown-menu\">"
                    + "                                <li><a href = \"ReporteAlumnosxCarrera?tipo=PDF\">ALUMNOS POR CARRERA (.PDF) </a></li>                            "
                    + "                                <li><a href = \"ReporteAlumnosxCarrera?tipo=XLS\">ALUMNOS POR CARRERA (.XLS) </a></li>                            "
                    + "                                <li><a href = \"ReporteAlumnosxCarrera?tipo=DOCX\">ALUMNOS POR CARRERA (.DOCX) </a></li>                            "
                    + "                                        <li><a href = \"GraficaAlumnosxMateria\" target=\"Frame_Contenido\">ALUMNOS POR MATERIA</a></li>"
                    + "                                        <li><a href = \"GraficaAlumnosXCarrera\" target=\"Frame_Contenido\">ALUMNOS POR CARRERA (Grafico)  </a></li>                                "
                    
                    + "                                        <li><a href = \"GraficaAlumnosReprobados\"  target=\"Frame_Contenido\" >ALUMNOS REPROBADOS POR MATERIA</a></li>"
                    + "                                        <li><a href = \"GraficaAlumnosAprobadosx\"  target=\"Frame_Contenido\" >ALUMNOS APROBADOS POR MATERIA </a></li>"
                    + "                        </li>"
                    + ""
                    + ""
                    + "                    </ul>                               "
                    + ""
                    + "                </div>                               "
                    + "            </div>"
                    + "        </div> "
                    + "        <script src = \"./js/jquery.min.js\"></script>"
                    + "        <script src = \"./js/bootstrap.js\"></script>"
                    + "<p align=\"left\"><img src=\"./Imagenes/logo ipn.png\" class=\"imgchica  \"    > </p> "
                    + "<p align=\"right\"><img src=\"./Imagenes/logoescomconletras.png\"     class=\"imgchica imgder   \" > </p>"
                    + "<div id=\"contenido\">"
                    + "		"
                    + "			"
                    + "<iframe  name=\"Frame_Contenido\" class=\"FrameContenido\"  scrolling=\"auto\" frameborder=\"si\" align=\"center\" width=\"100%\" height=\"100%\""
                    + " src=\"Imagenes.html\" >"
                    + "		No encuntro el contenido    margin</iframe>"
                    + "			"
                    + "			"
                    + "		"
                    + "			"
                    + "</div>"
                    + ""
                    + "");

            out.println("</body>"
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
