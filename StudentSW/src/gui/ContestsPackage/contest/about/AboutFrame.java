package gui.ContestsPackage.contest.about;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AboutFrame extends JFrame {

	public AboutFrame() {
		setUpFrame();
	}

	private void setUpFrame() {
		ImageIcon img = new ImageIcon(
				AboutFrame.class.getResource("/img/code.png"));
		this.setIconImage(img.getImage());
		this.setTitle("About");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(370, 250);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		this.setContentPane(new AboutPanel());
	}
}
