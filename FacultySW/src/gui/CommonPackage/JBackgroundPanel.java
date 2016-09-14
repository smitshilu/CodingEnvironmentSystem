package gui.CommonPackage;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JBackgroundPanel extends JPanel {
	private Image img;

	public JBackgroundPanel() {

		try {
			img = (new ImageIcon(
					JBackgroundPanel.class.getResource("/img/background.png"))
					.getImage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}
