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
//	        //�����Ӷ���Ļ����ϴ����Ự����
//	        Statement stmt = con.createStatement();
//	        //д�������ݵ�SQL���
//	        String sql = "insert into T_LOGIN values('252','123')";
//	        //ִ�в������ݵ�SQL��䣬������Ӱ�������
//	        int rs1 = stmt.executeUpdate(sql);
//	        //�رջỰ����
//	        stmt.close();
//	        //�ر����Ӷ���
//	        con.close();
//	      
//	        if(rs1>0) {
//	            System.out.println("����ɹ�");
//	        }
//	        else {
//	            System.out.println("����ʧ��");
//	        }
//	    }catch(SQLException ex) {
//	        ex.printStackTrace();
//	        System.out.println("ʧ��");
//	        }
		try {
			presql=con.prepareStatement(sqlStr);
			
			System.out.println("Ѱ�ҳɹ�1");
			presql.setString(1, id);
			presql.setString(2, pw);
			System.out.println("Ѱ�ҳɹ�");
			try{
				rs=presql.executeQuery();
			}catch(Exception exx) {
				exx.printStackTrace();
			}
			System.out.println("Ѱ�ҳɹ�2");
			if(rs.next()==true) {
				loginModel.setLoginSuccess(true);
				System.out.println("Ѱ�ҳɹ�");
				JOptionPane.showMessageDialog(null, "��½�ɹ�","��ϲ",JOptionPane.WARNING_MESSAGE);
			}else {
				loginModel.setLoginSuccess(false);
				JOptionPane.showMessageDialog(null, "��½ʧ��","���µ�½",JOptionPane.WARNING_MESSAGE);
			}
			con.close();
		} catch (SQLException e) {}
		return loginModel;
	}
}

	
