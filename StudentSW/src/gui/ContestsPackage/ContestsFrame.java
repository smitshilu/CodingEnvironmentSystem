package gui.ContestsPackage;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ContestsFrame extends JFrame {

	private ContestsPanel currentPanel;

	public ContestsFrame(String username) {

		currentPanel = new ContestsPanel(username);

		setUpFrame();
	}

	private void setUpFrame() {

		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ContestsFrame.class.getResource("/img/codeicon.png")));
		this.setTitle("CODING ENVIRONMENT SYSTEM");
		Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getMaximumWindowBounds();
		setSize(r.getSize());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(currentPanel);

	}
}
