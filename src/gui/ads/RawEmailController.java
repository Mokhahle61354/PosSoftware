/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ads;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import functions.MailingList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Mokhahle Thabo
 */
public class RawEmailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public JFXTextField txtMailTo;
    public JFXTextField txtMailSubject;
    public JFXTextArea txtMailContent;
    
    public void SendMessage(ActionEvent event)
    {
        MailingList emails = new MailingList("mokhahle.thabo@gmail.com","passwords");
        emails.sMessage = txtMailContent.getText();
        emails.sSubject = txtMailSubject.getText();
        emails.sCustomerMail = txtMailTo.getText();
        emails.SendMail();
    }
    public void ClearMailContent(ActionEvent event)
    {
        txtMailContent.setText("");
    }
    
    
    
}
