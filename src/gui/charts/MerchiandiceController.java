/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.charts;

import com.jfoenix.controls.JFXListView;
import database.SqlToGui;
import gui.FXMLOperations;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import possystem.MainController;

/**
 * FXML Controller class
 *
 * @author mokhahle thabo
 */
public class MerchiandiceController implements Initializable {

    static MainController main = new MainController();
    FXMLOperations FXMLFunctions = new FXMLOperations();
    SqlToGui SqlPlot = new SqlToGui();

    
    
    
    @FXML private JFXListView MerchiandiceList;
    @FXML private CategoryAxis XStockAxis;
    @FXML private NumberAxis YStockAxis;
    @FXML private LineChart<?,?> StockLineChart;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        // TODO
//        if(!MerchiandiceList.getItems().isEmpty())
//            SqlPlot.LinePlotSoldStockPriceDate(MerchiandiceList.getItems().get(0).toString(), StockLineChart);
        
        SqlToGui sqlGui = new SqlToGui();
        sqlGui.AvailableStock(MerchiandiceList);
    }
    
    public void initMain(MainController main)
    {
        this.main = main;
    }

    @FXML
    public void PlotLineChart(ActionEvent e)
    {   
        if(!MerchiandiceList.getItems().isEmpty())
        {
            String productName = MerchiandiceList.getSelectionModel().getSelectedItem().toString();
            String StartDate = "2018/12/15";
            SqlPlot.LinePlotSoldStockPriceDate(productName,StartDate, StockLineChart);
        }
    }
    
    
    
    
    
    
}
