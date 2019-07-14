package module.act.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Data.BR_IFNO;
import SQLline.SQLserver;
import module.Research_BRIF;

public class ReservationIF implements ActionListener {
 SQLserver sqll;
 Connection con;
 Statement sta;
ResultSet rs;
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
			//在连接对象的基础上创建会话对象
	        sta=con.createStatement();
	        //写插入数据的SQL语句
	        String sql = "select BR_KSMC,BR_YSMC from T_BRIF";
	        rs=sta.executeQuery(sql); 
	        int i=0;
	        while(rs.next()) {
	        	tmp=new BR_IFNO(); 
	        	tmp.SetBR_KSMC(rs.getString(1));
	        	tmp.SetBR_YSMC(rs.getString(2));	        	
	        	br.add(tmp); 
	        }
	    }catch(SQLException ex) {
	      
	        }
	new Research_BRIF();
	}
 	
}
