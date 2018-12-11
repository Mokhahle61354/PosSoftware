/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package possystem;

import Logins.FinalPosMain;
import Logins.Registration;
import database.SqlEmployee;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mokhahle Thabo
 */
public class ManagementMain extends Application {
    
    static JFrame frame = new JFrame("Swing and JavaFX");
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/gui/ads/LeftButtons.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        this.stage =stage;
        
        //stage.show();
        
        SqlEmployee DB = new SqlEmployee();
        if(DB.CreateTable())
            System.out.println("Employee table already exist");
        else
            System.out.println("Employee table created");
        
        
        //start of Creating table for our database
            
            //DB.CreateTable();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    initAndShowGUI();
                }
            });
            
            SqlEmployee manager = new SqlEmployee();
            //below condition checks if manager exist in database
            if(manager.DoesManagerExist())
                LoginMain();
            else //it allows manager to create himself.
                RegisterMain();
                
                

        }
        //end of Creating table for our database
        
        
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);   
        
    }
//    
    
    
    private void initAndShowGUI() 
    {
        // This method is invoked on the EDT thread
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(1700, 1200);
        //frame.setVisible(true);
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });
    }

    private  void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene;
        try {
            scene = createScene();
            fxPanel.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(FinalPosMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ShowStage()
    {
        frame.setVisible(true);
    }
    public void HideStage()
    {
        frame.setVisible(false);
    }
    
    //NewClass p = new NewClass();

    private Scene createScene() throws IOException {
        
        //Parent root = p.root;
        
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/gui/ads/LeftButtons.fxml"));
        Scene scene = new Scene(root);

        return (scene);
    }
    
    
    
    private void LoginMain()
    {
        Logins.Systems s = new Logins.Systems();
        try {
            s.frmLoginSystem.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    Registration reg = new Registration();
    
    private void RegisterMain()
    {
        reg.F.setVisible(true);
        reg.setCMBToManager();
    }
    
    public void initRegistration(Registration reg)
    {
        this.reg = reg;
    }
}
