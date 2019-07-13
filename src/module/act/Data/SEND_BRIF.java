package module.act.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Data.BR_IFNO;
import SQLline.SQLserver;

public class SEND_BRIF implements ActionListener{
BR_IFNO br=new BR_IFNO();
SQLserver sql=new SQLserver();
Connection con=sql.getCon();

	void getIf( String NAME,String BYBH,String KSMC,String YSMC) {
		br.SetBR_NAME(NAME);
		br.SetBR_BYBH(BYBH);
		br.SetBR_KSMC(KSMC);
		br.SetBR_YSMC(YSMC);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
		//�����Ӷ���Ļ����ϴ����Ự����
        PreparedStatement stmt;
        //д�������ݵ�SQL���
        String sql = "insert into T_BRIF values(?,?,?,?)";
        
        stmt=con.prepareStatement(sql);
     
        stmt.setString(1,br.getBR_NAME());
        stmt.setString(2, br.getBR_BYBH());
        stmt.setString(3, br.getBR_KSMC());
        stmt.setString(4, br.getBR_YSMC());
        
        stmt.executeUpdate();
        //�رջỰ����
        stmt.close();
        //�ر����Ӷ���
        con.close();
    }catch(SQLException ex) {
        ex.printStackTrace();
        System.out.println("ʧ��");
        }
	}
}
