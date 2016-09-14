package gui.ContestsPackage.contest.help;

import gui.CommonPackage.JBackgroundPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class HelpPanel extends JPanel {

	CardLayout cards;
	JPanel cardPanel;

	public HelpPanel() {

		cards = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cards);
		setUpPanel();
	}

	void setUpPanel() {
		setSize(550, 250);
		JPanel card1 = card1();
		JPanel card3 = card3();
		JPanel card4 = card4();
		JPanel card5 = card5();
		cardPanel.add(card1, "Card 1");
		cardPanel.add(card3, "Card 3");
		cardPanel.add(card4, "Card 4");
		cardPanel.add(card5, "Card 5");

		add(cardPanel);
		setLayout(new GridLayout(1, 1));
	}

	JPanel card1() {
		SpringLayout currentLayout;
		JPanel card1 = new JPanel();

		currentLayout = new SpringLayout();
		card1.setSize(550, 200);

		// Contest label
		JLabel contest_lbl = new JLabel("CODING ENVIRONMENT SYSTEM");
		contest_lbl.setForeground(Color.decode("#aaaaaa"));
		contest_lbl.setFont(new Font("SansSerif", Font.BOLD, 17));
		currentLayout.putConstraint(SpringLayout.EAST, contest_lbl, -125,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, contest_lbl, 20,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, contest_lbl, 15,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, contest_lbl, -155,
				SpringLayout.SOUTH, card1);
		card1.add(contest_lbl);

		JLabel desc = new JLabel(
				"<html>Coding Environment System is a desktop application for hosting contests, trainings and events for "
						+ "programmers. Our goal is to provide a platform for programmers to compete and have fun. "
						+ "Coding Environment System is a noncommercial organization operated by CES team. <br><br>"
						+ "This help guide will give you the description on how to use the software.</html>");
		desc.setForeground(Color.decode("#aaaaaa"));
		desc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, desc, 10,
				SpringLayout.SOUTH, contest_lbl);
		currentLayout.putConstraint(SpringLayout.EAST, desc, 0,
				SpringLayout.EAST, contest_lbl);
		currentLayout.putConstraint(SpringLayout.WEST, desc, 0,
				SpringLayout.WEST, contest_lbl);
		card1.add(desc);

		JButton button_create = new JButton("Next", new ImageIcon(
				HelpPanel.class.getResource("/img/go.png")));
		button_create.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_create.setHorizontalTextPosition(SwingConstants.CENTER);
		button_create.setFont(new Font("SanSerif", Font.BOLD, 15));
		button_create.setForeground(Color.decode("#aaaaaa"));
		button_create.setOpaque(true);
		button_create.setFocusPainted(false);
		button_create.setContentAreaFilled(false);
		button_create.setBorderPainted(false);
		button_create.setBorder(new EmptyBorder(10, 10, 10, 10));

		currentLayout.putConstraint(SpringLayout.EAST, button_create, 0,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, button_create, 450,
				SpringLayout.WEST, card1);
		card1.add(button_create);

		button_create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cards.next(cardPanel);

			}
		});
		JBackgroundPanel p = new JBackgroundPanel();
		currentLayout.putConstraint(SpringLayout.NORTH, button_create, 0,
				SpringLayout.NORTH, p);
		currentLayout.putConstraint(SpringLayout.SOUTH, button_create, 0,
				SpringLayout.SOUTH, p);
		currentLayout.putConstraint(SpringLayout.EAST, p, -100,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, p, 0, SpringLayout.WEST,
				this);
		currentLayout.putConstraint(SpringLayout.NORTH, p, 0,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, p, 0,
				SpringLayout.SOUTH, card1);
		card1.setBackground(Color.decode("#3c3f41"));
		card1.add(p);
		card1.setLayout(currentLayout);

		return card1;
	}

	JPanel card3() {
		SpringLayout currentLayout;
		JPanel card1 = new JPanel();

		currentLayout = new SpringLayout();
		card1.setSize(550, 200);

		// Name label
		JLabel lbl_name = new JLabel("CONTESTS");

		lbl_name.setBorder(new EmptyBorder(10, 0, 10, 10));
		lbl_name.setForeground(Color.decode("#aaaaaa"));
		lbl_name.setFont(new Font("SansSerif", Font.BOLD, 17));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name, -125,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name, 20,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name, 0,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name, -175,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name);
		/*
		 * <html>These type of contests are used to <br>" +
		 * "conduct tests. Here, students are required <br>" +
		 * "to know the question code to attempt any <br>" + "question.</html>
		 */
		JLabel test_mode = new JLabel(" TEST CONTESTS", new ImageIcon(
				HelpPanel.class.getResource("/img/testtypeicon.png")),
				SwingConstants.LEFT);
		test_mode.setForeground(Color.decode("#aaaaaa"));
		currentLayout.putConstraint(SpringLayout.NORTH, test_mode, 0,
				SpringLayout.SOUTH, lbl_name);
		currentLayout.putConstraint(SpringLayout.WEST, test_mode, 15,
				SpringLayout.WEST, card1);
		test_mode.setForeground(Color.decode("#aaaaaa"));
		test_mode.setFont(new Font("Tahoma", Font.PLAIN, 11));

		card1.add(test_mode);

		JLabel desc_test = new JLabel(
				"<html>These type of contests are used to "
						+ "conduct tests. Here, students are required "
						+ "to <br>know the question code to attempt any "
						+ "question.</html>");
		desc_test.setForeground(Color.decode("#aaaaaa"));
		desc_test.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, desc_test, 10,
				SpringLayout.SOUTH, test_mode);
		currentLayout.putConstraint(SpringLayout.WEST, desc_test, 40,
				SpringLayout.WEST, card1);
		card1.add(desc_test);
		/*
		 * "<html>These type of contests are used <br>" +
		 * "for practice. Here, students are <br>" +
		 * "free to solve any question <br>without knowing the question code.</html>"
		 */
		JLabel practice_mode = new JLabel(" PRACTICE CONTESTS", new ImageIcon(
				HelpPanel.class.getResource("/img/practicetypeicon.png")),
				SwingConstants.RIGHT);
		practice_mode.setForeground(Color.decode("#aaaaaa"));
		practice_mode.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, practice_mode, 10,
				SpringLayout.SOUTH, desc_test);
		currentLayout.putConstraint(SpringLayout.WEST, practice_mode, 15,
				SpringLayout.WEST, card1);

		card1.add(practice_mode);

		JLabel desc_prac = new JLabel(
				"<html>These type of contests are used "
						+ "for practice. Here, students are "
						+ "free to solve <br>any question without knowing the code.</html>");
		desc_prac.setForeground(Color.decode("#aaaaaa"));
		desc_prac.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, desc_prac, 10,
				SpringLayout.SOUTH, practice_mode);
		currentLayout.putConstraint(SpringLayout.WEST, desc_prac, 40,
				SpringLayout.WEST, card1);
		card1.add(desc_prac);

		JButton button_create = new JButton("Next", new ImageIcon(
				HelpPanel.class.getResource("/img/go.png")));
		button_create.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_create.setHorizontalTextPosition(SwingConstants.CENTER);
		button_create.setFont(new Font("SanSerif", Font.BOLD, 15));
		button_create.setForeground(Color.decode("#aaaaaa"));
		button_create.setOpaque(true);
		button_create.setFocusPainted(false);
		button_create.setContentAreaFilled(false);
		button_create.setBorderPainted(false);
		button_create.setBorder(new EmptyBorder(10, 10, 10, 10));

		currentLayout.putConstraint(SpringLayout.EAST, button_create, 0,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, button_create, 450,
				SpringLayout.WEST, card1);
		card1.add(button_create);

		button_create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cards.next(cardPanel);

			}
		});
		JBackgroundPanel p = new JBackgroundPanel();
		currentLayout.putConstraint(SpringLayout.NORTH, button_create, 0,
				SpringLayout.NORTH, p);
		currentLayout.putConstraint(SpringLayout.SOUTH, button_create, 0,
				SpringLayout.SOUTH, p);
		currentLayout.putConstraint(SpringLayout.EAST, p, -100,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, p, 0, SpringLayout.WEST,
				this);
		currentLayout.putConstraint(SpringLayout.NORTH, p, 0,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, p, 0,
				SpringLayout.SOUTH, card1);
		card1.setBackground(Color.decode("#3c3f41"));
		card1.add(p);
		card1.setLayout(currentLayout);

		return card1;
	}

	JPanel card4() {
		SpringLayout currentLayout;
		JPanel card1 = new JPanel();

		currentLayout = new SpringLayout();
		card1.setSize(550, 200);

		// Name label
		JLabel lbl_name = new JLabel("SUBMISSION");

		lbl_name.setBorder(new EmptyBorder(10, 0, 10, 10));
		lbl_name.setForeground(Color.decode("#aaaaaa"));
		lbl_name.setFont(new Font("SansSerif", Font.BOLD, 16));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name, -115,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name, 20,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name, 0,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name, -175,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name);

		JLabel lb_info = new JLabel(
				"<html><b><font size='3'>To submit a solution to any question, follow these steps:-</font></b>"
						+ "<br><br>(1) Select the question to which you want to submit the solution."
						+ "<br><br>(2) Select the language type for the program to be submitted."
						+ "<br><br>(3) Select the file from the browse button."
						+ "<br><br>(4) Submit the program and wait for the output.</html>");
		lb_info.setForeground(Color.decode("#aaaaaa"));
		lb_info.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, lb_info, 0,
				SpringLayout.SOUTH, lbl_name);
		currentLayout.putConstraint(SpringLayout.WEST, lb_info, 30,
				SpringLayout.WEST, card1);
		card1.add(lb_info);

		JButton button_create = new JButton("Next", new ImageIcon(
				HelpPanel.class.getResource("/img/go.png")));
		button_create.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_create.setHorizontalTextPosition(SwingConstants.CENTER);
		button_create.setFont(new Font("SanSerif", Font.BOLD, 15));
		button_create.setForeground(Color.decode("#aaaaaa"));
		button_create.setOpaque(true);
		button_create.setFocusPainted(false);
		button_create.setContentAreaFilled(false);
		button_create.setBorderPainted(false);
		button_create.setBorder(new EmptyBorder(10, 10, 10, 10));

		currentLayout.putConstraint(SpringLayout.EAST, button_create, 0,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, button_create, 450,
				SpringLayout.WEST, card1);
		card1.add(button_create);

		button_create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cards.next(cardPanel);

			}
		});
		JBackgroundPanel p = new JBackgroundPanel();
		currentLayout.putConstraint(SpringLayout.NORTH, button_create, 0,
				SpringLayout.NORTH, p);
		currentLayout.putConstraint(SpringLayout.SOUTH, button_create, 0,
				SpringLayout.SOUTH, p);
		currentLayout.putConstraint(SpringLayout.EAST, p, -100,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, p, 0, SpringLayout.WEST,
				this);
		currentLayout.putConstraint(SpringLayout.NORTH, p, 0,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, p, 0,
				SpringLayout.SOUTH, card1);
		card1.setBackground(Color.decode("#3c3f41"));
		card1.add(p);
		card1.setLayout(currentLayout);

		return card1;
	}

	JPanel card5() {
		SpringLayout currentLayout;
		JPanel card1 = new JPanel();

		currentLayout = new SpringLayout();
		card1.setSize(550, 200);

		// Name label
		JLabel lbl_name = new JLabel("MORE DETAILS");

		lbl_name.setBorder(new EmptyBorder(10, 0, 10, 10));
		lbl_name.setForeground(Color.decode("#aaaaaa"));
		lbl_name.setFont(new Font("SansSerif", Font.BOLD, 16));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name, -115,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name, 20,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name, 0,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name, -175,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name);

		JLabel desc = new JLabel(
				"<html>For more details, visit the Coding Environment System website<br><br>"
						+ "<center><a href='www.ces.smitshilu.in' style='color:#aaaaaa'>ces.smitshilu.in</a></center></html>",
				SwingConstants.CENTER);
		desc.setForeground(Color.decode("#aaaaaa"));
		desc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, desc, 10,
				SpringLayout.SOUTH, lbl_name);
		currentLayout.putConstraint(SpringLayout.EAST, desc, 0,
				SpringLayout.EAST, lbl_name);
		currentLayout.putConstraint(SpringLayout.WEST, desc, 0,
				SpringLayout.WEST, lbl_name);
		currentLayout.putConstraint(SpringLayout.SOUTH, desc, -40,
				SpringLayout.SOUTH, card1);
		desc.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(
							new URI("http://ces.smitshilu.in"));
				} catch (IOException e1) {

					e1.printStackTrace();
				} catch (URISyntaxException e1) {

					e1.printStackTrace();
				}

			}
		});

		card1.add(desc);

		JButton button_create = new JButton("Done", new ImageIcon(
				HelpPanel.class.getResource("/img/go.png")));
		button_create.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_create.setHorizontalTextPosition(SwingConstants.CENTER);
		button_create.setFont(new Font("SanSerif", Font.BOLD, 15));
		button_create.setForeground(Color.decode("#aaaaaa"));
		button_create.setOpaque(true);
		button_create.setFocusPainted(false);
		button_create.setContentAreaFilled(false);
		button_create.setBorderPainted(false);
		button_create.setBorder(new EmptyBorder(10, 10, 10, 10));

		currentLayout.putConstraint(SpringLayout.EAST, button_create, 0,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, button_create, 450,
				SpringLayout.WEST, card1);
		card1.add(button_create);

		button_create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame topFrame = (JFrame) SwingUtilities
						.getWindowAncestor(HelpPanel.this);
				topFrame.dispose();
			}
		});
		JBackgroundPanel p = new JBackgroundPanel();
		currentLayout.putConstraint(SpringLayout.NORTH, button_create, 0,
				SpringLayout.NORTH, p);
		currentLayout.putConstraint(SpringLayout.SOUTH, button_create, 0,
				SpringLayout.SOUTH, p);
		currentLayout.putConstraint(SpringLayout.EAST, p, -100,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, p, 0, SpringLayout.WEST,
				this);
		currentLayout.putConstraint(SpringLayout.NORTH, p, 0,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, p, 0,
				SpringLayout.SOUTH, card1);
		card1.setBackground(Color.decode("#3c3f41"));
		card1.add(p);
		card1.setLayout(currentLayout);

		return card1;
	}

}
