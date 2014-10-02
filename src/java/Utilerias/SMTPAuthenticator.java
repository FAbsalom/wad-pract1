/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author Pwned
 */
class SMTPAuthenticator extends Authenticator {

    private PasswordAuthentication authentication;



    SMTPAuthenticator(String login, String password) {
       authentication = new PasswordAuthentication(login, password);
    }

        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
}
