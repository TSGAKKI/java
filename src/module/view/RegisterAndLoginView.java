package module.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import module.view.actview.RegisterView;
import module.view.actview.login;

public class RegisterAndLoginView extends JPanel {
	JTabbedPane p;
	RegisterView registerView;
	login logview;
	public RegisterAndLoginView() {
		registerView=new RegisterView();
		logview=new login();
		setLayout(new BorderLayout());
		p=new JTabbedPane();
		p.add("ע��",registerView);
		p.add("��½", logview);
		
		p.validate();
		add(p,BorderLayout.CENTER);
	}
	public boolean isLoginSuccess() {
		return logview.isLoginSuccess();
	}
}
