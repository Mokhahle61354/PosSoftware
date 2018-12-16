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
public class DBVariables 
{
    private String EmployeesDB = "Employees.db";
    private String EmployeeTable = "EMPLOYEES";
    private String SoldStockDB = "SoldStock.db";
    private String SoldStockTable = "SOLD_STOCK";
    private String LoginsDB = "Logins.db";
    private String LogingsTable = "LOGINS";
    private String AvailableStockTable = "AVAILABLE_STOCK";
    private String AvailableStockDB = "AvailableStock.db";
    private String EmployeeRegisterDB = "EmployeeRegister.db";
    
    
    public String getAvailableStockDB() {
        return AvailableStockDB;
    }
    
    public String getEmployeeTable() {
        return EmployeeTable;
    }

    public String getLogingsTable() {
        return LogingsTable;
    }

    public String getAvailableStockTable() {
        return AvailableStockTable;
    }
    
    public String getEmployeeRegisterDB() {
        return EmployeeRegisterDB;
    }

    public String getEmployeesDB() {
        return EmployeesDB;
    }
    
    public String getSoldStockDB() {
        return SoldStockDB;
    }

    public String getSoldStockTable() {
        return SoldStockTable;
    }
    
    public String getLoginsDB()
    {
        return LoginsDB;
    }
    
}
