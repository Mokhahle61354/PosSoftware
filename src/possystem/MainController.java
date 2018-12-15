/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//--module-path="C:\Program Files\Java\javafx-sdk-11\lib" --add-modules=javafx.controls,javafx.fxml,javafx.web,javafx.base,javafx.graphics,javafx.media,javafx.swing
package possystem;

import functions.settings.EmailSettingsController;

import functions.settings.SettingsController;
import functions.settings.StockManagementSettingController;
import gui.ads.btnLeftAdsController;
import gui.charts.ChartLeftButtonsController;
import gui.charts.MerchiandiceController;
import gui.employees.EmployeesDashboardController;
import gui.employees.btnLeftEmployeesController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import Logins.Registration;
import Logins.Systems;
import MainInterface.MainPosInterface;
import MainInterface.TimeManagement;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import database.SqlEmployee;
import database.SqlEmployeeRegister;
import database.SqlToGui;
import functions.UserInfo;
import java.awt.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author Mokhahle Thabo
 */
public class MainController implements Initializable
{

    
    private static String sCurrentTab ="";
    @FXML private TabPane mainTabs;
    
    btnLeftAdsController btnLeftAds;
    static SettingsController settings = new SettingsController();
    static EmailSettingsController EmailSettings = new EmailSettingsController();
    static btnLeftEmployeesController btnLeftEmployees = new btnLeftEmployeesController();
    static ChartLeftButtonsController btnleftCharts = new ChartLeftButtonsController();
    static MerchiandiceController merchiandice = new MerchiandiceController();
    
    @FXML private AnchorPane ApLeftButtons;
    @FXML public AnchorPane apAdvertising;
    @FXML public AnchorPane apDashBoard;
    @FXML public AnchorPane apEmployees;
    @FXML public AnchorPane apCharts;
    
    @FXML public ImageView imgProfilePic;
    @FXML public Label lblProfileName;
    
 
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        System.out.println("Program started");
        initAllImages();
        //initializing maint to all classes
        btnLeftAds = new btnLeftAdsController();
        btnLeftAds.initMain(this);
        EmailSettings.initMain(this);
        btnLeftEmployees.initMain(this);
        btnleftCharts.initMain(this);
        merchiandice.initMain(this);
        
    }
    
    public void initAds(btnLeftAdsController btnLeft)
    {
        btnLeftAds = btnLeft;
    }
    
    @FXML public ImageView imgBtnAddEmployee;
    @FXML public ImageView imgBtnSettings;
    @FXML public ImageView imgBtnLogout;
    

    public void initAllImages()
    {
        
        Image image = new Image("/images/addperson.png");
        imgBtnAddEmployee.setImage(image);
        image = new Image("/images/settings.png");
        imgBtnSettings.setImage(image);
        image = new Image("/images/logout.png");
        
    }
    
    Node node;
    
    //Check if tab has changed
    @FXML
    private void ClickChanged() //throws IOException 
    {
        //method to detect if tab is changed
        mainTabs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>()
        {
            @Override
            public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1)
            {
                System.out.println("Tab Selection changed");
                String _sCurrentTab = mainTabs.getSelectionModel().getSelectedItem().getText();
                sCurrentTab = _sCurrentTab;
                try 
                {
                    ChangeLeftButtons(sCurrentTab);
                } catch (IOException ex) 
                {
                    System.out.println("Problem is when changeng buttons");
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    //Change left buttons based on current tab
    private void ChangeLeftButtons(String _sCurrentTab) throws IOException
    {
        
        switch (_sCurrentTab) {
            case "Employees":
                node = (Node)FXMLLoader.load(getClass().getResource("/gui/employees/btnLeftEmployees.fxml"));
                break;
            case "Charts":
                node = (Node)FXMLLoader.load(getClass().getResource("/gui/charts/ChartsLeftButtons.fxml"));
                break;
            case "Advertising":
                node = (Node)FXMLLoader.load(getClass().getResource("/gui/ads/btnLeftAds.fxml"));
                break;
            default:
                node = (Node)FXMLLoader.load(getClass().getResource("/gui/dashboard/LeftButtons.fxml"));
                break;
        }
        
        System.out.println("Change left buttons for : "+_sCurrentTab);
        
        ApLeftButtons.getChildren().setAll(node);
    }
    
    @FXML
    public void GoToCashierSystem(ActionEvent event)
    {
        MainPosInterface cashierMain = new MainPosInterface();
        cashierMain.Mframe.setVisible(true);
        ManagementMain main = new ManagementMain();
        main.HideStage();
        
    }
    
    //Start of Tab operation code..
    public void EmailSpecificPerson()
    {
        String sPanePath = "/gui/ads/RawEmail.fxml";
        try 
        {
            //This will change ads tab ancorpane;
            setTabAnchorPane(sPanePath);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //This method will change anchor pane of current tab to desired sFloder fxml
    public void setTabAnchorPane(String sPaneFolder) throws IOException
    {
        String _sCurrentTab;
        _sCurrentTab = sCurrentTab;
        System.out.println("sCurrentTabs = "+sCurrentTab);
        
        
        System.out.println("Setting node to "+sPaneFolder);
        node = (Node)FXMLLoader.load(getClass().getResource(sPaneFolder));
        node.autosize();
        System.out.println("Node sucessfully created");


        switch (_sCurrentTab) {
            case "Employees":
                apEmployees.getChildren().setAll(node);
                break;
            case "Charts":
                apCharts.getChildren().setAll(node);
                break;
            case "Advertising":
                System.out.println("Ads case scope");
                apAdvertising.getChildren().setAll(node); //problen is here
                System.out.println("Ads case scope ends");
                break;
            default:
                apDashBoard.getChildren().setAll(node);
                break;
        }
    }
    //End of Tab operation code..
    
    
    
    
    @FXML
    public void LoadSettingsGui(ActionEvent event)
    {
        //TODO load gui based on right controls
        settings.LoadSettingsGui();
    }
    
    @FXML
    public void LoadGuiToAddEmployee(ActionEvent event)
    {
        Registration registration = new Registration();
        registration.F.setVisible(true);
    
    }
    //
    @FXML public JFXTextField txtEmployeeID;
    @FXML public JFXListView lstPreserntEmployees;
    @FXML
    public void MarkEmployeeAsPresent(ActionEvent event)
    {
        String ID = txtEmployeeID.getText();
        SqlEmployee employee = new SqlEmployee();
        boolean isExist = employee.DoesThisEmployeeExist(ID);
        if(isExist)
        {
            TimeManagement time = new TimeManagement();
            UserInfo emp = new UserInfo(ID);
            SqlEmployeeRegister register  = new SqlEmployeeRegister();
            register.setID(ID);
            register.setName(emp.getName());
            register.setSurname(emp.getSurname());
            register.setDate(time.getCurrentDate());
            register.insert();
            SqlToGui tempGui = new SqlToGui();
            tempGui.AddEmployeeToRegister(lstPreserntEmployees);
        }
       
        
    }
    
}
