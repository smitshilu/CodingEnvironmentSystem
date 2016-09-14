package gui.login;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class LoginMainFrame extends JFrame {

	public LoginMainFrame() {

		setUpFrame();
	}

	private void setUpFrame() {

		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginMainFrame.class.getResource("/img/codeicon.png")));
		this.setTitle("Coding Environment System");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(499, 327);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		Container c = new Container();
		c.add(new LoginMainPanel());
		this.add(c);
	}
}
