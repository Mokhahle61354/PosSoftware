/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.charts;

import gui.FXMLOperations;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import possystem.MainController;
import static possystem.ManagementMain.main;

/**
 * FXML Controller class
 *
 * @author Mokhahle Thabo
 */
public class ChartLeftButtonsController implements Initializable {

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
    public void SoldStockBtnHandler(ActionEvent event) throws IOException
    {
        FXMLOperations FXMLFunctions = new FXMLOperations();
        node = (Node)FXMLLoader.load(getClass().getResource("/gui/charts/Merchiandice.fxml"));
        node.setId("apCharts");
        mainControler.apCharts.getChildren().setAll(node);
        //Below method says contrain node to apCharts
        FXMLFunctions.ConstrainToParent(mainControler.apCharts, node);
        
    }
    
    
    
    
}
