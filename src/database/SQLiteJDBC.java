/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import functions.FileOperation;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import org.sqlite.SQLiteException;

/**
 *
 * @author Mokhahle Thabo
 */
public class SQLiteJDBC
{
    private static String sClassName = "org.sqlite.JDBC";
    private static String sDBname;
    private static String sConnectionUrl;
    private Connection con;
    
    public SQLiteJDBC(String DatabaseName)
    {
        sDBname = DatabaseName;
        sConnectionUrl = "jdbc:sqlite:"+sDBname;
    }
    
    
    
    public boolean CreateTable(String sql)
    {
        Connection con = null;
        Statement stmt = null;
        
        boolean isTableCreated = false;

        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection(sConnectionUrl);
            System.out.println("Opened database successfully");

            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            isTableCreated = true;
        } catch (SQLiteException e) {
            System.out.println("SQL catch reached");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            isTableCreated = false;
        }
        finally
        {
            if(isTableCreated)
                System.out.println("Table created successfully");
            
            return isTableCreated;
        }
    }
    
    public void InsertQuery(String sql)
    {
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        
        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection(sConnectionUrl);
            con.setAutoCommit(false);
            stmt = con.createStatement();
            result = stmt.executeUpdate(sql);
            stmt.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println(result + " rows effected");
        System.out.println("Rows inserted successfully");
    }
    
    public void Select(String sql)
    {
        Connection con = null; 
        Statement stmt = null;
        
        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection(sConnectionUrl);
            System.out.println("Opened database successfully");
            con.setAutoCommit(false);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            while ( rs.next() ) 
            {
                String id = rs.getString("id");
                String  name = rs.getString("name");
                String surname = rs.getString("surname");
                String age  = rs.getString("DATE_OF_BIRTH");
                String  address = rs.getString("address");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "AGE = " + age );
                System.out.println( "ADDRESS = " + address );
                System.out.println( "Surname = " + surname );
                System.out.println();
            }
            rs.close();
            stmt.close();
            con.close();
            
        } catch ( Exception e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    
    public void update(String sql) 
    {
        Connection con = null; 
        Statement stmt = null;
        
        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection(sConnectionUrl);
            con.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            con.commit();

            //ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE;");

//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                String address = rs.getString("address");
//                float salary = rs.getFloat("salary");
//
//                System.out.println("ID = " + id);
//                System.out.println("NAME = " + name);
//                System.out.println("AGE = " + age);
//                System.out.println("ADDRESS = " + address);
//                System.out.println("SALARY = " + salary);
//                System.out.println();
//            }
//            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    
    
    public void delete(String sql)
    {
        Connection con = null; 
        Statement stmt = null;
        
        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection(sConnectionUrl);
            con.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            con.commit();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");

                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
                System.out.println();
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    
    public void UpdatePicture(String id,String filepath)
    {
        //only employees have picture we can put sql code here
        Connection con = null; 
        PreparedStatement pstmt = null;
        String sql = "UPDATE EMPLOYEES "
        + "SET picture = ? "
        + "WHERE id=?";
        
        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection(sConnectionUrl);
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(sql);
            System.out.println("Opened database successfully");
           
            pstmt.setBytes(1, readFile(filepath)); // set picture
            pstmt.setString(2, id); // setID
            pstmt.executeUpdate();  //update picture
            con.commit();
            
            pstmt.close();
            con.close();
            
        } catch (Exception e) 
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        
    
    }
    
    
    /**
     * Read the file and returns the byte array
     * @param file
     * @return the bytes of the file
     */
    public byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }
    
    /**
     * read the picture file and save int to filename
     *
     * @param Id
     */
    public Image readPicture(String Id) throws ClassNotFoundException 
    {
        // update sql
        String selectSQL = "SELECT picture FROM EMPLOYEES WHERE id=?";
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        
        Image img = null;
 
        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection(sConnectionUrl);
            pstmt = con.prepareStatement(selectSQL);
            pstmt.setString(1, Id);
            rs = pstmt.executeQuery();
            
            while (rs.next())
            {
                String byteAsString = rs.getString("picture");
                FileOperation filePicture = new FileOperation();
                byte[] buffer = filePicture.DbPicToBytes(byteAsString);
                
                img = new Image(new ByteArrayInputStream(buffer));
            }
   
            con.close();
            pstmt.close();
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            return img;
        }
                
    }
    
    public boolean DoesDataBaseExist(String tableName)
    {
        boolean isExist = false;
        
        String sql = "SELECT * FROM sqlite_master WHERE type='table' AND name='{"+tableName+"}';";
        
        Connection con = null; 
        Statement stmt = null;
        
        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection(sConnectionUrl);
            con.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            con.commit();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                isExist = true;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            isExist = false;
        }
        finally
        {
            System.out.println("Operation done successfully");
            return isExist;
        }  
        
    }
    
    public boolean DoesManagerExist()
    {
        boolean isExist = false;
        String sql = "SELECT * FROM EMPLOYEES;";
        Connection con = null; 
        Statement stmt = null;
        
        try 
        {
            Class.forName(sClassName);
            con = DriverManager.getConnection(sConnectionUrl);
            System.out.println("Opened database successfully");
            con.setAutoCommit(false);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            while ( rs.next() ) 
            {
                String  OCCUPATION = rs.getString("OCCUPATION");
                
                if(OCCUPATION.toLowerCase().equals("manager"))
                    isExist = true;
            }
            rs.close();
            stmt.close();
            con.close();
            
        } catch ( Exception e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
            isExist = false;
        }
        System.out.println("Operation done successfully");
        return isExist;
    }
 
}
