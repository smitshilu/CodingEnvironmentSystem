package gui.ContestsPackage.newcontest;

import gui.ContestsPackage.contest.GridLayoutContests;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class NewContestFrame extends JFrame {

	private NewContestPanel currentPanel;
	

	public NewContestFrame(GridLayoutContests cp) {
		
		currentPanel = new NewContestPanel(cp);

		setUpFrame();
	}

	private void setUpFrame() {

		ImageIcon img = new ImageIcon(
				NewContestFrame.class.getResource("/img/codeicon.png"));
		this.setIconImage(img.getImage());
		this.setTitle("CODING ENVIRONMENT SYSTEM");
		this.setResizable(false);
		//this.setType(JFrame.Type.UTILITY);
		this.setSize(550, 230);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container c = new Container();
		c.add(currentPanel);
		this.add(c);
	}

}
