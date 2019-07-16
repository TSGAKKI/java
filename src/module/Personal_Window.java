package module;

import javax.swing.JFrame;

public class Personal_Window extends JFrame{
	PersonalView pv;
	public Personal_Window() {
		// TODO Auto-generated constructor stub
		setBounds(100,100,400,400);
		pv=new PersonalView();
		add(pv);
		setTitle("∏ˆ»À“≥√Ê");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
