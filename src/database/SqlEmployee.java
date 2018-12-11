/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.scene.image.Image;

///
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;



///

/**
 *
 * @author Mokhahle Thabo
 */

/**
 * This class will contain all operations need to operate of sql for employees DB 
 */
public class SqlEmployee
{
    private String ID;
    private String Name;
    private String Surname;
    private String DateOfBirth;
    private String Gender;
    private String Occupation;
    private String RecruitmentDate;
    private String Nationality;
    private String Address;
    private String Passwords;
    private String sPicture;
    private double dSalary;
    
    public void setPasswords(String passwords)
    {
        Passwords = passwords;
    }
    
    
    private String sDatabaseName="Employees.db";
   
    
    
    public boolean CreateTable()
    {
        
        //create table
        String sql;
        sql = "CREATE TABLE IF NOT EXISTS EMPLOYEES "
        + "(ID TEXT PRIMARY KEY     NOT NULL,"
        + " NAME           TEXT    NOT NULL, "
        + " SURNAME        TEXT    NOT NULL, "
        + " DATE_OF_BIRTH  TEXT     NOT NULL, "
        + " GENDER         TEXT    NOT NULL, "
        + " OCCUPATION     TEXT    NOT NULL, "
        + " NATIONALITY    TEXT    NOT NULL, "
        + " ADDRESS        TEXT     NOT NULL, "
        + " RECRUITMENT_DATE TEXT    NOT NULL,"
        + " PICTURE TEXT    NOT NULL,"
        + "PASSWORDS TEXT NOT NULL,"
        + "SALARY   REAL    )";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        boolean returnValue = DataManagement.CreateTable(sql);
        return returnValue;
       
    }
    
    public void insert()
    {
        //insert(id, name, surname, dob, gender, occupasion,nationality,address,recruit_date)
        String sql = "INSERT INTO EMPLOYEES "
            + "VALUES ('"+ID+"','"+Name+"', '"+Surname+"','"+DateOfBirth+"','"+Gender+"','"+Occupation+"',"
                + "'"+Nationality+"','"+Address+"', '"+RecruitmentDate+"', '"+sPicture+"' , '"+Passwords+"', '"+dSalary+"')";
        
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.InsertQuery(sql);
        
    }
    
    public void setPicture(String picture)
    {
        sPicture = picture;
    }
    
    public String getPicture()
    {
        return sPicture;
    }
    
    public void copyFileUsingStream(String ID,String sourceFolder) throws IOException
    {
        String destn = "/UserImages/"+ID+".jpg";
        
//        File file = new File(ID+".jpg");
//        FileWriter fr = new FileWriter(file, true);
//        fr.close();
        
        File dest = new File(destn);
        FileWriter fr = new FileWriter(dest, true);
        
        File source = new File(sourceFolder);
        
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            
            is.close();
            os.close();
            fr.close();
            }
        } finally {
            System.out.println("File moved");
        }
    }
    
    public Image getPicture(String ID)
    {
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        Image img = null;
        try {
            img = DataManagement.readPicture(ID);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;
    }
    public void select()
    {
        //select
        String sql = "SELECT * FROM EMPLOYEES;";
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.Select(sql);
    }
    public boolean DoesManagerExist()
    {
        boolean isExist = false;
        SQLiteJDBC DataManangement = new SQLiteJDBC(sDatabaseName);
        return DataManangement.DoesManagerExist();
    }
    public void Update(String id)
    {
        //update
        String sql = "UPDATE EMPLOYEES set SALARY = 25000.00 where ID="+id+";";
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.update(sql);
    }
    
    public void delete(String id)
    {
        //delete
        String sql = "DELETE from EMPLOYEES where ID="+id+";";
        SQLiteJDBC DataManagement = new SQLiteJDBC(sDatabaseName);
        DataManagement.delete(sql);
    
    }    

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setOccupation(String Occupation) {
        this.Occupation = Occupation;
    }

    public void setRecruitmentDate(String RecruitmentDate) {
        this.RecruitmentDate = RecruitmentDate;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

}
