/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import database.SqlEmployee;
import database.SqlToGui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Mokhahle Thabo
 */
public class TestThingsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML JFXTextField txtName;
    @FXML JFXTextField txtSurname;
    @FXML JFXTextField txtGender;
    @FXML JFXTextField txtOcupation;
    @FXML JFXTextField txtNation;
    @FXML JFXTextField txtDob;
    @FXML JFXTextField txtAdess;
    @FXML JFXTextField txtRtime;
    
    @FXML JFXButton btnAdd;
    
    @FXML
    
    private void CreateTable(ActionEvent event)
    {
        SqlEmployee employee = new SqlEmployee();
        employee.CreateTable();
    }
    int n = 1;
    @FXML
    private void Add(ActionEvent event)
    {
        SqlEmployee employee = new SqlEmployee();
        
        employee.setName(txtName.getText());
        employee.setAddress(txtAdess.getText());
        employee.setSurname(txtSurname.getText());
        employee.setGender(txtGender.getText());
        employee.setID("123"+n);
        employee.setNationality(txtNation.getText());
        employee.setRecruitmentDate("12/12/2000");
        employee.setOccupation(txtOcupation.getText());
        
        employee.insert();
        n++;
    
    }
    
    @FXML JFXListView EmployeeList;
    
    @FXML
    private void ListAll(ActionEvent event)
    {
        SqlToGui transformSql = new SqlToGui();
        transformSql.Employees(EmployeeList);
    }
    
    
    
}
