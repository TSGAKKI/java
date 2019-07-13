package SQLline;



import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class RegisterData {
	SQLserver SQLline=new SQLserver();
	Connection con=SQLline.getCon();
	PreparedStatement preSql;
	
	public void writeRegister(Register register ) {
		String sqlStr="insert into T_LOGIN value (?,?,?)";
		int ok=0;
		try {
			preSql=con.prepareStatement(sqlStr);
			preSql.setString(1, register.getID());
			preSql.setString(2, register.getPassWord());
			preSql.setString(3, register.getBRBH());
			ok=preSql.executeUpdate();
			con.close();		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ID�����ظ�","����",JOptionPane.WARNING_MESSAGE);
			
		}
		if(ok!=0) {
			JOptionPane.showMessageDialog(null, "ע��ɹ�","��ϲ",JOptionPane.WARNING_MESSAGE);
		}
	}
}