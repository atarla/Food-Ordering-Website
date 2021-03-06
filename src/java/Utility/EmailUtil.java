package Utility;

/**
 *
 * @author anusha
 */
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
        
public class EmailUtil {
        public static void sendMail(String to, String from,
            String subject, String body, boolean bodyIsHTML)
            throws MessagingException {

        // 1 - get a mail session
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        //added
        //props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", 465);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        //added

        //added
        SMTPAuthenticator auth = new SMTPAuthenticator();
        
        Session session = Session.getInstance(props, auth);
        session.setDebug(true);
        //added 
        
        
      // 2 - create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }

        // 3 - address the message
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        // 4 - send the message
        Transport transport = session.getTransport();
       
        transport.connect("goodfoodnbad@gmail.com", "qwerty@123");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    
    //sets authentications for google
    private static class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
           String username = "Email";
           String password = "email password";
           return new PasswordAuthentication(username, password);
        }
    }
}
