package module.act.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.KS;
import SQLline.SQLserver;



public class SEND_KS { 
	public SEND_KS() {
		send();
		// TODO Auto-generated constructor stub
	}
	
	KS[] ksinfo;
	 SQLserver sql=new SQLserver();
	 Connection con =sql.getCon();
	 ArrayList<ArrayList<String>> save_data=new ArrayList<>();
	 SEND_BRIF BRIF=new SEND_BRIF();
	public KS[] getksinfo() {
		return ksinfo; 
	}
	
	public ArrayList<ArrayList<String>> get_DOC(){
		return save_data;
	}
	
	void initar( KS[] k,int c) {
		{
			for(int i=0;i<c;i++) {
				k[i]=new KS();
			}
		}
	}
	
	
void send() {	
	try {
		
   //在连接对象的基础上创建会话对象
   Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
   //写插入数据的SQL语句
   String sql = "select * from T_KS";
   String select_Name="select * from T_DOC where "+"KSBH = ?";
   PreparedStatement KS_RName=con.prepareStatement(select_Name);
   
   //执行插入数据的SQL语句，返回受影响的行数
   ResultSet rs1 = stmt.executeQuery(sql);
  
   
   int column=0;
   
   while(rs1.next()) {
   	column++;
   }
   
   ksinfo=new KS[column];
   initar(ksinfo, column);
 rs1.absolute(0);
 int i=0;
   
   while(rs1.next()) {
   	ksinfo[i].setKSBH(rs1.getString("KSBH"));
   	ksinfo[i].setKSMC(rs1.getString("KSMC"));
   	ksinfo[i].setPYZS(rs1.getString("PYZS"));

   }
   {
   for (int j = 0; j < ksinfo.length; j++) {
		KS_RName.setString(1, ksinfo[j].getKSBH());
		rs1=KS_RName.executeQuery();//科室对应的医生
		ArrayList<String> tmp=new ArrayList<String>();
		while(rs1.next()) {
			tmp.add(rs1.getString("Name"));
			
		}
		save_data.add(tmp);
   }
   }
   
   //关闭会话对象
   KS_RName.close();
   stmt.close();
   //关闭连接对象
   con.close();
  
}catch(SQLException ex) {
   ex.printStackTrace();
   }
	}
}
