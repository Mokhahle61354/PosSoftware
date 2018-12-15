/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import MainInterface.TimeManagement;
import com.jfoenix.controls.JFXListView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    
    public void AddEmployeeToRegister(JFXListView EmployeeList)
    {
        DBVariables DBvar = new DBVariables();
        String sDatabaseName = DBvar.getEmployeeRegisterDB();
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
    
    public void AvailableStock(JFXListView StockListView)
    {
        String sDatabaseName = "AvailableStock.db";
        String sql = "SELECT * FROM AVAILABLE_STOCK;";
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

            System.out.println("Condition checking");
            while ( rs.next() ) 
            {
                System.out.println("Condition satisfied");
                String name = rs.getString("name");
                //String surname = rs.getString("surname");
                
                System.out.println(name);
                ListOfIdName.add(name);
                
            }
            rs.close();
            stmt.close();
            con.close();
            
            //This will show name of employees on the list
            StockListView.setItems(ListOfIdName);
            
        } catch ( Exception e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    
    public void LinePlotSoldStockPriceDate(String NameOfProduct,String yyyyMMdd,LineChart<?,?> lineChart)
    {
        SqlSoldStock soldStock = new SqlSoldStock();
        String sDatabaseName = soldStock.getsDatabaseName();
        String sql = "SELECT * FROM SOLD_STOCK;";
        Connection con = null;
        Statement stmt = null;
        
        lineChart.setTitle("Quantity sold with respect to time");
        
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Sold stock");
        
        TimeManagement PlotTime = new TimeManagement();
        Date StartDate = PlotTime.toDate(yyyyMMdd);
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection("jdbc:sqlite:"+sDatabaseName);
            System.out.println("Opened database successfully");
            con.setAutoCommit(false);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            
            
            int Qty= 0;
            while ( rs.next() ) 
            {
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                String _SoldDate = rs.getString("SOLD_DATE");
                Date soldDate = PlotTime.toDate(_SoldDate);
                
                if(StartDate.equals(soldDate))
                {
                    //populating the series with data
                    if(NameOfProduct.equals(name))
                    {
                        Qty++;
                    }
                        //     
                }
                else
                {
                    series.getData().add(new XYChart.Data(sdf.format(soldDate),Qty));
                    Calendar c = Calendar.getInstance();
                    c.setTime(StartDate);
                    c.add(Calendar.DATE, 1);  // number of days to add
                    //String date = sdf.format(c.getTime());
                    StartDate = c.getTime();
                    Qty = 0;
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
