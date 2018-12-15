/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainInterface;

/**
 *
 * @author Keara
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;


public class CashButton {
   
    public JFrame frame;
    private JTextField txtMoneyPaid;
    private JTextField txtChange;
	
	static MainPosInterface mainPOSsystem  =  new MainPosInterface();
        
        public void InitMainPosInterface(MainPosInterface mainPOSsystem){
            this.mainPOSsystem=mainPOSsystem;
        }

	
    String sNumber = "";
    String sFinalNumber = "";
    double dChange = 0;
	
    public void WriteOnCalculator(ActionEvent e) {
    	
    	JButton btnNameForEvent = (JButton)e.getSource();
       
    	String test =  btnNameForEvent.getText();
    	
    	if (!test.equals("=")) {
    		
    		sNumber +=  btnNameForEvent.getText();
    		
    		txtMoneyPaid.setText(sNumber);
    		
    		
    	}
    	
    	else if (test.equals("="))
    	{
    		
    		dChange = Double.parseDouble(txtMoneyPaid.getText());
    		dChange=dChange-mainPOSsystem.total;
                mainPOSsystem.total=0;
    		txtChange.setText(String.valueOf(dChange));
    		
    	}
    	
    }
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashButton window = new CashButton();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public CashButton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setBounds(100, 100, 520, 487);
		frame.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setBounds(10, 35, 113, 45);
		frame.getContentPane().add(btnExit);
		
		JButton btnAddition = new JButton("+");
		btnAddition.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddition.setBounds(138, 117, 55, 45);
		frame.getContentPane().add(btnAddition);
		
		JButton btnSubtraction = new JButton("-");
		btnSubtraction.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSubtraction.setBounds(261, 117, 55, 45);
		frame.getContentPane().add(btnSubtraction);
		
		JButton btn200 = new JButton("200");
		btn200.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btn200.setBounds(374, 117, 96, 45);
		frame.getContentPane().add(btn200);
		
		JButton btnSeven = new JButton("7");
		btnSeven.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WriteOnCalculator(e);
				
				
				
			}
		});
		btnSeven.setBounds(15, 186, 55, 45);
		frame.getContentPane().add(btnSeven);
		
		JButton btnEight = new JButton("8");
		btnEight.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WriteOnCalculator(e);
				
				
			}
		});
		btnEight.setBounds(138, 186, 55, 45);
		frame.getContentPane().add(btnEight);
		
		JButton btnNine = new JButton("9");
		btnNine.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WriteOnCalculator(e);
				
			}
		});
		btnNine.setBounds(261, 186, 55, 45);
		frame.getContentPane().add(btnNine);
		
		JButton btn100 = new JButton("100");
		btn100.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btn100.setBounds(374, 186, 96, 45);
		frame.getContentPane().add(btn100);
		
		JButton btnFour = new JButton("4");
		btnFour.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btnFour.setBounds(15, 256, 55, 45);
		frame.getContentPane().add(btnFour);
		
		JButton btnFive = new JButton("5");
		btnFive.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btnFive.setBounds(138, 256, 55, 45);
		frame.getContentPane().add(btnFive);
		
		JButton btnSix = new JButton("6");
		btnSix.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btnSix.setBounds(261, 256, 55, 45);
		frame.getContentPane().add(btnSix);
		
		JButton btn50 = new JButton("50");
		btn50.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btn50.setBounds(374, 256, 96, 45);
		frame.getContentPane().add(btn50);
		
		JButton btnOne = new JButton("1");
		btnOne.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btnOne.setBounds(15, 323, 55, 45);
		frame.getContentPane().add(btnOne);
		
		JButton btnTwo = new JButton("2");
		btnTwo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btnTwo.setBounds(138, 323, 55, 45);
		frame.getContentPane().add(btnTwo);
		
		JButton btnThree = new JButton("3");
		btnThree.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btnThree.setBounds(261, 323, 55, 45);
		frame.getContentPane().add(btnThree);
		
		JButton btn20 = new JButton("20");
		btn20.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btn20.setBounds(374, 323, 96, 45);
		frame.getContentPane().add(btn20);
		
		JButton btnEqualSign = new JButton("=");
		btnEqualSign.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEqualSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btnEqualSign.setBounds(15, 391, 55, 45);
		frame.getContentPane().add(btnEqualSign);
		
		JButton btnZero = new JButton("0");
		btnZero.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btnZero.setBounds(138, 391, 55, 45);
		frame.getContentPane().add(btnZero);
		
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
			
		});
		btnDot.setBounds(261, 391, 55, 45);
		frame.getContentPane().add(btnDot);
		
		JButton btn10 = new JButton("10");
		btn10.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteOnCalculator(e);
			}
		});
		btn10.setBounds(374, 391, 96, 45);
		frame.getContentPane().add(btn10);
		
		txtMoneyPaid = new JTextField();
		txtMoneyPaid.setBounds(239, 11, 231, 45);
		frame.getContentPane().add(txtMoneyPaid);
		txtMoneyPaid.setColumns(10);
		
		txtChange = new JTextField();
		txtChange.setBounds(239, 52, 231, 54);
		frame.getContentPane().add(txtChange);
		txtChange.setColumns(10);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMoneyPaid.setText("");
				txtChange.setText("");
			}
		});
		btnCancel.setBounds(10, 117, 113, 45);
		frame.getContentPane().add(btnCancel);
	}
        
        
        
        
        
        
    
}
