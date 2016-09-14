package gui.login;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class LoginMainframe extends JFrame {

	public LoginMainframe() {
		

		setUpFrame();
	}

	private void setUpFrame() {

		ImageIcon img = new ImageIcon(
				LoginMainframe.class.getResource("/img/code.png"));
		this.setIconImage(img.getImage());
		this.setTitle("CODING ENVIRONMENT SYSTEM");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(500, 253);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		Container c = new Container();
		c.add(new LoginMainPanel());
		this.add(c);
	}

}
