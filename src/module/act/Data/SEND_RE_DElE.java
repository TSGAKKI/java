package module.act.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SQLline.SQLserver;

public class SEND_RE_DElE {
	SQLserver sql=new SQLserver();
	Connection con;
	PreparedStatement presql;
	String KSMC;
	String YSMC;
	public SEND_RE_DElE() {
		// TODO Auto-generated constructor stub
	con=sql.getCon();
	}
	public void Delete(String KSMC,String YSMC ) {
		String sqlstr="delete from T_BRIF WHERE"+" BR_KSMC = ? AND BR_YSMC = ?";
		ResultSet rs;
		try {
			presql=con.prepareStatement(sqlstr);
			presql.setString(1, KSMC);
			presql.setString(2, YSMC);
			presql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
