package module.act.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.BR_IFNO;
import SQLline.SQLserver;
import module.CastWin;
import module.Research_BRIF;
import module.SecurityView;

public class Cast  implements ActionListener{
	SQLserver sqll;
	 Connection con;
	 PreparedStatement sta;
	ResultSet rs;
	ResultSet rs1;
	public static String [] ColumnName;
	public static String [][] record;
	public static ArrayList<BR_IFNO> br;
	BR_IFNO tmp;
	 	public Cast() {
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
		        
		        for (int i = 0; i < ColumnName.length; i++) {
		        	ColumnName[i]=metaData.getColumnName(i+1);
		        	
				}
		        rs.last();
		        record=new String [rs.getRow()][columnCount];
		       
		        int i=0;
		        rs.beforeFirst();
		        
		        while(rs.next()) {
		        	for(int j=0;j<columnCount;j++) {
		        		record[i][j]=rs.getString(j+1);
		        		
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
	new CastWin();
		}
		
}
