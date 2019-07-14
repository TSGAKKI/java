package module.view.actview;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import module.act.*;
import module.act.Data.SEND_BRIF;
import module.view.PersonalSpaceView;


public class PersonalView extends JPanel{
	JTabbedPane p;
	Reservation Re;
	PersonalSpaceView ps;
	
	 public PersonalView() {
		// TODO Auto-generated constructor stub
		p=new JTabbedPane();
		Re= new Reservation();
		ps=new PersonalSpaceView();
		setLayout(new BorderLayout());
		p.add("个人中心", ps);
		p.addTab("预约", Re);
		p.validate();
		add(p,BorderLayout.CENTER);
	
	 }
 }
