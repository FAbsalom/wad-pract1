/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import DTO.GraficaDTO;
import Utilerias.Conexion;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Pwned
 */
public class GraficaAlumnosAprobadosx extends HttpServlet {

    Conexion conn = new Conexion();
    private static final String sql_Grafica = "{call AlumnosAprobadosxMateria()}";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreGrafica = "Alumnos Aprobados Por Materia";
        JFreeChart chart = ChartFactory.createPieChart3D(nombreGrafica,
                getGrafica(), true, true, Locale.getDefault());
        PiePlot3D pieplot3d = (PiePlot3D) chart.getPlot();
        pieplot3d.setDepthFactor(0.5);
        pieplot3d.setStartAngle(290D);
        pieplot3d.setDirection(Rotation.CLOCKWISE);
        pieplot3d.setForegroundAlpha(0.5F);
        String nombreArchivo = "AlumnosAprobadosxMateria.jpeg";
        String arc = getServletConfig().getServletContext().getRealPath("/" + nombreArchivo);
        ChartUtilities.saveChartAsJPEG(new File(arc), chart, 700, 400);
        VistaGraficaServlet graficaServlet = new VistaGraficaServlet();
        graficaServlet.processRequest(request, response, nombreArchivo, nombreGrafica);
        response.sendRedirect("VistaGraficaServlet");
    }

    private PieDataset getGrafica() {
        DefaultPieDataset pie = new DefaultPieDataset();
        try {
            List datos = grafica(conn.ObtenerConexion());
            for (int indice = 0; indice < datos.size(); indice++) {
                GraficaDTO dto = (GraficaDTO) datos.get(indice);
                pie.setValue(dto.getNombre(), dto.getCantidad());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pie;
    }

    public List grafica(Connection conn) throws SQLException, ClassNotFoundException {
        CallableStatement cs = null;
        ResultSet rs = null;
        List lista = new ArrayList();
        try {
            cs = (CallableStatement) conn.prepareCall(sql_Grafica);
            rs = cs.executeQuery();
            while (rs.next()) {
                GraficaDTO grafica = new GraficaDTO();
                grafica.setCantidad(Integer.parseInt(rs.getString("num_alumnos")));
                grafica.setNombre(rs.getString("nombre"));
                lista.add(grafica);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return lista;
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