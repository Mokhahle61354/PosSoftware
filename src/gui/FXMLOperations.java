/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Mokhahle Thabo
 */
public class FXMLOperations 
{
    public void ConstrainToParent(AnchorPane parent, Node LoadedNode)
    {
        //below code will make sure that we constrain new gui to our anchor pane
        ObservableList<Node> AllNodes = parent.getChildren();
        for(int i=0;i<AllNodes.size();i++)
        {
            Node child = AllNodes.get(i);
            String id = child.getId();
            if(id.equals(LoadedNode.getId()))
            {
                AnchorPane.setTopAnchor(child, 0.0);
                AnchorPane.setBottomAnchor(child, 0.0);
                AnchorPane.setRightAnchor(child, 0.0);
                AnchorPane.setLeftAnchor(child, 0.0);
            }
        }
    }
    
    public void PlotOnLineChart(LineChart<?,?> LineChart)
    {
        LineChart.setTitle("Stock Monitoring, 2019");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Sold Product");
        //populating the series with data
        //below code will be under loop of database fatch.
        series.getData().add(new XYChart.Data("1", 23));// change it to method.
        //after loop ends
        LineChart.getData().addAll(series);
    }
    
}
