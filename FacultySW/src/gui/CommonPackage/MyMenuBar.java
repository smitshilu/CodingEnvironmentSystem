package gui.CommonPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class MyMenuBar extends JMenuBar {
	String color = "#2b2e30";

	public MyMenuBar(String color) {
		this.color = color;
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.decode(color));
		g2d.fillRect(0, 0, getWidth(), getHeight()-1);
		
		g2d.setColor(Color.decode("#555555"));
		g2d.fillRect(0, getHeight()-1, getWidth(),1);
		
		
	}

}