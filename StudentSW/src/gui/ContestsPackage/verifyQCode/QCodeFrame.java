package gui.ContestsPackage.verifyQCode;

import gui.ContestsPackage.ContestsPanel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class QCodeFrame extends JFrame {

	private QCodePanel currentPanel;

	public QCodeFrame(ContestsPanel cp, String username, String contestname) {

		currentPanel = new QCodePanel(cp, username, contestname);

		setUpFrame();
	}

	private void setUpFrame() {

		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(QCodeFrame.class.getResource("/img/codeicon.png")));
		this.setTitle("CODING ENVIRONMENT SYSTEM");
		this.setResizable(false);
		// this.setType(JFrame.Type.UTILITY);
		this.setSize(550, 230);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container c = new Container();
		c.add(currentPanel);
		getContentPane().add(c);
	}

}
