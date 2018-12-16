/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author mokhahle thabo
 */
public class SqlAvailableStock
{

    private String Name;
    private double dPrice;
    private int Qty;
    private String sDatabaseName="AvailableStock.db";
    
    public boolean CreateTable()
    {
               //create table
        String sql;
        sql = "CREATE TABLE IF NOT EXISTS AVAILABLE_STOCK"
        + "(NAME    TEXT    PRIMARY KEY     NOT NULL, "
        + " QTY        INTEGER    NOT NULL, "
        + " PRICE        REAL    NOT NULL)";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        boolean returnValue = DataManagement.CreateTable(sql);
        return returnValue;
    }
    
    public void insert()
    {
        //insert(id, name, surname, dob, gender, occupasion,nationality,address,recruit_date)
        String sql = "INSERT INTO AVAILABLE_STOCK "
            + "VALUES ('"+Name+"', '"+Qty+"', '"+dPrice+"')";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.InsertQuery(sql);
        
    }
    
    public double GetPrice(String name)
    {
        //select
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        return DataManagement.GetPrice(name);
    }
    
    
    public void Update(String id,int quantity)
    {
        //update
        String sql = "UPDATE AVAILABLE_STOCK set QTY = "+quantity+" where ID="+id+";";
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.update(sql);
    }
    
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }
    
    public void setQty(int Qty)
    {
        this.Qty = Qty;
    }

}
