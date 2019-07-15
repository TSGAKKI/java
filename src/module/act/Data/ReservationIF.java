package module.act.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Data.BR_IFNO;
import SQLline.SQLserver;
import javafx.application.Application;
import module.Research_BRIF;

public class ReservationIF implements ActionListener {
 SQLserver sqll;
 Connection con;
 PreparedStatement sta;
ResultSet rs;
ResultSet rs1;
public static String [] ColumnName;
public static String [][] record;
public static ArrayList<BR_IFNO> br;
BR_IFNO tmp;
 	public ReservationIF() {
		// TODO Auto-generated constructor stub
	sqll=new SQLserver();
	con=sqll.getCon();
 	}
 	
 	
 	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		br=new ArrayList<BR_IFNO>();
		try {
			
	        String sql = "select BR_KSMC,BR_YSMC from T_BRIF "+" where BR_NAME = ?";
	       
	        sta=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	         sta.setString(1, SQLserver.br.getNAME());
	        
	         rs=sta.executeQuery(); 
	        
	        
	        ResultSetMetaData metaData=rs.getMetaData();
	        int columnCount=metaData.getColumnCount();
	        ColumnName=new String[columnCount];
	        System.out.println("huode");
	        for (int i = 0; i < ColumnName.length; i++) {
	        	ColumnName[i]=metaData.getColumnName(i+1);
	        	System.out.println(ColumnName[i]);
			}
	        rs.last();
	        record=new String [rs.getRow()][columnCount];
	        System.out.println(rs.getRow());
	        int i=0;
	        rs.beforeFirst();
	        
	        while(rs.next()) {
	        	for(int j=0;j<columnCount;j++) {
	        		record[i][j]=rs.getString(j+1);
	        		System.out.println(record[i][j]);
	        	}
	        	i++;
	        	
	        	tmp=new BR_IFNO(); 
	        	tmp.SetBR_KSMC(rs.getString(1));
	        	tmp.SetBR_YSMC(rs.getString(2));	        	
	        	br.add(tmp); 
	        	 
	        }
	    }catch(SQLException ex) {
	      ex.getStackTrace();
	        }
		
		new Research_BRIF();
	}
 	
}
