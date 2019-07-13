package SQLline;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SQLserver {
	
	String url="jdbc:sqlserver://localhost:1433;DatabaseName=test";
		private String user="sa";
		private String password="123456";
		private Connection con=null;
		private PreparedStatement presql;
		private ResultSet rs;
		
		
	 public SQLserver(){	
	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public Connection getCon() {
		 return con;
	 }
	public Loginuser Verify(Loginuser loginModel) {
		String id=loginModel.getID();
		String pw=loginModel.getPassWord();
		String sqlStr="select id,password from T_LOGIN where "+"id = ? and password = ?";
//				try {
//	        //在连接对象的基础上创建会话对象
//	        Statement stmt = con.createStatement();
//	        //写插入数据的SQL语句
//	        String sql = "insert into T_LOGIN values('252','123')";
//	        //执行插入数据的SQL语句，返回受影响的行数
//	        int rs1 = stmt.executeUpdate(sql);
//	        //关闭会话对象
//	        stmt.close();
//	        //关闭连接对象
//	        con.close();
//	      
//	        if(rs1>0) {
//	            System.out.println("插入成功");
//	        }
//	        else {
//	            System.out.println("插入失败");
//	        }
//	    }catch(SQLException ex) {
//	        ex.printStackTrace();
//	        System.out.println("失败");
//	        }
		try {
			presql=con.prepareStatement(sqlStr);
			
			System.out.println("寻找成功1");
			presql.setString(1, id);
			presql.setString(2, pw);
			System.out.println("寻找成功");
			try{
				rs=presql.executeQuery();
			}catch(Exception exx) {
				exx.printStackTrace();
			}
			System.out.println("寻找成功2");
			if(rs.next()==true) {
				loginModel.setLoginSuccess(true);
				System.out.println("寻找成功");
				JOptionPane.showMessageDialog(null, "登陆成功","恭喜",JOptionPane.WARNING_MESSAGE);
			}else {
				loginModel.setLoginSuccess(false);
				JOptionPane.showMessageDialog(null, "登陆失败","重新登陆",JOptionPane.WARNING_MESSAGE);
			}
			con.close();
		} catch (SQLException e) {}
		return loginModel;
	}
}

	
