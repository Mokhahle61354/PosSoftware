package MainInterface;



import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JList;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.views.AbstractView;


import java.awt.Font;
import java.awt.SystemColor;

import Logins.Systems;

public class MainPosInterface implements org.w3c.dom.events.MouseEvent , ActionListener ,MouseListener{

        public JFrame Mframe;
	private JTable table;
	private JTable table_1;
         public JFrame frame;
      
	
	double total =0.0;

	/**
	 * Launch the application.
	 */
      /*  static CashButton cash = new CashButton();
        
	public void InitCashButton(CashButton cash){
            this.cash=cash;
        }*/

	/**
	 * Create the application.
	 */
	public MainPosInterface() {
		initialize();
             //   cash.InitMainPosInterface(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		Mframe = new JFrame();
		Mframe.getContentPane().setBackground(Color.LIGHT_GRAY);
		Mframe.setBounds(100, 100, 537, 463);
		Mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mframe.getContentPane().setLayout(null);
		Mframe.setSize(1300,730);
		Mframe.setContentPane(new JLabel(new ImageIcon("C:\\Users\\malva\\Desktop\\p\\bb\\natural.jpg")));
		
		
		Font font = new Font("Areal", Font.BOLD,15);
		
		DefaultListModel<OrderRecord> dlm;
		
		dlm = new DefaultListModel<>();
		
		  
	    

		double Total = 0;
		double Price = 0;
		
		JList list = new JList();
		
		list = new JList<>(dlm);
		
		list.setFont(font);
                
                
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {

		            // Double-click detected
		            int index = list.locationToIndex(evt.getPoint());
		            
		            list.getSelectedIndex();
		            
		            list.addMouseListener(
		                    new MouseAdapter(){
		                        public void mouseClicked(MouseEvent e){
		                              System.err.printf("\nmouseClicked\n"); 
		                        }
		                    }
		            );
		           
		            dlm.removeElement(dlm);
		            dlm.remove(list.getSelectedIndex());
		            
		        } else if (evt.getClickCount() == 3) {

		            // Triple-click detected
		            int index = list.locationToIndex(evt.getPoint());
		        }
		    }
		});
		
		
                
		
		list.setBounds(10, 11, 455, 538);
		Mframe.getContentPane().add(list);
		
		table = new JTable();
		table.setBounds(321, 113, -79, -66);
		Mframe.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(321, 239, 10, -110);
		Mframe.getContentPane().add(table_1);
		
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	System.out.println("Mouse moved");
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            // Double-click detected
		        	System.out.println("Mouse clicked = 2");
		            int index = list.locationToIndex(evt.getPoint());
		        } else if (evt.getClickCount() == 3) 
		        {

		            // Triple-click detected
		        	System.out.println("Mouse clicked = 3");
		            int index = list.locationToIndex(evt.getPoint());
		        }
		    }
		});
		
		
		
		
		JButton btnCaffeLatte = new JButton("CAFE LATTE");
		btnCaffeLatte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                     if(e.getSource() == btnCaffeLatte) {
					
					String name = " -------- Caffe Latte ------ ";
					double price = 11.75;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
			}
		});
		btnCaffeLatte.setBackground(Color.RED);
		btnCaffeLatte.setBounds(1136, 39, 122, 70);
		Mframe.getContentPane().add(btnCaffeLatte);
		
		JButton btnCash = new JButton("CASH");
		btnCash.setBackground(Color.DARK_GRAY);
		btnCash.setForeground(SystemColor.textHighlight);
		btnCash.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCash.setBounds(21, 599, 56, -195);
		Mframe.getContentPane().add(btnCash);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(387, 11, 122, 230);
		Mframe.getContentPane().add(separator);
		
		JButton btnAmericano = new JButton("AMERICANO");
		
		
		
		btnAmericano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                        if(e.getSource() == btnAmericano) {
					
					String name = " ---------- Americano --------- ";
					double price = 9.50;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
			
                        
				
				
			}
		});
		btnAmericano.setBackground(Color.RED);
		btnAmericano.setBounds(972, 39, 122, 70);
		Mframe.getContentPane().add(btnAmericano);
		
		JButton btnMeltSandwich = new JButton("MELT SANDWICH");
		
		
		
		
		btnMeltSandwich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                  if(e.getSource() == btnMeltSandwich) {
					
					String name = " ------ Melt Sandwich ------ ";
					double price = 8.50;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
				
				
			}
		});
		btnMeltSandwich.setBackground(Color.PINK);
		btnMeltSandwich.setBounds(804, 39, 122, 70);
		Mframe.getContentPane().add(btnMeltSandwich);
		
		JButton btnSpinachArtichoke = new JButton("SPINACH ARTICHOKE");
		btnSpinachArtichoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                      if(e.getSource() == btnSpinachArtichoke) {
					
					String name = " ---- Spinach Artichoke ---- ";
					double price = 7.00;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
			}
		});
		btnSpinachArtichoke.setBackground(Color.PINK);
		btnSpinachArtichoke.setBounds(648, 124, 122, 70);
		Mframe.getContentPane().add(btnSpinachArtichoke);
		
		JButton btnHamAndCheese = new JButton("HAM AND CHEESE ");
		btnHamAndCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                     if(e.getSource() == btnHamAndCheese) {
					
					String name = " ---- Ham And Cheese ---- ";
					double price = 8.25;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
				
			}
		});
		btnHamAndCheese.setBackground(Color.PINK);
		btnHamAndCheese.setBounds(648, 39, 122, 70);
		Mframe.getContentPane().add(btnHamAndCheese);
		
		JButton btnCappuccino = new JButton("CAPPUCCINO");
		btnCappuccino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                     if(e.getSource() == btnCappuccino) {
					
					String name = " -------- Cappuccino ------- ";
					double price = 11.50;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
					
					
				}
				
				
				
				
			}
		});
		btnCappuccino.setBackground(Color.RED);
		btnCappuccino.setBounds(1136, 381, 122, 70);
		Mframe.getContentPane().add(btnCappuccino);
		
		JButton btnCortado = new JButton("CORTADO");
		btnCortado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                      if(e.getSource() == btnCortado) {
					
					String name = " ---------- Cortado --------- ";
					double price = 8.75;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
			}
		});
		btnCortado.setBackground(Color.RED);
		btnCortado.setBounds(1136, 294, 122, 70);
		Mframe.getContentPane().add(btnCortado);
		
		JButton btnEspresso = new JButton("ESPRESSO");
		btnEspresso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                       if(e.getSource() == btnEspresso) {
					
					String name = " ---------- Espresso --------- ";
					double price = 8.25;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
				
			}
		});
		btnEspresso.setBackground(Color.RED);
		btnEspresso.setBounds(972, 124, 122, 70);
		Mframe.getContentPane().add(btnEspresso);
		
		JButton btnFlatWhite = new JButton("FLAT WHITE");
		btnFlatWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                     if(e.getSource() == btnFlatWhite) {
                    	 
					
					String name = " ------- Flat White ------- ";
					double price = 10.50;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
                      
                     
					
					dlm.addElement(r);
					
					
				}
				
				
				
				
			}
		});
		btnFlatWhite.setBackground(Color.RED);
		btnFlatWhite.setBounds(1136, 124, 122, 70);
		Mframe.getContentPane().add(btnFlatWhite);
		
		JButton btnMacchiato = new JButton("MACCHIATO");
		btnMacchiato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                     if(arg0.getSource() == btnMacchiato) {
					
					String name = " ---------- Macchiato --------- ";
					double price = 9.00;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					
					dlm.addElement(r);
					
				}
				
				
				
			}
		});
		btnMacchiato.setBackground(Color.RED);
		btnMacchiato.setBounds(972, 207, 122, 70);
		Mframe.getContentPane().add(btnMacchiato);
		
		JButton btnMocha = new JButton("MOCHA");
		btnMocha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btnMocha) {
					
					String name = " ---------- Mocha --------- ";
					double price = 12.50;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
			}
		});
		btnMocha.setBackground(Color.RED);
		btnMocha.setBounds(972, 381, 122, 70);
		Mframe.getContentPane().add(btnMocha);
		
		JButton btnFrappuccino = new JButton("FRAPPUCCINO");
		btnFrappuccino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                     if(e.getSource() == btnFrappuccino) {
					
					String name = " -------- Frappuccino ------- ";
					double price = 15.25;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
			}
			
			
		});
		btnFrappuccino.setBackground(Color.RED);
		btnFrappuccino.setBounds(1136, 207, 122, 70);
		Mframe.getContentPane().add(btnFrappuccino);
		
		JButton btnIrishCoffee = new JButton("IRISH COFFEE");
		btnIrishCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                      if(arg0.getSource() == btnIrishCoffee) {
					
					String name = " ---------- Irısh Coffee --------- ";
					double price = 15.75;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
				
			}
		});
		btnIrishCoffee.setBackground(Color.RED);
		btnIrishCoffee.setBounds(972, 294, 122, 70);
		Mframe.getContentPane().add(btnIrishCoffee);
		
		JButton btnIcedAmericano = new JButton("ICED AMERICANO");
		btnIcedAmericano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                    if(e.getSource() == btnIcedAmericano) {
					
					String name = " -------- Iced Americano ------- ";
					double price = 8.50;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
				
			}
		});
		btnIcedAmericano.setBackground(new Color(147, 112, 219));
		btnIcedAmericano.setBounds(972, 470, 122, 70);
		Mframe.getContentPane().add(btnIcedAmericano);
		
		JButton btnIcedLatte = new JButton("ICED LATTE");
		btnIcedLatte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                     if(e.getSource() == btnIcedLatte) {
					
					String name = " -------- Iced Latte ------- ";
					double price = 11.00;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
			}
		});
		btnIcedLatte.setBackground(new Color(147, 112, 219));
		btnIcedLatte.setBounds(1136, 470, 122, 70);
		Mframe.getContentPane().add(btnIcedLatte);
		
		JButton btnSausage = new JButton(" SAUSAGE SANDWICH");
		btnSausage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                    if(e.getSource() == btnSausage) {
					
					String name = " --- Sausage Sandwich --- ";
					double price = 9.75;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
				
				
			}
		});
		btnSausage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSausage.setBackground(Color.PINK);
		btnSausage.setBounds(501, 39, 122, 70);
		Mframe.getContentPane().add(btnSausage);
		
		JButton btnChipotleChicken = new JButton("CHIPOTLE CHICKEN");
		btnChipotleChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                     if(e.getSource() == btnChipotleChicken) {
					
					String name = " --- Chipotle Chicken ---- ";
					double price = 8.00;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
				
			}
		});
		btnChipotleChicken.setBackground(Color.PINK);
		btnChipotleChicken.setBounds(501, 124, 122, 70);
		Mframe.getContentPane().add(btnChipotleChicken);
		
		JButton btnFigaroClub = new JButton("FIGARO CLUB");
		btnFigaroClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                     if(e.getSource() == btnFigaroClub) {
					
					String name = " ---- Figaro Club ---- ";
					double price = 8.75;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
				
			}
		});
		btnFigaroClub.setBackground(Color.PINK);
		btnFigaroClub.setBounds(648, 207, 122, 70);
		Mframe.getContentPane().add(btnFigaroClub);
		
		JButton btnSmokedSalmon = new JButton("SMOKED SALMON");
		btnSmokedSalmon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                      if(e.getSource() == btnSmokedSalmon) {
					
					String name = " ---- Smoked Salmon ---- ";
					double price = 9.50;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
			}
		});
		btnSmokedSalmon.setBackground(Color.PINK);
		btnSmokedSalmon.setBounds(804, 294, 122, 70);
		Mframe.getContentPane().add(btnSmokedSalmon);
		
		JButton btnSalamiCheese = new JButton("SALAMI CHEESE");
		btnSalamiCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                     if(e.getSource() == btnSalamiCheese) {
					
					String name = " ------- Salami Cheese ------ ";
					double price = 9.00;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
				
			}
		});
		btnSalamiCheese.setBackground(Color.PINK);
		btnSalamiCheese.setBounds(804, 124, 122, 70);
		Mframe.getContentPane().add(btnSalamiCheese);
		
		JButton btnMozzarella = new JButton("MOZZARELLA");
		btnMozzarella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                    if(e.getSource() == btnMozzarella) {
					
					String name = " ------ Mozzarella ------- ";
					double price = 7.50;
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
					
					dlm.addElement(r);
					
				}
				
				
				
			}
		});
		btnMozzarella.setBackground(Color.PINK);
		btnMozzarella.setBounds(804, 207, 122, 70);
		Mframe.getContentPane().add(btnMozzarella);
		
		JButton btnChickenSandwich = new JButton("CHICKEN SANDWICH");
		btnChickenSandwich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                     if(e.getSource() == btnChickenSandwich) {
					
					String name = " --- Chicken Sandwich --- ";
					double price = 8.75;
				
					OrderRecord r = new OrderRecord(name,price);
					
					total += price;
				
					dlm.addElement(r);
					
				}
				
				
				
				
				
			}
		});
                
                
                
		btnChickenSandwich.setBackground(Color.PINK);
		btnChickenSandwich.setBounds(501, 207, 122, 70);
		Mframe.getContentPane().add(btnChickenSandwich);
		
			JButton btnNewButton = new JButton("CASH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CashButton cash = new CashButton();
                                
						
				cash.frame.setVisible(true);
                                
                                
				
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setBounds(10, 628, 144, 52);
                Mframe.getContentPane().add(btnNewButton);
		
		JButton btnCredit = new JButton("CREDIT");
		btnCredit.setBackground(new Color(135, 206, 235));
		btnCredit.setBounds(164, 628, 144, 52);
		Mframe.getContentPane().add(btnCredit);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				if(arg0.getSource()==btnCancel) {
			        dlm.removeAllElements();
				}
			}
	});
		btnCancel.setBackground(new Color(135, 206, 250));
		btnCancel.setBounds(321, 628, 144, 52);
		Mframe.getContentPane().add(btnCancel);
		
		
		JButton btnAdvancedOptions = new JButton("ADVANCED OPTIONS");
		btnAdvancedOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btnAdvancedOptions)
				{
					
					Systems logIn = new Systems();
                                        
                                        logIn.frmLoginSystem.setVisible(true);
                                        
					//ss.managerLoginpass(ss.txtName.getText(),ss.txtpass.getText());
				}
				/*	logInScreen = new managers_logInSystem();
				managers_logInSystem window = new managers_logInSystem();
				window.frame.setVisible(true);*/
					 
				
			}
		});
		btnAdvancedOptions.setBackground(new Color(128, 0, 0));
		btnAdvancedOptions.setBounds(1119, 636, 139, 44);
		Mframe.getContentPane().add(btnAdvancedOptions);
//		
//		JButton button = new JButton("ADVANCED OPTIONS");
//		button.setBackground(new Color(128, 0, 0));
//		button.setBounds(970, 636, 139, 44);
//		Mframe.getContentPane().add(button);
//		
//		JButton button_1 = new JButton("ADVANCED OPTIONS");
//		button_1.setBackground(new Color(128, 0, 0));
//		button_1.setBounds(821, 636, 139, 44);
//		Mframe.getContentPane().add(button_1);
		
		JButton btnTotal = new JButton("TOTAL");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(arg0.getSource() == btnTotal) {
					
					String name = null;
					double price = 00;
					
					
					
					
					
					OrderRecord t = new OrderRecord(total);
					
					t.toString1();
					
					
					
					dlm.addElement(t);
					
				}
				
				
				
			}
		});
		
		btnTotal.setBackground(new Color(135, 206, 235));
		btnTotal.setBounds(321, 565, 144, 52);
		Mframe.getContentPane().add(btnTotal);
	}

	@Override
	public int getDetail() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AbstractView getView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initUIEvent(String arg0, boolean arg1, boolean arg2, AbstractView arg3, int arg4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getBubbles() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCancelable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EventTarget getCurrentTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public short getEventPhase() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EventTarget getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTimeStamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initEvent(String arg0, boolean arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preventDefault() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopPropagation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getAltKey() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public short getButton() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getClientX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getClientY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getCtrlKey() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getMetaKey() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EventTarget getRelatedTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getScreenX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScreenY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getShiftKey() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initMouseEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, AbstractView viewArg,
			int detailArg, int screenXArg, int screenYArg, int clientXArg, int clientYArg, boolean ctrlKeyArg,
			boolean altKeyArg, boolean shiftKeyArg, boolean metaKeyArg, short buttonArg, EventTarget relatedTargetArg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
        

}