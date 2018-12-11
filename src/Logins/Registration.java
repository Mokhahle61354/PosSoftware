
package Logins;


import database.SqlEmployee;
import functions.FileOperation;
import functions.UserInfo;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Toolkit;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import possystem.ManagementMain;

public class Registration{
	
	public JFrame F;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtId;
	private JTextField txtEmployeeid;
	private JLabel lblFirstNames;
	private JLabel lblLastName;
	private JLabel lblId;
	private JLabel lblEmployeeid;
	private JLabel lblPosition;
	private JTextField txtposition;
	private JTextField txtdob;
	private JTextField txtgender; 
	private JButton btnuploadpic;
	private JLabel lblpic;
	public JButton btnRegister;
        public JComboBox cmbPosition;
        
        private String sFilepath;
	
	public Registration() {
		initialize();
		
	}
	private void initialize() {
		
		F = new JFrame();
		F.setBounds(100, 100, 588, 441);
		F.setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		F.setTitle("REGISTRATION");
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(173, 11, 198, 20);
		F.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JComboBox combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {"<select counrty of origin>", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Anguilla", "Antigua & Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia & Herzegovina", "Botswana", "Brazil", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "China - Hong Kong / Macau", "Colombia", "Comoros", "Congo", "Congo, Democratic Republic of (DRC)", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "French Guiana", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Great Britain", "Greece", "Grenada", "Guadeloupe", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Israel and the Occupied Territories", "Italy", "Ivory Coast (Cote d'Ivoire)", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Korea, Democratic Republic of (North Korea)", "Korea, Republic of (South Korea)", "Kosovo", "Kuwait", "Kyrgyz Republic (Kyrgyzstan)", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia, Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Moldova, Republic of", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco", "Mozambique", "Myanmar/Burma", "Namibia", "Nepal", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pacific Islands", "Pakistan", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovak Republic (Slovakia)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Netherlands", "Timor Leste", "Togo", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks & Caicos Islands", "Uganda", "Ukraine", "United Arab Emirates", "United States of America (USA)", "Uruguay", "Uzbekistan", "Venezuela", "Vietnam", "Virgin Islands (UK)", "Virgin Islands (US)", "Yemen", "Zambia", "Zimbabwe"}));
		combo.setToolTipText("");
		combo.setBounds(173, 296, 198, 20);
		F.getContentPane().add(combo);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(173, 52, 198, 20);
		F.getContentPane().add(txtSurname);
		txtSurname.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(172, 92, 199, 20);
		F.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtEmployeeid = new JTextField();
		txtEmployeeid.setBounds(173, 134, 198, 20);
		F.getContentPane().add(txtEmployeeid);
		txtEmployeeid.setColumns(10);
		
		lblFirstNames = new JLabel("FIRST NAMES");
		lblFirstNames.setBounds(10, 14, 114, 14);
		F.getContentPane().add(lblFirstNames);
		
		lblLastName = new JLabel("LAST NAME");
		lblLastName.setBounds(10, 55, 97, 14);
		F.getContentPane().add(lblLastName);
		
		lblId = new JLabel("ID");
		lblId.setBounds(10, 95, 57, 14);
		F.getContentPane().add(lblId);
		
		lblEmployeeid = new JLabel("EMPLOYEEID");
		lblEmployeeid.setBounds(10, 137, 114, 14);
		F.getContentPane().add(lblEmployeeid);
		
		lblPosition = new JLabel("POSITION");
		lblPosition.setBounds(10, 181, 82, 14);
		F.getContentPane().add(lblPosition);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH");
		lblDateOfBirth.setBounds(10, 223, 114, 14);
		F.getContentPane().add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setBounds(10, 263, 67, 14);
		F.getContentPane().add(lblGender);
		
		JLabel lblNationality = new JLabel("NATIONALITY");
		lblNationality.setBounds(10, 299, 114, 14);
		F.getContentPane().add(lblNationality);
		
		JComboBox cmbPosition= new JComboBox();
                cmbPosition.setModel(new DefaultComboBoxModel(new String[] {"<choose occupation>","MANANGER","OTHERS"}));
                cmbPosition.setToolTipText("");
		cmbPosition.setBounds(173, 178, 198, 20);
		F.getContentPane().add(cmbPosition);
		
		txtdob = new JTextField();
		txtdob.setBounds(173, 220, 198, 20);
		F.getContentPane().add(txtdob);
		txtdob.setColumns(10);
		
		txtgender = new JTextField();
		txtgender.setBounds(173, 260, 198, 20);
		F.getContentPane().add(txtgender);
		txtgender.setColumns(10);
		
		JButton btnRegister = new JButton("REGISTRATION");
		btnRegister.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
				
                        //upload Registration information to database
                        SqlEmployee employee = new SqlEmployee();
                        employee.setID(txtId.getText());
                        employee.setName(txtName.getText());
                        employee.setSurname(txtSurname.getText());
                        employee.setOccupation(txtposition.getText());
                        employee.setDateOfBirth(txtdob.getText());
                        employee.setNationality(combo.getSelectedItem().toString());
                        employee.setGender(txtgender.getText());
                        employee.setAddress("South africa mantjeng");
                        employee.setRecruitmentDate("2018/11/11");
                        UserInfo encrypt = new UserInfo();
                        
                        employee.setPasswords(encrypt.EncrypteString(txtEmployeeid.getText()));
                        
                        FileOperation picture = new FileOperation();
                        employee.setPicture(picture.PicToStringArray(sFilepath));
                        employee.insert();
                               							
                    }
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.setBounds(186, 345, 172, 31);
		F.getContentPane().add(btnRegister);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtName.setText("");
				txtSurname.setText("");
				txtdob.setText("");
				txtgender.setText("");
				txtposition.setText("");
				txtId.setText("");
				txtEmployeeid.setText("");
				F.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(46, 346, 97, 28);
		F.getContentPane().add(btnNewButton);
		
		btnuploadpic = new JButton("UPLOAD PHOTO");
		btnuploadpic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();
				jfc.showOpenDialog(null);
				File file=jfc.getSelectedFile();
				lblpic.setText(file.getAbsolutePath());
                                sFilepath = file.getAbsolutePath();
			}
		});
		btnuploadpic.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnuploadpic.setBounds(405, 162, 131, 23);
		F.getContentPane().add(btnuploadpic);
		
		lblpic = new JLabel("");
		lblpic.setBackground(new Color(102, 102, 102));
		lblpic.setBounds(405, 14, 137, 137);
		F.getContentPane().add(lblpic);
		
	}
	
}
