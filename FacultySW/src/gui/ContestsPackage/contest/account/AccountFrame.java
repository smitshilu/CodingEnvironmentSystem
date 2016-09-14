package gui.ContestsPackage.contest.account;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AccountFrame extends JFrame {

	public AccountFrame() {
		setUpFrame();
	}

	private void setUpFrame() {
		ImageIcon img = new ImageIcon(
				AccountFrame.class.getResource("/img/code.png"));
		this.setIconImage(img.getImage());
		this.setTitle("CODING ENVIRONMENT SYSTEM");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(500, 500);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		this.setContentPane(new AccountPanel());
	}
}
