package module;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Data.BR_IFNO;
import SQLline.SQLserver;
import module.*;
import module.act.Data.Cast;
import module.act.Data.ReservationIF;


public class SecurityView extends JPanel {
String[][] cas= {
		{"内科      ","20"},{"神经内科  ","45"},{"耳鼻喉科  ","30"}	
};
int sum=0;
int j=0;

	public SecurityView() {
		Box boxV=Box.createVerticalBox();
		boxV.add(new JLabel("预约缴费信息"),BorderLayout.SOUTH);
		boxV.add(boxV.createVerticalStrut(10));
		
		
			
		for(int i=0;i<Cast.record.length;i++) {
			for( j=0;j<3;j++) {
				
				if(cas[j][0].equals(Cast.record[i][0])) {
					break;
					}
			}
				sum+=Integer.parseInt(cas[j][1]);
				boxV.add(new JLabel(Cast.record[i][0]+" "+Cast.record[i][1]+" "+cas[j][1]));
				boxV.add(boxV.createVerticalStrut(20));
			}boxV.add(new JLabel("所需缴费"+sum+""));
		add(boxV);

		
	}
	 	
}
