package gui.ContestsPackage.editcontest;

import gui.ContestsPackage.contest.GridLayoutContests;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class EditContestFrame extends JFrame {

	private EditContestPanel currentPanel;
	

	public EditContestFrame(GridLayoutContests cp,String oldName) {
		
		currentPanel = new EditContestPanel(cp,oldName);

		setUpFrame();
	}

	private void setUpFrame() {

		ImageIcon img = new ImageIcon(
				EditContestFrame.class.getResource("/img/codeicon.png"));
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
