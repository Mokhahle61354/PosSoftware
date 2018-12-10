/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logins;

import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.GroupLayout.Group;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Workspace
 */
public class FinalPosMain // extends Application 
{
    private void initAndShowGUI() 
    {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("Swing and JavaFX");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(1700, 1200);
        frame.setVisible(true);
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
    
    //NewClass p = new NewClass();

    private Scene createScene() throws IOException {
        
        //Parent root = p.root;
        
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/gui/ads/LeftButtons.fxml"));
        Scene scene = new Scene(root);

        return (scene);
    }
    
    
//    public static void main(String[] args) {
//        launch(args);
//    }
    
//    public void start(Stage stage) throws Exception
//    {
//           SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                initAndShowGUI();
//            }
//        });
//    }


}
