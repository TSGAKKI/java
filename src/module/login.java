package module;

import javax.swing.*;

import SQLline.Loginuser;
import SQLline.SQLserver;

import java.awt.*;   //导入必要的包
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
  

  public class login extends JFrame implements ActionListener{
     JTextField jTextField ;//定义文本框组件
     JPasswordField jPasswordField;//定义密码框组件
      JLabel jLabel1,jLabel2;
      JPanel jp1,jp2,jp3;
     JButton jb1,jb2; //创建按钮
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
         jLabel1 = new JLabel("用户名");
         jLabel2 = new JLabel("密码");
        jb1 = new JButton("确认");
        jb2 = new JButton("取消");
        jp1 = new JPanel();
        jp2 = new JPanel();
         jp3 = new JPanel();
         
         //设置布局
         this.setLayout(new GridLayout(3,1));
        
         jp1.add(jLabel1); 
         jp1.add(jTextField);//第一块面板添加用户名和文本框 
         
         jp2.add(jLabel2);
         jp2.add(jPasswordField);//第二块面板添加密码和密码输入框
         
         jp3.add(jb1);
        jp3.add(jb2); //第三块面板添加确认和取消
      jb1.addActionListener(this);
        //        jp3.setLayout(new FlowLayout());  　　//因为JPanel默认布局方式为FlowLayout，所以可以注销这段代码.
         this.add(jp1);
         this.add(jp2);
         this.add(jp3);  //将三块面板添加到登陆框上面
         //设置显示
         this.setSize(300, 200);
         //this.pack();
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
         this.setTitle("登陆");
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
  

