package module;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import SQLline.SQLserver;
import javafx.scene.control.Button;
//import module.act.Data.ReservationIF;
import module.act.Data.ReservationIF;




public class PersonalSpaceView extends JPanel {
JButton button_Re;
JButton button_Pi;
JButton button_Se;
SQLserver sql;


Box boxV;
public PersonalSpaceView() {
	ReservationIF Re_IF= new ReservationIF();
	boxV= Box.createVerticalBox();
	
	
	
	button_Re=new JButton("ԤԼ��¼");
	button_Se=new JButton("�˻���ȫ");
	button_Re.addActionListener(Re_IF);
	boxV.add(new JLabel("�û�ID: "+sql.br.getNAME()));
	boxV.add(boxV.createVerticalStrut(10));
	boxV.add(button_Re);
	boxV.add(boxV.createVerticalStrut(10));
	boxV.add(button_Se);
	add(boxV);
}
}
