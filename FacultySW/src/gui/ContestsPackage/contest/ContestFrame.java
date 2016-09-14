package gui.ContestsPackage.contest;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ContestFrame extends JFrame {

	private ContestPanel currentPanel;

	public ContestFrame(String username) {

		currentPanel = new ContestPanel(username);
		setUpFrame();
	}

	private void setUpFrame() {

		this.setIconImage(new ImageIcon(ContestFrame.class
				.getResource("/img/code.png")).getImage());
		this.setTitle("CODING ENVIRONMENT SYSTEM");
		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getMaximumWindowBounds();
		setSize(r.getSize());
		this.setResizable(false);
		// this.setSize(1000, 600);
		// this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
		// / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(currentPanel);

	}

}
