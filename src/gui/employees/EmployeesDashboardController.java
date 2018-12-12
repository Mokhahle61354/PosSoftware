/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.employees;

import com.jfoenix.controls.JFXListView;
import database.SqlToGui;
import functions.UserInfo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Mokhahle Thabo
 */
public class EmployeesDashboardController implements Initializable {

    @FXML JFXListView EmployeesList;
    SqlToGui transformSql = new SqlToGui();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO    
        //This will read all our sql and list all employees
        transformSql.Employees(EmployeesList);
    }
    
    @FXML public ImageView profilePicture;
    @FXML public Label lblNameOfUser;
    @FXML public Label lblSurnameofuser;
    @FXML public Label lblDateodbirth;
    @FXML public Label lblGender;
    @FXML public Label lblOccupation;
    @FXML public Label lblNationality;
    @FXML public Label lblAddress;
    @FXML 
    public void handleListMouseClick(MouseEvent arg0) // this will be used to update clicked user info
    {
//        SqlEmployee sss = new SqlEmployee();
//        FileOperation picFile = new FileOperation();
//        Image value  = sss.getPicture("123");
//        System.out.println("clicked on " + EmployeesList.getSelectionModel().getSelectedItem());
//        profilePicture.setImage(value);

        String ID = EmployeesList.getSelectionModel().getSelectedItem().toString();
        ID = ID.substring(0, 7);
        
        UserInfo user = new UserInfo(ID);
        profilePicture.setImage(user.getPicture());
        lblNameOfUser.setText(user.getName());
        String data = user.getDateOfBirth();
        lblSurnameofuser.setText(user.getSurname());
        lblDateodbirth.setText(data);
        lblGender.setText(user.getGender());
        lblOccupation.setText(user.getOccupation());
        lblNationality.setText(user.getNationality());
        lblAddress.setText(user.getAddress());
        
        
        System.out.println("surname "+user.getSurname());
        System.out.println("Name of user"+user.getName());
        
    }
    
}
