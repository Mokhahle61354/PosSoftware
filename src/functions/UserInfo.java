/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import database.SqlEmployee;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author Mokhahle Thabo
 */

//TODO after login this file should view all user information and set pp
public class UserInfo 
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
    private Image Picture;
    
    
    public UserInfo(String ID)
    {
        try {
            INITIALIZE(ID);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public UserInfo(){}
    
    public boolean isAuthenticated(String id,String passwords)
    {
        String sDatabaseName="Employees.db";
        // update sql
        String selectSQL = "SELECT * FROM EMPLOYEES WHERE id=?";
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;
 
        try 
        {
            Class.forName("org.sqlite.JDBC");
          
            con = DriverManager.getConnection("jdbc:sqlite:"+sDatabaseName);
            pstmt = con.prepareStatement(selectSQL);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            while (rs.next())
            {
                String spass = rs.getString("PASSWORDS");
                if(spass.equals(passwords))
                {
                    Occupation = rs.getString("occupation");
                    return true;
                }
                else
                {
                    return false;
                }
            }
            con.close();
            pstmt.close();
            return false;
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }
    
    public void INITIALIZE(String id) throws ClassNotFoundException 
    {
        String sDatabaseName="Employees.db";
        // update sql
        String selectSQL = "SELECT * FROM EMPLOYEES WHERE id=?";
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;
 
        try 
        {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:"+sDatabaseName);
            pstmt = con.prepareStatement(selectSQL);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            while (rs.next())
            {   
                String byteAsString = rs.getString("picture");
                FileOperation filePicture = new FileOperation();
                byte[] buffer = filePicture.DbPicToBytes(byteAsString);
                
                Image img = new Image(new ByteArrayInputStream(buffer));
                Picture = img;
                ID = rs.getString("id");
                Name = rs.getString("name");
                Surname = rs.getString("surname");
                DateOfBirth = rs.getString("DATE_OF_BIRTH");
                Gender = rs.getString("gender");
                Occupation = rs.getString("occupation");
                RecruitmentDate = rs.getString("RECRUITMENT_DATE");
                Nationality = rs.getString("NATIONALITY");
                Address = rs.getString("ADDRESS");
                
            }
   
            con.close();
            pstmt.close();
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
    public String EncrypteString(String RawString)
    {
        String sEncryptedPasswords = "";
       
        try 
        {
            MessageDigest md;
            md = MessageDigest.getInstance("SHA-256");
            
            byte[] hashInBytes = md.digest(RawString.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }

            sEncryptedPasswords = sb.toString();

            System.out.println();
            System.out.println(sEncryptedPasswords);

            hashInBytes = md.digest(sEncryptedPasswords.getBytes(StandardCharsets.UTF_8));

            sb = new StringBuilder();
            for (byte bb : hashInBytes) {
                sb.append(String.format("%02x", bb));
            }

            sEncryptedPasswords = sb.toString();

            System.out.println();
            System.out.println(sEncryptedPasswords);
            return sEncryptedPasswords;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sEncryptedPasswords;
        
    }
    
    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public String getOccupation() {
        return Occupation;
    }

    public String getRecruitmentDate() {
        return RecruitmentDate;
    }

    public String getNationality() {
        return Nationality;
    }

    public String getAddress() {
        return Address;
    }

    public String getPasswords() {
        return Passwords;
    }

    public Image getPicture() {
        return Picture;
    }
    
    
    
    
    
}
