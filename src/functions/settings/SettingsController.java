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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import possystem.MainController;

/**
 * FXML Controller class
 *
 * @author Mokhahle Thabo
 */
public class SettingsController implements Initializable {

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
    
    @FXML public JFXButton btnAccountSettings;
    @FXML public JFXButton btnEmailSettings;
    @FXML public JFXButton btnAdsSettings;
    @FXML public JFXButton btnCloudSettings;
    @FXML public AnchorPane anSettingStage;
    
    //EmailFXML start
    @FXML public JFXButton btnEmainDisconnect;
    @FXML public JFXButton btnEmainConnect;
    
    @FXML public JFXTextField txtEmailUsername;
    @FXML public JFXTextField txtEmailPasswords;
    @FXML public JFXComboBox cmbEmailProvider;
    
    Parent root1;
    public void LoadSettingsGui()
    {
        try 
        {
            root1 = FXMLLoader.load(getClass().getResource("/functions/settings/settings.fxml"));
            Scene scene1 = new Scene(root1);
            Stage stage1 = new Stage();
            stage1.setScene(scene1);
            stage1.show();
            
        } catch (IOException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
   Node node; 
    public void EmailSettings(ActionEvent event) throws IOException
    {
        node = (Node)FXMLLoader.load(getClass().getResource("/fuctions/EmailSetting.fxml"));
        anSettingStage.getChildren().setAll(node);
    }
    
    @FXML
    public void EmailConnect(ActionEvent event)
    {
        String sEmailAdress = txtEmailUsername.getText();
        //sEmailAdress += cmbEmailProvider.
        String sPasswords = txtEmailPasswords.getText();
        EmailClass.setUsername(sEmailAdress);
        EmailClass.setPassword(sPasswords);
        
        //check if succesfully logedin
        //then
        EmailClass.setIsMailSystemActivated(true);
        
        
    }
    
    @FXML
    public void EmailDisconnect(ActionEvent event)
    {
        txtEmailUsername.clear();
        txtEmailPasswords.clear();
        EmailClass.setUsername(null);
        EmailClass.setPassword(null);
        EmailClass.setIsMailSystemActivated(false);
        
    }
    //EmailFXML ends
    
    
    
}
