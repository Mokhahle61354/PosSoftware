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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.AnchorPane;
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

    
    @FXML private AnchorPane anStockCharts;
    
    @FXML private JFXListView MerchiandiceList;
    @FXML private CategoryAxis XStockAxis;
    @FXML private NumberAxis YStockAxis;
    @FXML private LineChart<?,?> StockLineChart;
    @FXML private BarChart<?,?> StockBarChart;
    @FXML private ScatterChart<?,?> StockScatterChart;
    @FXML private StackedAreaChart<?,?> StockStackedChart;
    
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
        anStockCharts.getChildren().clear();
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        yAxis.setLabel("Number of items sold");
        
       //creating the chart
        StockLineChart = new LineChart(xAxis,yAxis);
        StockLineChart.setTitle("Number of items sold at certain date");
        double width = anStockCharts.getLayoutX();
        double hight = anStockCharts.getLayoutY();
        StockLineChart.setLayoutX(width);
        StockLineChart.setLayoutY(hight);
        StockLineChart.getData().clear();
        if(!MerchiandiceList.getItems().isEmpty())
        {
            String productName = MerchiandiceList.getSelectionModel().getSelectedItem().toString();
            String StartDate = "2018/12/15";
            StockLineChart.setTitle("Quantity sold with respect to time");
            Series series = SqlPlot.getSeriesSoldStock(productName, StartDate);
            StockLineChart.getData().addAll(series);
            //SqlPlot.LinePlotSoldStockPriceDate(productName,StartDate, StockLineChart);
        }
        anStockCharts.getChildren().add(StockLineChart);
        AnchorPane.setTopAnchor(StockLineChart,0.0);
        AnchorPane.setBottomAnchor(StockLineChart,0.0);
        AnchorPane.setLeftAnchor(StockLineChart,0.0);
        AnchorPane.setRightAnchor(StockLineChart,0.0);
        
    }
    
    @FXML
    public void PlotBarChart(ActionEvent e)
    {   
        anStockCharts.getChildren().clear();
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        yAxis.setLabel("Number of items sold");
        
        //creating the chart
        StockBarChart = new BarChart(xAxis,yAxis);
        StockBarChart.setTitle("Number of items sold at certain date");
        double width = anStockCharts.getLayoutX();
        double hight = anStockCharts.getLayoutY();
        StockBarChart.setLayoutX(width);
        StockBarChart.setLayoutY(hight);
        StockBarChart.getData().clear();
        if(!MerchiandiceList.getItems().isEmpty())
        {
            String productName = MerchiandiceList.getSelectionModel().getSelectedItem().toString();
            String StartDate = "2018/12/15";
            StockBarChart.setTitle("Quantity sold with respect to time");
            Series series = SqlPlot.getSeriesSoldStock(productName, StartDate);
            StockBarChart.getData().addAll(series);
            //SqlPlot.LinePlotSoldStockPriceDate(productName,StartDate, StockLineChart);
        }
        anStockCharts.getChildren().add(StockBarChart);
        AnchorPane.setTopAnchor(StockBarChart,0.0);
        AnchorPane.setBottomAnchor(StockBarChart,0.0);
        AnchorPane.setLeftAnchor(StockBarChart,0.0);
        AnchorPane.setRightAnchor(StockBarChart,0.0);
    }
    
    @FXML
    public void PlotScatterChart(ActionEvent e)
    {   
        anStockCharts.getChildren().clear();
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        yAxis.setLabel("Number of items sold");
        
        //creating the chart
        StockScatterChart = new ScatterChart(xAxis,yAxis);
        StockScatterChart.setTitle("Number of items sold at certain date");
        double width = anStockCharts.getLayoutX();
        double hight = anStockCharts.getLayoutY();
        StockScatterChart.setLayoutX(width);
        StockScatterChart.setLayoutY(hight);
        StockScatterChart.getData().clear();
        if(!MerchiandiceList.getItems().isEmpty())
        {
            String productName = MerchiandiceList.getSelectionModel().getSelectedItem().toString();
            String StartDate = "2018/12/15";
            StockScatterChart.setTitle("Quantity sold with respect to time");
            Series series = SqlPlot.getSeriesSoldStock(productName, StartDate);
            StockScatterChart.getData().addAll(series);
            //SqlPlot.LinePlotSoldStockPriceDate(productName,StartDate, StockLineChart);
        }
        anStockCharts.getChildren().add(StockScatterChart);
        AnchorPane.setTopAnchor(StockScatterChart,0.0);
        AnchorPane.setBottomAnchor(StockScatterChart,0.0);
        AnchorPane.setLeftAnchor(StockScatterChart,0.0);
        AnchorPane.setRightAnchor(StockScatterChart,0.0);
    }
    
    @FXML
    public void PlotStackedChart(ActionEvent e)
    {   
        anStockCharts.getChildren().clear();
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        yAxis.setLabel("Number of items sold");
        
        //creating the chart
        StockStackedChart = new StackedAreaChart(xAxis,yAxis);
        StockStackedChart.setTitle("Number of items sold at certain date");
        double width = anStockCharts.getLayoutX();
        double hight = anStockCharts.getLayoutY();
        StockStackedChart.setLayoutX(width);
        StockStackedChart.setLayoutY(hight);
        StockStackedChart.getData().clear();
        if(!MerchiandiceList.getItems().isEmpty())
        {
            String productName = MerchiandiceList.getSelectionModel().getSelectedItem().toString();
            String StartDate = "2018/12/15";
            StockStackedChart.setTitle("Quantity sold with respect to time");
            Series series = SqlPlot.getSeriesSoldStock(productName, StartDate);
            StockStackedChart.getData().addAll(series);
            //SqlPlot.LinePlotSoldStockPriceDate(productName,StartDate, StockLineChart);
        }
        anStockCharts.getChildren().add(StockStackedChart);
        AnchorPane.setTopAnchor(StockStackedChart,0.0);
        AnchorPane.setBottomAnchor(StockStackedChart,0.0);
        AnchorPane.setLeftAnchor(StockStackedChart,0.0);
        AnchorPane.setRightAnchor(StockStackedChart,0.0);
    }
    
    
    
    
}
