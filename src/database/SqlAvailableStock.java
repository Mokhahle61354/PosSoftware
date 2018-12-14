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
    private String sDatabaseName="AvailableStock.db";
    
    public boolean CreateTable()
    {
               //create table
        String sql;
        sql = "CREATE TABLE IF NOT EXISTS AVAILABLE_STOCK"
        + "(NAME    TEXT PRIMARY KEY    NOT NULL, "
        + " PRICE        REAL    NOT NULL)";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        boolean returnValue = DataManagement.CreateTable(sql);
        return returnValue;
    }
    
    public void insert()
    {
        //insert(id, name, surname, dob, gender, occupasion,nationality,address,recruit_date)
        String sql = "INSERT INTO AVAILABLE_STOCK "
            + "VALUES ('"+Name+"', '"+dPrice+"')";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.InsertQuery(sql);
        
    }
    
    
    
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

}
