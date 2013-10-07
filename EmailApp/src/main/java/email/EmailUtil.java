package email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailUtil {

	private String to;
	private String from;
	private String host;
	Properties properties = System.getProperties();
	
	EmailUtil(){;}
	
	EmailUtil(String _to, String _from, String _host){to = _to; from = _from; host = _host;}
	
	 public void setTo(String _to){
		 this.to = _to;
	 }
	 
	 public void setFrom(String _from){
		 this.from = _from;
	 }
	 
	 public void setHost(String _host){
		 this.host = _host;
	 }
	 
	 public String getTo(){
		 return to;
	 }
	 
	 public String getFrom(){
		 return from;
	 }
	 
	 public String getHost(){
		 return host;
	 }

	 void sendMail(){
     // Setup mail server
     properties.setProperty("mail.smtp.host", host);

     // Get the default Session object.
     Session session = Session.getDefaultInstance(properties);

     try{
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.
        message.addRecipient(Message.RecipientType.TO,
                                 new InternetAddress(to));

        // Set Subject: header field
        message.setSubject("This is the Subject Line!");

        // Now set the actual message
        message.setText("This is actual message");

        // Send message
        Transport.send(message);
        System.out.println("Sent message successfully....");
     }catch (MessagingException mex) {
        mex.printStackTrace();
     }
  }
	
}
