/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mokhahle thabo
 */
public class SqlLogins
{
    private static String ID;
    private static String StartOfDutyTime;
    private static String EndOfDutyTime;
    private Long WorkedHours;
    
    private double tempID;
    
    public SqlLogins(String ID)
    {
        this.ID = ID;
        tempID = Math.random()*1000000  + 100000;
        setEndOfDutyTime();
        insert();
    }
	
    public String getCurrentTime()
    {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
    }

    private void setStartOfDutyTime()
    {
            StartOfDutyTime = getCurrentTime();
    }

    public void setEndOfDutyTime()
    {
        EndOfDutyTime = getCurrentTime();
        try 
        {
            WorkedHours = GetLogedInTime();
            Update();
        } catch (ParseException ex) {
            Logger.getLogger(SqlLogins.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }


    public long GetLogedInTime() throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date firstDate = sdf.parse(StartOfDutyTime);
        Date secondDate = sdf.parse(EndOfDutyTime);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return diff;
    }


    public void setID(String ID) {
        this.ID = ID;
    }
    
    DBVariables DB = new DBVariables();
    String sDatabaseName = DB.getLoginsDB();
    
    public boolean CreateTable()
    {
        
        //create table
        String sql;
        sql = "CREATE TABLE IF NOT EXISTS "+DB.getLoginsDB()+" "
        + "(TEMPID TEXT PRIMARY KEY     NOT NULL,"
        + "(ID TEXT     NOT NULL,"
        + "HOURS   REAL    )";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        boolean returnValue = DataManagement.CreateTable(sql);
        return returnValue;
       
    }
    
    private void insert()
    {
        //insert(id, name, surname, dob, gender, occupasion,nationality,address,recruit_date)
        String sql = "INSERT INTO "+DB.getLoginsDB()+" "
            + "VALUES ('"+tempID+"','"+ID+"', '"+WorkedHours+"')";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.InsertQuery(sql);
        
    }
    
    private void Update()
    {
        //update
        String sql = "UPDATE "+DB.getLoginsDB()+" set HOURS = "+WorkedHours+" where ID="+ID+";";
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.update(sql);
    }
    
    
}
