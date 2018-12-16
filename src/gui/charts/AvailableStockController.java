/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.charts;

import com.jfoenix.controls.JFXListView;
import database.SqlToGui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ListView;
import possystem.MainController;

/**
 * FXML Controller class
 *
 * @author mokhahle thabo
 */
public class AvailableStockController implements Initializable {

    MainController main = new MainController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        AddItemToListView();
        PlotAvailableStock();
    }

    public void initMain(MainController main)
    {
        this.main = main;
    }
    
    @FXML private BarChart<?,?> StockBarChart;
    @FXML private JFXListView lstAvailableStock;
    
    @FXML
    private void PlotAvailableStock()
    {
        SqlToGui tempGui = new SqlToGui();
        StockBarChart.getData().clear();
        Series series = tempGui.getSeriesAvailableStock();
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Name of product");
        yAxis.setLabel("Quantity");
        StockBarChart.setTitle("Quantity availabe for each product");
        StockBarChart.getData().addAll(series);
        
    }
    
    @FXML
    private void AddItemToListView()
    {
        SqlToGui tempGui = new SqlToGui();
        tempGui.AvailableStock(lstAvailableStock);
    }
    
}
