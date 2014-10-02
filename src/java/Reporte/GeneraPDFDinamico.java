package Reporte;

import DTO.Alumno;
import DTO.Profesor;
import Utilerias.Conexion;
import Utilerias.ConfiguraSession;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class GeneraPDFDinamico extends HttpServlet {

    Conexion conn = new Conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Alumno alumno, String titulo)
            throws ServletException, IOException {
    }

    public void AlumnoxCarreraPDF(HttpServletResponse response, HttpServletRequest request, String tipo) {
        try {
            String se = "";
            ConfiguraSession s1 = new ConfiguraSession();
            if (s1.isSession(request)) {
                HttpSession sesion = request.getSession(false);  //getSession (false) comprobará la existencia de la sesión. Si existe la sesión, entonces se devuelve la referencia de ese objeto de sesión, si no es así, estos métodos se devolverá null.                
            } else {
                response.sendRedirect("Login.html");
            }
            ServletOutputStream sos = null;
            sos = response.getOutputStream();
            String ruta = "C:\\Users\\Pwned\\JaspersoftWorkspace\\MyReports\\ListadoAlumnosxCarrera.jasper";
            File reporte = new File(ruta);
            if (tipo.equals("PDF")) {
//            String arc = getServletConfig().getServletContext().getRealPath("/Reportes/AlumnosxCarrera.jasper");
//           File reporte= new File(getServletConfig().getServletContext().getRealPath("/Reportes/AlumnosxCarrera.jasper"));
                byte[] bytes = null;
                bytes = JasperRunManager.runReportToPdf(reporte.getAbsolutePath(), null, conn.ObtenerConexion());
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                sos.write(bytes, 0, bytes.length);
                sos.flush();
                sos.close();
                JasperPrint jasperPrint = JasperFillManager.fillReport(ruta, null, conn.ObtenerConexion());
                JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Pwned\\JaspersoftWorkspace\\MyReports\\" + "alumnosxMateria" + ".pdf");
            }
            if (tipo.equals("XLS")) {
                JasperPrint print = JasperFillManager.fillReport(ruta, null, conn.ObtenerConexion());
                OutputStream out = response.getOutputStream();
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                JRXlsExporter exporterXLS = new JRXlsExporter();
                exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
                exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, arrayOutputStream);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                exporterXLS.exportReport();
                response.setHeader("Content-disposition", "attachment; filename=ListadoAlumnosporCarrera");
                response.setContentType("application/vnd.ms-excel");
                response.setContentLength(arrayOutputStream.toByteArray().length);
                out.write(arrayOutputStream.toByteArray());
                out.flush();
                out.close();


            }
            if (tipo.equals("DOCX")) {
                JasperPrint print = JasperFillManager.fillReport(ruta, null, conn.ObtenerConexion());
                OutputStream out = response.getOutputStream();
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                JRDocxExporter exporterDOX = new JRDocxExporter();
                exporterDOX.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
                exporterDOX.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                exporterDOX.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, arrayOutputStream);
                exporterDOX.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                exporterDOX.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                exporterDOX.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                exporterDOX.exportReport();
                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                response.setHeader("Content-Disposition", "inline; filename=\"file.docx\"");

                response.setContentLength(arrayOutputStream.toByteArray().length);
                out.write(arrayOutputStream.toByteArray());
                out.flush();
                out.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(GeneraPDFDinamico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(GeneraPDFDinamico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneraPDFDinamico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeneraPDFDinamico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void PDFUsuarioP(Profesor alumno, String titulo, HttpServletResponse response, HttpServletRequest request) {
        try {
            Map parameterMap = new HashMap();
            parameterMap.put("Usr", String.valueOf(alumno.getMatriculap()));
            parameterMap.put("clave", alumno.getEmail());
            parameterMap.put("titulo", titulo);
            parameterMap.put("Nombre", alumno.getNombre());
            parameterMap.put("paterno", alumno.getPaterno());
            parameterMap.put("materno", alumno.getMaterno());
            parameterMap.put("fecha", alumno.getFechan().toString());
            parameterMap.put("colonia", alumno.getColonia());
            parameterMap.put("calle", alumno.getCalle());
            parameterMap.put("num", String.valueOf(alumno.getNum()));
            parameterMap.put("cp", String.valueOf(alumno.getCp()));
            parameterMap.put("sexo", alumno.getSexo());
            String nombre = "/PDF/" + String.valueOf(alumno.getMatriculap()) + ".pdf";
//         String rut1a=getServletConfig().getServletContext().getRealPath("/Reportes/REgistroUsuario.jasper");
            Conexion con = new Conexion();
            String ruta = "C:\\Users\\Pwned\\JaspersoftWorkspace\\MyReports\\REgistroUsuario.jasper";
            JasperPrint jasperPrint = JasperFillManager.fillReport(ruta, parameterMap, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Pwned\\JaspersoftWorkspace\\MyReports\\" + String.valueOf(alumno.getMatriculap()) + ".pdf");

        } catch (JRException ex) {
            System.err.println(ex);
        }
    }

    public void PDFUsuario(Alumno alumno, String titulo, HttpServletResponse response, HttpServletRequest request) {
        try {
            Map parameterMap = new HashMap();
            parameterMap.put("Usr", String.valueOf(alumno.getMatriculaa()));
            parameterMap.put("clave", alumno.getEmail());
            parameterMap.put("titulo", titulo);
            parameterMap.put("Nombre", alumno.getNombre());
            parameterMap.put("paterno", alumno.getPaterno());
            parameterMap.put("materno", alumno.getMaterno());
            parameterMap.put("fecha", alumno.getFechan().toString());
            parameterMap.put("colonia", alumno.getColonia());
            parameterMap.put("calle", alumno.getCalle());
            parameterMap.put("num", String.valueOf(alumno.getNum()));
            parameterMap.put("cp", String.valueOf(alumno.getCp()));
            parameterMap.put("sexo", alumno.getSexo());
            String nombre = "/PDF/" + String.valueOf(alumno.getMatriculaa()) + ".pdf";
//         String rut1a=getServletConfig().getServletContext().getRealPath("/Reportes/REgistroUsuario.jasper");
            Conexion con = new Conexion();
            String ruta = "C:\\Users\\Pwned\\JaspersoftWorkspace\\MyReports\\REgistroUsuario.jasper";
            JasperPrint jasperPrint = JasperFillManager.fillReport(ruta, parameterMap, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Pwned\\JaspersoftWorkspace\\MyReports\\" + String.valueOf(alumno.getMatriculaa()) + ".pdf");
            //         JasperViewer.viewReport(jasperPrint, false);
//          JasperExportManager.exportReportToPdfFile( jasperPrint, nombre);

            /*
             String nombre="/PDF/"+ String.valueOf(alumno.getMatriculaa())+".pdf";         
             //JasperReport report = JasperCompileManager.compileReport("C:\\Users\\Pwned\\JaspersoftWorkspace\\MyReports\\REgistroUsuario.jrxml");
             File reporte= new File("C:\\Users\\Pwned\\JaspersoftWorkspace\\MyReports\\REgistroUsuario.jasper");
                    
         
             Conexion con= new Conexion();
             JasperPrint jasperPrint= JasperFillManager.fillReport(reporte.getAbsolutePath(), parameterMap, con.ObtenerConexion());
             // Exporta el informe a PDF
         
             JasperExportManager.exportReportToPdfFile(jasperPrint,   "C:\\Users\\Pwned\\JaspersoftWorkspace\\MyReports\\"+ String.valueOf(alumno.getMatriculaa())+".pdf");
             //Para visualizar el pdf directamente desde java
          
             JasperViewer.viewReport(jasperPrint, false);
             JasperExportManager.exportReportToPdfFile( jasperPrint, nombre);
             * 
             * 
             */
        } catch (JRException ex) {
            System.err.println(ex);
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
        processRequest(request, response, null, "");
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
        processRequest(request, response, null, null);
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
