/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author mokhahle thabo
 */
public class FileOperation 
{
    public String PicToStringArray(String source)
    {
        byte[] picByte = readFile(source);
        String StringByte ="";
        for(byte b :picByte)
        {
            StringByte += b + " ";
        }
        return StringByte;
        
    }
    
    public byte[] DbPicToBytes(String StringByte) 
    {               
        String[] MyByte = StringByte.split(" ");
        byte[] data = new byte[MyByte.length];
        for (int i = 0; i < MyByte.length; i++) {
            String string = MyByte[i];
            data[i] = (byte)Integer.parseInt(string); // you can chose charset
        }
        return data;
    }
    
    public byte[] readFile(String file)
    {
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
    
    
    
}
