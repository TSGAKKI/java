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
	 String Name="外科";
	 String KSBH="002";
	 
 try {
	 
     
     //写插入数据的SQL语句
     String sql = "insert into T_DOC values(?,?,'','')";
     //执行插入数据的SQL语句，返回受影响的行数
     PreparedStatement stmt = con.prepareStatement(sql);
     //在连接对象的基础上创建会话对象
     
     stmt.setString(1, Name);
     stmt.setString(2, KSBH);
     
     int rs1 = stmt.executeUpdate();
     //关闭会话对象
     stmt.close();
     //关闭连接对象
     con.close();
   
     if(rs1>0) {
         System.out.println("插入成功");
     }
     else {
         System.out.println("插入失败");
     }
 }catch(SQLException ex) {
     ex.printStackTrace();
     System.out.println("失败");
     }
 }
}
