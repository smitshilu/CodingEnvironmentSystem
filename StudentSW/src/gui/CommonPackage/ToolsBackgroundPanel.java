package gui.CommonPackage;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ToolsBackgroundPanel extends JPanel {
	private Image img;

	public ToolsBackgroundPanel() {

		try {
			img = (new ImageIcon(
					ToolsBackgroundPanel.class.getResource("/img/toolbar.png"))
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
