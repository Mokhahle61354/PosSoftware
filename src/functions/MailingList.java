/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

/**
 *
 * @author Mokhahle Thabo
 */

//https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailingList 
{
    private boolean isMailSystemActivated = false;
    private String username;
    private String password;
    public String sMessage;
    public String sSubject;
    public String sCustomerMail;

    /**
     *MailingList(String username, String password)
     */
    public MailingList(String username, String password)//activate the mail system.
    {
        this.username = username;//"username@gmail.com";
        this.password = password;// "password";
    }

    public MailingList()
    {
        this.username = null;//"username@gmail.com";
        this.password = null;// "password";
    }
    
    public boolean SendMail()
    {
        boolean isSended = false;
        if(sCustomerMail!=null)
            isSended = MailPrepared(sSubject,sMessage,sCustomerMail);
        
        sSubject = sMessage = sCustomerMail = null;
        
        return isSended;
    }
    

    private boolean MailPrepared(String sMailSubject,String sMsg, String sCustomerAddress) 
    {

        boolean isMailPrepared = false;
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); //add functionality to chose whether gmail, yahoo ....
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try 
        {
            //sMsg = "Dear Customer," + "\n\n Come buy agian, please!";
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));//"from-email@gmail.com"
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(sCustomerAddress));//"to-email@gmail.com"
            message.setSubject(sMailSubject);
            message.setText(sMsg);

            Transport.send(message);

            //System.out.println("Done");
            
            isMailPrepared = true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        finally
        {
            return isMailPrepared;
        }
    }
    
    private boolean MailAuthenticated()//should check if system accepted entered User/pass
    {
        return false;
    }
    private Session CreateMailSession()//should check if system accepted entered User/pass
    {
        return null;
    }
    
    public void setIsMailSystemActivated(boolean isMailSystemActivated) {
        this.isMailSystemActivated = isMailSystemActivated;
    }

    public void setsMessage(String sMessage) {
        this.sMessage = sMessage;
    }

    public void setsSubject(String sSubject) {
        this.sSubject = sSubject;
    }

    public void setsCustomerMail(String sCustomerMail) {
        this.sCustomerMail = sCustomerMail;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

}
