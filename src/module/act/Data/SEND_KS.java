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
		
   //�����Ӷ���Ļ����ϴ����Ự����
   Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
   //д�������ݵ�SQL���
   String sql = "select * from T_KS";
   String select_Name="select * from T_DOC where "+"KSBH = ?";
   PreparedStatement KS_RName=con.prepareStatement(select_Name);
   
   //ִ�в������ݵ�SQL��䣬������Ӱ�������
   ResultSet rs1 = stmt.executeQuery(sql);
   //ResultSet rs2 =KS_RName.executeQuery(select_Name);
   
   int column=0;
   //System.out.println(column);
   while(rs1.next()) {
   	column++;
   }
   
   ksinfo=new KS[column];
   initar(ksinfo, column);
 rs1.absolute(0);
 int i=0;
   
   while(rs1.next()) {
   	// System.out.println(rs1.getString("KSBH"));
   	ksinfo[i].setKSBH(rs1.getString("KSBH"));
   	ksinfo[i].setKSMC(rs1.getString("KSMC"));
   	ksinfo[i].setPYZS(rs1.getString("PYZS"));
   	
   	i++;
   }
   {
   for (int j = 0; j < ksinfo.length; j++) {
		KS_RName.setString(1, ksinfo[j].getKSBH());
		rs1=KS_RName.executeQuery();//���Ҷ�Ӧ��ҽ��
		ArrayList<String> tmp=new ArrayList<String>();
		while(rs1.next()) {
			tmp.add(rs1.getString("Name"));
			
		}
		save_data.add(tmp);
   }
   }
   
   //�رջỰ����
   KS_RName.close();
   stmt.close();
   //�ر����Ӷ���
   con.close();
 
   
}catch(SQLException ex) {
   ex.printStackTrace();
 
   }
	}
}
