package module.act.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Data.BR_IFNO;
import SQLline.SQLserver;

public class SEND_BRIF implements ActionListener{
public BR_IFNO br=new BR_IFNO();
SQLserver sql=new SQLserver();
Connection con=sql.getCon();


	public	void SetIf( String NAME,String BYBH,String KSMC,String YSMC) {
		br.SetBR_NAME(NAME);
		br.SetBR_BYBH(BYBH);
		br.SetBR_KSMC(KSMC);
		br.SetBR_YSMC(YSMC);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
		//在连接对象的基础上创建会话对象
        PreparedStatement stmt;
        //写插入数据的SQL语句
        String sql = "insert into T_BRIF values(?,?,?)";
        
        stmt=con.prepareStatement(sql);
     
        stmt.setString(1,SQLserver.br.getNAME());
        //stmt.setString(2, br.getBR_BYBH());
        stmt.setString(2, br.getBR_KSMC());
        stmt.setString(3, br.getBR_YSMC());
//        stmt.setString(1,"刘磊");
//        stmt.setString(2, "001");
//        stmt.setString(3, "神经科");
//        stmt.setString(4, "刘XX");
        
        stmt.executeUpdate();
        //关闭会话对象
        stmt.close();
        //关闭连接对象
        
        JOptionPane.showMessageDialog(null, "预约成功","恭喜",JOptionPane.WARNING_MESSAGE);
    }catch(SQLException ex) {
//        ex.printStackTrace();
//        System.out.println("失败");
    	JOptionPane.showMessageDialog(null, "重复预约失败","错误",JOptionPane.WARNING_MESSAGE);
        }
	}
}
