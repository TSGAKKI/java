package module;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import module.act.*;
import module.act.Data.SEND_BRIF;


public class Reservation extends JFrame{
	CHOICE_KS KS;
	JButton button;
	JPanel panel;
	JComboBox jb1 ;
	JComboBox jb2 ;
	SEND_BRIF BR;
	String KSMC;
	String YSMC;
	

	
	 
	 public Reservation() {
		// TODO Auto-generated constructor stub
		 System.out.println();
		 init();
	
		 button.addActionListener(BR);
		 panel.add(jb1);
		 panel.add(jb2);
		this.getContentPane().add(panel);
		this.setBounds(100, 100, 300, 300);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);	
		add(button,BorderLayout.SOUTH);
	 }
	 
	 void init() {
		 
//		KSMC=KS.getCHOICE_WORD()[0];
//		YSMC=KS.getCHOICE_WORD()[1];
		 button=new JButton("ԤԼ");	 
		// BR.getIf("����", "001", KSMC, YSMC);
		 button.addActionListener(BR);
		 KS= new CHOICE_KS();
		 panel=new JPanel();
		 jb1= KS.getjb1_KS();
		 jb2=KS.getjb2_KS();
		
	 }
 }
