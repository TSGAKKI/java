package module;

import javax.swing.*;

import SQLline.Loginuser;
import SQLline.SQLserver;

import java.awt.*;   //�����Ҫ�İ�
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
  

  public class login extends JFrame implements ActionListener{
     JTextField jTextField ;//�����ı������
     JPasswordField jPasswordField;//������������
      JLabel jLabel1,jLabel2;
      JPanel jp1,jp2,jp3;
     JButton jb1,jb2; //������ť
     Connection con;
     String sqlStr="select id,password from T_LOGIN where "+"id = ? and password = ?";
     PreparedStatement presql;
    Loginuser log;
    boolean loginSuccess;
     
     public login(){
    	 log=new Loginuser();
    	 SQLserver sqlt= new SQLserver(); 
         jTextField = new JTextField(12);
        jPasswordField = new JPasswordField(13);
         jLabel1 = new JLabel("�û���");
         jLabel2 = new JLabel("����");
        jb1 = new JButton("ȷ��");
        jb2 = new JButton("ȡ��");
        jp1 = new JPanel();
        jp2 = new JPanel();
         jp3 = new JPanel();
         
         //���ò���
         this.setLayout(new GridLayout(3,1));
        
         jp1.add(jLabel1); 
         jp1.add(jTextField);//��һ����������û������ı��� 
         
         jp2.add(jLabel2);
         jp2.add(jPasswordField);//�ڶ������������������������
         
         jp3.add(jb1);
        jp3.add(jb2); //�������������ȷ�Ϻ�ȡ��
      jb1.addActionListener(this);
        //        jp3.setLayout(new FlowLayout());  ����//��ΪJPanelĬ�ϲ��ַ�ʽΪFlowLayout�����Կ���ע����δ���.
         this.add(jp1);
         this.add(jp2);
         this.add(jp3);  //������������ӵ���½������
         //������ʾ
         this.setSize(300, 200);
         //this.pack();
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
         this.setTitle("��½");
     }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		log.setID(jTextField.getText());
		System.out.println(log.getID());
		char[] pw=jPasswordField.getPassword();
		log.setPassWord(new String (pw));
		System.out.println(log.getPassWord());
		SQLserver sqls=new SQLserver();
		log=sqls.Verify(log);
		System.out.println("");
		loginSuccess=log.getLoginSuccess();
	}   
 }
  
