package module.act;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Data.KS;
import module.act.Data.SEND_BRIF;
import module.act.Data.SEND_KS;
public class CHOICE_KS implements ActionListener {
	 
	
	 
String s[];
String ss[][];
JComboBox jb1 ;
JComboBox jb2 ;
JButton button;
JPanel panel ;
 String[] CHOICE_WORD;
 SEND_BRIF br=new SEND_BRIF(); 
 
send_jb2 jb=new send_jb2();;

public CHOICE_KS() {
	
	init();
//	panel.add(jb1);
//	panel.add(jb2);
//	
	br.br.SetBR_KSMC(CHOICE_WORD[0]);
	br.br.SetBR_YSMC(CHOICE_WORD[1]);
	jb1.addActionListener(this);
	jb2.addActionListener(jb);
	
//	this.getContentPane().add(panel);
//	this.setBounds(100, 100, 300, 300);
//	this.setDefaultCloseOperation(3);
//	this.setVisible(true);
}

 public JComboBox getjb1_KS() {
	 return jb1;
 }

public JComboBox getjb2_KS() {
	 return jb2;
 }

public SEND_BRIF getCHOICE_IF() {
	System.out.println(CHOICE_WORD[0]);
	br.SetIf("¡ı¿⁄", "001",CHOICE_WORD[0] , CHOICE_WORD[1]);//∫Û–Ë–ﬁ∏ƒ
	return br;
}
void init() {
	SEND_KS sendinfo_KS=new SEND_KS();  
	CHOICE_WORD=new String[2]; 
	
	 
	 
	 KS[] ksinfo=sendinfo_KS.getksinfo();
	 
	s=new String[ksinfo.length];
	ss=new String[ksinfo.length][];
	String[] tmp;
	
	{for(int i=0;i<s.length;i++) {
		System.out.println(ksinfo[i].getKSMC());
		s[i]=ksinfo[i].getKSMC();
	}
	}
	
	{
		ArrayList<ArrayList<String>> save_data= sendinfo_KS.get_DOC();
		for (int i = 0; i < save_data.size(); i++) {
			tmp=new String[save_data.get(i).size()];
			{for (int j = 0; j <save_data.get(i).size(); j++) {
				tmp[j]=save_data.get(i).get(j);
			}
			ss[i]=tmp;
			}
		}
	}
	jb1 = new JComboBox(s);
	 jb2 = new JComboBox();
	 panel = new JPanel();
	
}

public void actionPerformed(ActionEvent e) {
	JComboBox temp = (JComboBox) e.getSource();
	String name = (String) temp.getSelectedItem();
	if(jb2.getItemCount()!=0){
		jb2.removeAllItems();
		jb2.updateUI();
		jb2.setSelectedItem("");
	}
	if(name.equals(s[0])){
		for(int i=0;i<ss[0].length;i++){
			jb2.addItem(ss[0][i]);
		}
	}
	else if(name.equals(s[1])){
		for(int i=0;i<ss[1].length;i++){
			jb2.addItem(ss[1][i]);
		}
	}
	else if(name.equals(s[2])){
		for(int i=0;i<ss[2].length;i++){
			jb2.addItem(ss[2][i]);
		}
	}
	
	CHOICE_WORD[0]=name;
	br.br.SetBR_KSMC(name);
	System.out.println(CHOICE_WORD[0]);
	}



class send_jb2 implements ActionListener{
	
	String tp;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox temp = (JComboBox) e.getSource();
		String tp = (String) temp.getSelectedItem();
		
		CHOICE_WORD[1]=tp;
		br.br.SetBR_YSMC(tp);
	}
	
	
	
}
}
