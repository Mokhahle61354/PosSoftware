/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions.settings;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import functions.MailingList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import possystem.MainController;

/**
 * FXML Controller class
 *
 * @author Mokhahle Thabo
 */
public class EmailSettingsController implements Initializable {

    private static MainController mainControler = new MainController();
    private static MailingList EmailClass = new MailingList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }
    public void initMain(MainController main)
    {
        mainControler = main;
    }
    
    @FXML JFXButton btnDisconnect;
    @FXML JFXButton btnConnect;
    @FXML JFXTextField txtUsername;
    @FXML JFXTextField txtPasswords;
    @FXML JFXComboBox cmbEmailProvider;
    
    public void ConnectEmail(ActionEvent event)
    {
        String sEmailAdress = txtUsername.getText() + cmbEmailProvider.getAccessibleText();
        String sPasswords = txtPasswords.getText();
        txtPasswords.setText(null);
        
        //Check if email is entered properly
        
        EmailClass.setUsername(sEmailAdress);
        EmailClass.setPassword(sPasswords);
        
        //TODO Call method to authenticate.
        //set label to show that email was succesfully connected.
        
        
    }
    
    public void DisConnectEmail(ActionEvent event)
    {
        String sEmailAdress = txtUsername.getText() + cmbEmailProvider.getAccessibleText();
        String sPasswords = txtPasswords.getText();
        
        txtPasswords.setText(null);
        
        EmailClass.setUsername(null);
        EmailClass.setPassword(null);
        
        //TODO Call method to authenticate.
        //set label to show that email was succesfully connected.
        
        
    }
    
    
}
