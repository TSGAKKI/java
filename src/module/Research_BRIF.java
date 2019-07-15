package module;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.Query;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import Data.BR_IFNO;
import javafx.scene.control.ScrollPane;
import module.act.Data.*;

public class Research_BRIF extends JFrame implements ActionListener{
	String[][] content;
	String [] tableHead= {"预约科室","预约医生"};
	JTable table;
	
	
	public Research_BRIF() {
		
		// TODO Auto-generated constructor stub
		{for(int i=0 ; i<ReservationIF.br.size();i++) {
			
		System.out.print(ReservationIF.br.get(i).getBR_KSMC());
		System.out.println(ReservationIF.br.get(i).getBR_YSMC());
	}	
}
	

	table=new JTable(ReservationIF.record,ReservationIF.ColumnName);
		this.setTitle("预约信息");
	add(new JScrollPane(table));
	//System.out.println(ReservationIF.br.get(0).getBR_KSMC());
		setBounds(12, 100, 400, 200);
	
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	}
