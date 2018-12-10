/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salarysheet;

import MainInterface.TimeManagement;
import java.text.ParseException;

/**
 *
 * @author malva
 */
public class SalarySheet {
    
   private String Id;
   private double Salary;
     
    TimeManagement timeDifference= new TimeManagement();
   
   public double GetSalaryOfUserById(String ID,double SalaryPerHour)throws ParseException
   {
       Salary=SalaryPerHour*(timeDifference.GetLogedInTime());
       
       return Salary;
   }
   
   public void setSalary(double salary)
   {
     this.Salary=salary;
   }
   public double getSalary()
   {
     return Salary;
   }
   
}
