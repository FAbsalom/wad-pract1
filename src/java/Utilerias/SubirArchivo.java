package Utilerias;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

public class SubirArchivo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProcesaArchivo(request);
        } catch (FileUploadException ex) {
            Logger.getLogger(SubirArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public void ProcesaArchivo(HttpServletRequest request) throws FileUploadException {
            String direccion = request.getSession().getServletContext().getRealPath("ImagenesUsuarios/");
    //File reporte= new File(getServletConfig().getServletContext().getRealPath("/Reportes/ReporteUsuarios.jasper"));
        //getServletContext().getRealPath( getServletContext().getInitParameter( "dirUploadFiles" ) );
        ServletRequestContext src=new ServletRequestContext(request);	
        File archivo= new File( request.getSession().getServletContext().getRealPath("ImagenesUsuarios/"));            
        if( ServletFileUpload.isMultipartContent( request ) ){
            //Necesario para evitar errores de NullPointerException            
                    DiskFileItemFactory factory = new DiskFileItemFactory( (1024*1024),archivo);
	//Creamos un FileUpload
	ServletFileUpload upload=new  ServletFileUpload(factory);
	//Procesamos el request para que nos devuelva una lista
	//con los parametros y ficheros.
	List lista = upload.parseRequest(src);
	File file= null;
	//Recorremos la lista.
	Iterator it = lista.iterator();
	while(it.hasNext()){
		//Rescatamos el fileItem
		FileItem item=(FileItem)it.next();
		//Comprobamos si es un campo de formulario
		if(!item.isFormField()){
                                                try {
                                                    //Si no, es un fichero y lo subimos al servidor.
                                                    //Primero creamos un objeto file a partir del nombre del fichero.
                                                    file=new File(item.getName());
                                                    // y cogiendo el nombre del file
                                                    // y cogiendo el nombre del file
                                                                                   // Nota: Se podria hacer usando el objeto item en vez del file directamente
                                                    // Pero esto puede causar incompatibilidades segun que navegador, ya que 
                                                    // algunos solo pasan el nombre del fichero subido, pero otros
                                                    // como Iexplorer, pasan la ruta absoluta, y esto crea un pequeño problema al escribir
                                                    // el fichero en el servidor.
                                                    item.write(new File(archivo,file.getName()));
                                                    System.out.println("Fichero subido");
                                                } catch (Exception ex) {
                                                    Logger.getLogger(SubirArchivo.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                      }
                  }
          }        
        }    
}
