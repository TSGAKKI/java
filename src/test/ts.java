package test;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.KS;
import SQLline.SQLserver;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class ts implements ActionListener{
	JComboBox<String> jBox;
public ts() {
	jBox=new JComboBox<String>();
	jBox.addItem("�����û�");
	jBox.addItem("����Ա");
	jBox.addItem("��ͨ�û�");
	jBox.addActionListener(this);
	JFrame jf=new JFrame("����");
	JPanel jp=new JPanel();
	jp.add(jBox);
	jf.add(jp);
	jf.setBounds(200, 100, 300, 400);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[]args){
	new ts();
}
@Override
public void actionPerformed(ActionEvent e) {
	int i=jBox.getSelectedIndex()+1;
	String s=(String)jBox.getSelectedItem();
	
	// ��i���������ݿ��ж�Ӧ�������ֶ�
	
}
}



