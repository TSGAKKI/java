package module;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.Query;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import Data.BR_IFNO;
import javafx.scene.control.ScrollPane;
import module.act.Data.*;

public class Research_BRIF extends JFrame implements ActionListener{
	SEND_RE_DElE del;
	JTable table;
	JButton button;
	JButton refresh;
	Box boxV;
	Box boxH;
	String KSMC;
	String YSMC;
	public Research_BRIF() {
		del=new SEND_RE_DElE();
		// TODO Auto-generated constructor stub
		boxV=Box.createVerticalBox();
		boxH=boxH.createHorizontalBox();
		button=new JButton("选择行取消预约");
		refresh=new JButton("刷新");
	table=new JTable(ReservationIF.record,ReservationIF.ColumnName);
		this.setTitle("预约信息");
		boxH.add(button);
		boxH.add(boxH.createHorizontalStrut(10));
		boxH.add(refresh);
		refresh.addActionListener(new ReservationIF());
		button.addActionListener(this);
		boxV.add(new JScrollPane(table));
		boxV.add(boxV.createVerticalStrut(10));
		boxV.add(boxH);
		
		
		add(boxV,BorderLayout.CENTER);
	
		setBounds(12, 100, 400, 200);
	
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int Column=table.getSelectedRow();
		if(Column==-1) {
			JOptionPane.showMessageDialog(null, "请选择一行","!",JOptionPane.WARNING_MESSAGE);
		}else {
			
		KSMC=ReservationIF.record[Column][0];
		YSMC=ReservationIF.record[Column][1];
		del.Delete(KSMC, YSMC);
		 JOptionPane.showMessageDialog(null, "成功删除","!",JOptionPane.WARNING_MESSAGE);}
	}
	


}


