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
public class SqlCurrentStock
{

    private String Name;
    private double dPrice;
    private String sBoughtDate;
    private String ID;
    private String sQty;
    private String sDatabaseName="CurrentStock.db";
    
    public boolean CreateTable()
    {
               //create table
        String sql;
        sql = "CREATE TABLE SOLD_STOCK"
        + "(ID TEXT PRIMARY KEY     NOT NULL,"
        + " NAME           TEXT    NOT NULL, "
        + " PRICE        REAL    NOT NULL, "
        + " QTY        INT    NOT NULL, "
        + " BOUGHT_DATE  TEXT     NOT NULL)";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        boolean returnValue = DataManagement.CreateTable(sql);
        return returnValue;
    }
    
    public void insert()
    {
        //insert(id, name, surname, dob, gender, occupasion,nationality,address,recruit_date)
        String sql = "INSERT INTO SOLD_STOCK "
            + "VALUES ('"+ID+"','"+Name+"', '"+dPrice+"','"+sQty+"','"+sBoughtDate+"')";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.InsertQuery(sql);
        
    }
    
    
    
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public void setsBoughtDate(String sBoughtDate) {
        this.sBoughtDate = sBoughtDate;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

}
