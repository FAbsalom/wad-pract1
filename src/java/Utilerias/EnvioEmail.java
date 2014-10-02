/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import com.sun.mail.smtp.SMTPTransport;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Pwned
 */
public class EnvioEmail extends HttpServlet {

    private String err;
    private String succ;

    public void processRequest(HttpServletRequest request, HttpServletResponse response, String destinatario, String message, String ruta, String asunto)
            throws ServletException, IOException {

        try {

            EnviarEmail(request, response, destinatario, message, ruta, asunto);

        } finally {
        }
    }

    private void EnviarEmail(HttpServletRequest request, HttpServletResponse response, String destinatario, String message, String ruta, String asunto)
            throws ServletException, IOException {
        //        String rut1a=getServletConfig().getServletContext().getRealPath("/Reportes/REgistroUsuario.jasper");
        String to = destinatario;
        String from = "juan.escom.isc@gmail.com";
        //String subject = "Notificacion de Registro";
        //String message1 = "Corrreo enviado despues de registrarse";
        String login = "juan.escom.isc@gmail.com";
        String password = "b257ea0317";
        try {
            Properties props = new Properties();
            props.setProperty("mail.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            Authenticator auth = new SMTPAuthenticator(login, password);

            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.setText(message);
            msg.setSubject(asunto);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));
            adjunto.setFileName("DatosRegistro.pdf");
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(adjunto);
            msg.setContent(multiParte);
            SMTPTransport transport = (SMTPTransport) session.getTransport("smtp");

            Transport.send(msg);



        } catch (AuthenticationFailedException ex) {
            request.setAttribute("ErrorMessage", "Authentication failed");
            response.sendRedirect("ErrorServlet");
            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
            dispatcher.forward(request, response);

//            JOptionPane.showMessageDialog(null,"Authentication failed" );
//            return;

        } catch (AddressException ex) {
            request.setAttribute("ErrorMessage", "Wrong email address");
            response.sendRedirect("ErrorServlet");
            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
            dispatcher.forward(request, response);

//              JOptionPane.showMessageDialog(null,"Authentication failed" );
//            return;


        } catch (MessagingException ex) {
            request.setAttribute("ErrorMessage", ex.getMessage());
//            JOptionPane.showMessageDialog(null,"Error al enviar" );
            System.out.println(ex.getMessage());
            response.sendRedirect("ErrorServlet");
            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
            dispatcher.forward(request, response);
//              JOptionPane.showMessageDialog(null,"Error al enviar" );
//            return;
        }
        //    RequestDispatcher dispatcher = request.getRequestDispatcher(succ);
//            dispatcher.forward(request, response);

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
