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
public class CHOICE_KS extends JFrame implements ActionListener {
	 
	
	 
String s[];
String ss[][];
JComboBox jb1 ;
JComboBox jb2 ;
JButton button;
JPanel panel ;
String[] CHOICE_WORD;
send_jb2 jb;
public CHOICE_KS() {
	init();
	panel.add(jb1);
	panel.add(jb2);
	
	jb1.addActionListener(this);
	jb2.addActionListener(jb);
	this.getContentPane().add(panel);
	this.setBounds(100, 100, 300, 300);
	this.setDefaultCloseOperation(3);
	this.setVisible(true);
}

void init() {
	jb=new send_jb2();
	SEND_KS sendinfo_KS=new SEND_KS();
	SEND_BRIF br=new SEND_BRIF();  
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
	System.out.println(CHOICE_WORD[0]);
	}
}
class send_jb2 implements ActionListener{
	
	String tp;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox temp = (JComboBox) e.getSource();
		String tp = (String) temp.getSelectedItem();
		System.out.println(tp);
	}
	
}