package module;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Data.doc;
import SQLline.SQLserver;

public class upda {
 doc Do;
 SQLserver sqls;
 Connection con;
 
 
 upda(){
	 Do=new doc();
	 sqls=new SQLserver();
	 con=sqls.getCon();
 }
 void up() {
	 String Name="���";
	 String KSBH="002";
	 
 try {
	 
     
     //д�������ݵ�SQL���
     String sql = "insert into T_DOC values(?,?,'','')";
     //ִ�в������ݵ�SQL��䣬������Ӱ�������
     PreparedStatement stmt = con.prepareStatement(sql);
     //�����Ӷ���Ļ����ϴ����Ự����
     
     stmt.setString(1, Name);
     stmt.setString(2, KSBH);
     
     int rs1 = stmt.executeUpdate();
     //�رջỰ����
     stmt.close();
     //�ر����Ӷ���
     con.close();
   
     if(rs1>0) {
         System.out.println("����ɹ�");
     }
     else {
         System.out.println("����ʧ��");
     }
 }catch(SQLException ex) {
     ex.printStackTrace();
     System.out.println("ʧ��");
     }
 }
}
