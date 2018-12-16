package Logins;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import MainInterface.MainPosInterface;
import MainInterface.TimeManagement;
import functions.UserInfo;
import possystem.ManagementMain;


public class Systems extends ManagementMain
{

    public JFrame frmLoginSystem;
    JFrame fram;
    JTextField txtID;
    public JPasswordField txtpass;
    JLabel lblNewLabel;
    JButton btncreat;
    JLabel lblbox;
    JLabel lblNewLabel_1;   

   
   
    public Systems() {
        initialize();

    }

    private void initialize() {
        /*
		  * frmLoginSystem is a frame of Login ınterface
		  * fram is the frame of Registration interface
		  * 
         */
        
    
        
        frmLoginSystem = new JFrame();
        frmLoginSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/imagelog.jpg")));
        frmLoginSystem.setTitle("LOGIN SYSTEM");
        frmLoginSystem.setBounds(100, 100, 446, 297);
        frmLoginSystem.getContentPane().setLayout(null);
        frmLoginSystem.setContentPane(new JLabel(new ImageIcon(getClass().getResource("/images/imagework.jpg"))));

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                //checking default user inputs for loging	
                CheckigInputToDefineTheUser();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(311, 166, 85, 33);
        btnNewButton.setForeground(Color.RED);
        frmLoginSystem.getContentPane().add(btnNewButton);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setForeground(Color.RED);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txtID.setText("");
                txtpass.setText("");
                frmLoginSystem.setVisible(false);
                
            }
        });

        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnCancel.setBounds(186, 166, 85, 33);
        frmLoginSystem.getContentPane().add(btnCancel);

        txtID = new JTextField();
        txtID.setBounds(186, 30, 210, 20);
        frmLoginSystem.getContentPane().add(txtID);
        txtID.setColumns(10);

        txtpass = new JPasswordField();
        txtpass.setBounds(186, 86, 210, 20);
        frmLoginSystem.getContentPane().add(txtpass);

        JLabel lblUsername = new JLabel("USERNAME :");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblUsername.setBounds(37, 30, 86, 14);
        lblUsername.setForeground(Color.RED);
        frmLoginSystem.getContentPane().add(lblUsername);

        lblNewLabel = new JLabel("PASSWORD");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(37, 89, 103, 14);
        lblNewLabel.setForeground(Color.RED);
        frmLoginSystem.getContentPane().add(lblNewLabel);


        lblbox = new JLabel("");
        lblbox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
        lblbox.setForeground(Color.RED);
        lblbox.setBounds(186, 137, 210, 18);
        frmLoginSystem.getContentPane().add(lblbox);

        JSeparator separator = new JSeparator();
        separator.setBounds(160, 119, 236, 2);
        separator.setForeground(Color.RED);;
        frmLoginSystem.getContentPane().add(separator);

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/images/secrecy-icon.png")));
        lblNewLabel_1.setBounds(22, 114, 128, 128);
        frmLoginSystem.getContentPane().add(lblNewLabel_1);

    }
    
    public void CheckigInputToDefineTheUser() {
        UserInfo user=new UserInfo();
        TimeManagement LoginTime=new TimeManagement();
        MainPosInterface m = new MainPosInterface();
        String ID=txtID.getText();
        
        if(user.isAuthenticated(ID,user.EncrypteString(txtpass.getText())))
        {  
            if(user.getOccupation().toLowerCase().equals("manager"))
            {
               // logedinuser=ID;
                ShowStage();
            }
            else
            {
                //logedinuser=ID;            
                LoginTime.setStartOfDutyTime();
                System.out.println("Logins. check disco)");
                txtID.setText("");
                txtpass.setText("");
                frmLoginSystem.setVisible(false);
              
                m.Mframe.setLocationRelativeTo(null);
                
                m.Mframe.setVisible(true); 
            }
        }
       else 
            
        {    
            lblbox.setForeground(Color.RED);
            lblbox.setFont(new Font("Tahoma", Font.BOLD, 16));
            lblbox.setText("WRONG INPUTS..!!!");
            
            //ShowStage();
        }

    }

}
