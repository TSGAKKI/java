package module;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import module.act.*;
import module.act.Data.SEND_BRIF;


public class Reservation extends JPanel{
	CHOICE_KS KS;
	JButton button;
	
	JComboBox jb1 ;
	JComboBox jb2 ;
	SEND_BRIF BR;
	String KSMC;
	String YSMC;
	
	 public Reservation() {
		// TODO Auto-generated constructor stub
		 System.out.println();
		 init();
		 
		 add(jb1);
		 add(jb2);
		 button.addActionListener(KS.getCHOICE_IF());
		add(button,BorderLayout.SOUTH);
	 }
	 
	 void init() {
		 
		 button=new JButton("ԤԼ");	 				
		 KS= new CHOICE_KS();
		 
		 jb1= KS.getjb1_KS();
		 jb2=KS.getjb2_KS();
		
	 }
 }
