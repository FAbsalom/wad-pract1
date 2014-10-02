/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import DTO.GraficaDTO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Pwned
 */
public class GraficaServlet extends HttpServlet {

      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GraficaAlumnosMateria(request, response);
        response.sendRedirect("GraficaAlumnoxCarreraServlet");

    }

    private void GraficaAlumnosMateria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JFreeChart chart = ChartFactory.createPieChart3D("Alumnos Por Carrera",
                getGraficaAlumnos(), true, true, Locale.getDefault());
        String arc = getServletConfig().getServletContext().getRealPath("/AlumnosxCarrera.jpeg");
        ChartUtilities.saveChartAsJPEG(new File(arc), chart, 700, 400);


    }

    private DefaultPieDataset getGraficaAlumnos() {
        DefaultPieDataset pie = new DefaultPieDataset();
        UsuriosDelegate del = new UsuriosDelegate();
        try {
            List datos = del.grafica();
            for (int indice = 0; indice < datos.size(); indice++) {
                GraficaDTO dto = (GraficaDTO) datos.get(indice);
                pie.setValue(dto.getNombre(), dto.getCantidad());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pie;
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
