/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.jfoenix.controls.JFXListView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Mokhahle Thabo
 */
public class SqlToGui 
{

    //TODO make sure that this point to employee database
    public static String sClassName = "org.sqlite.JDBC";
    public void Employees(JFXListView EmployeeList)
    {
        String sDatabaseName = "Employees.db";
        String sql = "SELECT * FROM EMPLOYEES;";
        Connection con = null; 
        Statement stmt = null;
        ObservableList<String> ListOfIdName = FXCollections.observableArrayList();
        
        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection("jdbc:sqlite:"+sDatabaseName);
            System.out.println("Opened database successfully");
            con.setAutoCommit(false);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            while ( rs.next() ) 
            {
                String id = rs.getString("id");
                String  name = rs.getString("name");
                String surname = rs.getString("surname");
                
                ListOfIdName.add(id +" "+ name +" "+surname);
                
            }
            rs.close();
            stmt.close();
            con.close();
            
            //This will show name of employees on the list
            EmployeeList.setItems(ListOfIdName);
            
        } catch ( Exception e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    
    public void LinePlotSoldStockPriceDate(String NameOfProduct,LineChart<?,?> lineChart)
    {
        DBVariables DB = new DBVariables();
        String sDatabaseName = DB.getSoldStockDB();
        String sql = "SELECT * FROM "+DB.getSoldStockTable()+";";
        Connection con = null; 
        Statement stmt = null;
        
        lineChart.setTitle("Quantity sold with respect to time");
        
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Sold stock");
        
        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection("jdbc:sqlite:"+sDatabaseName);
            System.out.println("Opened database successfully");
            con.setAutoCommit(false);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            while ( rs.next() ) 
            {
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                String SoldDate = rs.getString("SOLD_DATE");
                
                if(NameOfProduct == name)
                {
                    //populating the series with data
                    series.getData().add(new XYChart.Data(SoldDate,price));     
                
                }
                
            }
            rs.close();
            stmt.close();
            con.close();
            
            lineChart.getData().addAll(series);
            
        } catch ( Exception e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        
    }
    
}
