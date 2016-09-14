package gui.ContestsPackage.contest.about;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AboutPanel extends JPanel {

	SpringLayout currentLayout = new SpringLayout();

	public AboutPanel() {

		setUpPanel();
	}

	void setUpPanel() {
		setLayout(currentLayout);
		setBackground(Color.decode("#3c3f41"));

		JLabel ces_img = new JLabel(new ImageIcon(
				AboutPanel.class.getResource("/img/jaricon.png")),
				SwingConstants.LEFT);
		ces_img.setFont(new Font("SanSerif", Font.BOLD, 15));
		ces_img.setForeground(Color.decode("#aaaaaa"));
		currentLayout.putConstraint(SpringLayout.NORTH, ces_img, 30,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, ces_img, 20,
				SpringLayout.WEST, this);

		add(ces_img);
		JPanel info = new JPanel(new GridLayout(0, 1));
		info.setOpaque(false);
		currentLayout.putConstraint(SpringLayout.NORTH, info, 0,
				SpringLayout.NORTH, ces_img);
		currentLayout.putConstraint(SpringLayout.WEST, info, 20,
				SpringLayout.EAST, ces_img);
		currentLayout.putConstraint(SpringLayout.SOUTH, info, 0,
				SpringLayout.SOUTH, ces_img);
		currentLayout.putConstraint(SpringLayout.EAST, info, -20,
				SpringLayout.EAST, this);
		add(info);

		JLabel name = new JLabel("CODING ENVIRONMENT SYSTEM");

		name.setFont(new Font("SanSerif", Font.BOLD, 15));
		name.setForeground(Color.decode("#aaaaaa"));
		currentLayout.putConstraint(SpringLayout.NORTH, name, 10,
				SpringLayout.NORTH, ces_img);
		currentLayout.putConstraint(SpringLayout.WEST, name, 0,
				SpringLayout.EAST, ces_img);

		info.add(name);

		JLabel version_no = new JLabel("CES Version: 1.1.0");
		version_no.setFont(new Font("SanSerif", Font.BOLD, 12));
		version_no.setForeground(Color.decode("#aaaaaa"));
		currentLayout.putConstraint(SpringLayout.NORTH, version_no, 10,
				SpringLayout.NORTH, ces_img);
		currentLayout.putConstraint(SpringLayout.WEST, version_no, 0,
				SpringLayout.EAST, ces_img);

		info.add(version_no);

		JLabel website_link = new JLabel("<html>Visit: <a href='ces.smitshilu.in' style='color:#aaaaaa'>ces.smitshilu.in</a></html>");
		website_link.setFont(new Font("SanSerif", Font.BOLD, 12));
		website_link.setForeground(Color.decode("#aaaaaa"));
		currentLayout.putConstraint(SpringLayout.NORTH, website_link, 10,
				SpringLayout.SOUTH, version_no);
		currentLayout.putConstraint(SpringLayout.WEST, website_link, 0,
				SpringLayout.WEST, version_no);
		currentLayout.putConstraint(SpringLayout.EAST, website_link, 0,
				SpringLayout.EAST, version_no);
		info.add(website_link);

		JLabel dev_by = new JLabel("Developed by:");
		dev_by.setFont(new Font("SanSerif", Font.BOLD, 12));
		dev_by.setForeground(Color.decode("#aaaaaa"));
		currentLayout.putConstraint(SpringLayout.NORTH, dev_by, 30,
				SpringLayout.SOUTH, website_link);
		currentLayout.putConstraint(SpringLayout.WEST, dev_by, 0,
				SpringLayout.WEST, ces_img);
		currentLayout.putConstraint(SpringLayout.EAST, dev_by, 0,
				SpringLayout.EAST, website_link);
		add(dev_by);

		JPanel madeby = new JPanel(new GridLayout(1, 2));
		currentLayout.putConstraint(SpringLayout.NORTH, madeby, 10,
				SpringLayout.SOUTH, dev_by);
		currentLayout.putConstraint(SpringLayout.WEST, madeby, 0,
				SpringLayout.WEST, ces_img);
		currentLayout.putConstraint(SpringLayout.EAST, madeby, 0,
				SpringLayout.EAST, info);
		madeby.setOpaque(false);

		JLabel dev1 = new JLabel("<html>CHINTAN TRIVEDI<br>  11CE117</html>", new ImageIcon(
				AboutPanel.class.getResource("/img/Chintan.png")),
				SwingConstants.LEFT);
		dev1.setForeground(Color.decode("#aaaaaa"));
		madeby.add(dev1);

		JLabel dev2 = new JLabel("<html>SMIT SHILU<br>  11CE109</html>", new ImageIcon(
				AboutPanel.class.getResource("/img/Smit.png")),
				SwingConstants.LEFT);
		dev2.setForeground(Color.decode("#aaaaaa"));
		madeby.add(dev2);

		add(madeby);

	}
}
