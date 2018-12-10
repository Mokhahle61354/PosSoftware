/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.employees;

import com.jfoenix.controls.JFXButton;
import gui.FXMLOperations;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import possystem.MainController;

/**
 * FXML Controller class
 *
 * @author Mokhahle Thabo
 */
public class btnLeftEmployeesController implements Initializable
{
    
    static MainController main = new MainController();
    FXMLOperations FXMLFunctions = new FXMLOperations();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void initMain(MainController main)
    {
        this.main = main;
    }

    @FXML private JFXButton btnEmployeesDashboard;
    
    Node node;
    public void EmployeesDashboard(ActionEvent event) throws IOException
    {
        node = (Node)FXMLLoader.load(getClass().getResource("/gui/employees/EmployeesDashboard.fxml"));
        node.setId("apEmployeesDashboard");
        main.apEmployees.getChildren().setAll(node);

        //Below method says contrain node to apEmployees
        FXMLFunctions.ConstrainToParent(main.apEmployees, node);
        
    }
    
    
}
