package module;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import module.act.CHOICE_KS;
import module.act.send_jb2;

public class Reservation{
	 public Reservation() {
		// TODO Auto-generated constructor stub
	new CHOICE_KS();
	
	String s[];
	String ss[][];
	JComboBox jb1 ;
	JComboBox jb2 ;
	JButton button;
	JPanel panel ;
	
	
		init();
		panel.add(jb1);
		panel.add(jb2);
		
		jb1.addActionListener(this);
		jb2.addActionListener(jb);
		this.getContentPane().add(panel);
		this.setBounds(100, 100, 300, 300);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	
	
	 }
 }
