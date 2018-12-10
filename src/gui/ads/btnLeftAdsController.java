/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ads;

import gui.FXMLOperations;
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

import javafx.stage.Stage;
import possystem.MainController;
/**
 * FXML Controller class
 *
 * @author Mokhahle Thabo
 */
public class btnLeftAdsController implements Initializable {

    
    private static MainController mainControler = new MainController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void initMain(MainController main)
    {
        mainControler = main;
    }
    
    Node node;
    @FXML
    public void EmailSpecificPerson(ActionEvent event) throws IOException
    {
        FXMLOperations anchorOperate = new FXMLOperations();
        //anchorOperate.ConstrainToParent(parent, node);
        
        mainControler.setTabAnchorPane("/gui/ads/RawEmail.fxml");
            
            
            
            //This will change ancorpane of the
            // "/gui/ads/RawEmail.fxml"
//        try
//        {
//            Method method = possystem.MainController.class.getMethod("EmailSpecificPerson", null);
//            method.invoke(null, null);
//        } 
//        catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
//        {
//            Logger.getLogger(LeftButtonsController.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
            
            
            //This will change ancorpane of the
            // "/gui/ads/RawEmail.fxml"
//        try
//        {
//            Method method = possystem.MainController.class.getMethod("EmailSpecificPerson", null);
//            method.invoke(null, null);
//        } 
//        catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
//        {
//            Logger.getLogger(btnLeftAds.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
            
            
            //This will change ancorpane of the
            // "/gui/ads/RawEmail.fxml"
//        try
//        {
//            Method method = possystem.MainController.class.getMethod("EmailSpecificPerson", null);
//            method.invoke(null, null);
//        } 
//        catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
//        {
//            Logger.getLogger(LeftButtonsController.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
            
            
            //This will change ancorpane of the
            // "/gui/ads/RawEmail.fxml"
//        try
//        {
//            Method method = possystem.MainController.class.getMethod("EmailSpecificPerson", null);
//            method.invoke(null, null);
//        } 
//        catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
//        {
//            Logger.getLogger(btnLeftAdsController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
    }
    
    public void printTopEmployee(ActionEvent event)
    {
        Stage AppStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene AppScene = ((Node) event.getSource()).getScene();
        Parent AppRoot = ((Node) event.getSource()).getScene().getRoot().getParent();
        
    }
    
}
