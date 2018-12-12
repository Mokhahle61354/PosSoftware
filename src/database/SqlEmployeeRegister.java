/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Thabo Mokhahle
 */
public class SqlEmployeeRegister 
{
    DBVariables DBvar = new DBVariables();
    String sDatabaseName = DBvar.getEmployeeRegisterDB();
    private String Name;
    private String Surname;
    private String Date;
    private String ID;
    public boolean CreateTable()
    {
        
        //create table
        String sql;
        sql = "CREATE TABLE IF NOT EXISTS EMPLOYEES "
        + " ID           TEXT    NOT NULL, "
        + " NAME           TEXT    NOT NULL, "
        + " SURNAME        TEXT    NOT NULL, "
        + " DATE  TEXT     NOT NULL)";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        boolean returnValue = DataManagement.CreateTable(sql);
        return returnValue;
       
    }
    
    public void insert()
    {
        //insert(id, name, surname, dob, gender, occupasion,nationality,address,recruit_date)
        String sql = "INSERT INTO EMPLOYEES "
            + "VALUES ("+ID+"',"+Name+"', '"+Surname+"','"+Date+"')";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.InsertQuery(sql);
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    
    
    
}
