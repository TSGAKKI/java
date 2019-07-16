package module;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class CastWin extends JFrame {
	public CastWin() {
		// TODO Auto-generated constructor stub
		add(new SecurityView(),BorderLayout.CENTER);
		setBounds(100, 100, 200, 400);
		setTitle("Ô¤Ô¼½É·Ñ");
		setVisible(true);
	}
}
