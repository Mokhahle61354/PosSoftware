/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Mokhahle Thabo
 */
public class SqlSoldStock
{
    private String Name;
    private double dPrice;
    private String sSoldDate;
    private String ID;
    private String sQty;
    private double dDiscount;
    private String sDatabaseName="SoldStock.db";
    
    public boolean CreateTable()
    {
               //create table
        String sql;
        sql = "CREATE TABLE IF NOT EXISTS SOLD_STOCK"
        + "(NAME           TEXT    NOT NULL, "
        + " PRICE        REAL    NOT NULL, "
//        + " DISCOUNT        REAL    NOT NULL, "
//        + " QTY        REAL    NOT NULL, "
        + " SOLD_DATE  TEXT     NOT NULL)";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        boolean returnValue = DataManagement.CreateTable(sql);
        return returnValue;
    }
    
    public void insert()
    {
        //insert(id, name, surname, dob, gender, occupasion,nationality,address,recruit_date)
        String sql = "INSERT INTO SOLD_STOCK "
            + "VALUES ('"+Name+"', '"+dPrice+"','"+sSoldDate+"')";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.InsertQuery(sql);
        
    }
    
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public void setsSoldDate(String sSoldDate) {
        this.sSoldDate = sSoldDate;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setdDiscount(double dDiscount) {
        this.dDiscount = dDiscount;
    }
    
    
    
}
