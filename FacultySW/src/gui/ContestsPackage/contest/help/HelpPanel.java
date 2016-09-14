package gui.ContestsPackage.contest.help;

import gui.CommonPackage.JBackgroundPanel;
import gui.QuestionsPackage.questions.NewQuestionAddedListener;

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
		JPanel card2 = card2();
		JPanel card3 = card3();
		JPanel card4 = card4();
		JPanel card5 = card5();
		cardPanel.add(card1, "Card 1");
		cardPanel.add(card2, "Card 2");
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

	JPanel card2() {
		SpringLayout currentLayout;
		JPanel card1 = new JPanel();

		currentLayout = new SpringLayout();
		card1.setSize(550, 200);

		// Name label
		JLabel lbl_name = new JLabel("SERVER");

		lbl_name.setBorder(new EmptyBorder(10, 0, 10, 10));
		lbl_name.setForeground(Color.decode("#aaaaaa"));
		lbl_name.setFont(new Font("SansSerif", Font.BOLD, 17));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name, -125,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name, 20,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name, 15,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name, -155,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name);

		JLabel server_online = new JLabel(new ImageIcon(
				HelpPanel.class.getResource("/img/serverisonline.png")));
		currentLayout.putConstraint(SpringLayout.NORTH, server_online, 10,
				SpringLayout.SOUTH, lbl_name);
		currentLayout.putConstraint(SpringLayout.WEST, server_online, 10,
				SpringLayout.WEST, card1);
		card1.add(server_online);

		JLabel server_offline = new JLabel(
				"<html>Use this toggle button to start the "
						+ "CES server to allow students <br>to login and submit solutions. "
						+ "Keep it offline to prevent students <br>"
						+ "from logging in. Make "
						+ "sure WAMP server is also online alongside <br>"
						+ "with this server.</html>",
				new ImageIcon(HelpPanel.class
						.getResource("/img/serverisoffline.png")),
				SwingConstants.RIGHT);
		server_offline.setForeground(Color.decode("#aaaaaa"));
		server_offline.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, server_offline, 0,
				SpringLayout.NORTH, server_online);
		currentLayout.putConstraint(SpringLayout.WEST, server_offline, 0,
				SpringLayout.EAST, server_online);
		card1.add(server_offline);

		JLabel ip_info = new JLabel("<html>The IP address shown below this"
				+ " icon is the IP that must be entered by the students during"
				+ " login to connect to the server.</html>");
		ip_info.setForeground(Color.decode("#aaaaaa"));
		ip_info.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, ip_info, 10,
				SpringLayout.SOUTH, server_online);
		currentLayout.putConstraint(SpringLayout.WEST, ip_info, 10,
				SpringLayout.WEST, server_online);
		currentLayout.putConstraint(SpringLayout.EAST, ip_info, 10,
				SpringLayout.EAST, server_offline);
		card1.add(ip_info);

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

		JLabel contest_icon = new JLabel(
				"<html>Use this button to create a new <br>Contest.</html>",
				new ImageIcon(HelpPanel.class.getResource("/img/table.png")),
				SwingConstants.RIGHT);
		contest_icon.setForeground(Color.decode("#aaaaaa"));
		contest_icon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, contest_icon, 0,
				SpringLayout.SOUTH, lbl_name);
		currentLayout.putConstraint(SpringLayout.WEST, contest_icon, -5,
				SpringLayout.WEST, lbl_name);

		card1.add(contest_icon);

		JLabel question_icon = new JLabel(
				"<html>Use this button to add <br>questions to contests.</html>",
				new ImageIcon(HelpPanel.class.getResource("/img/addicon.png")),
				SwingConstants.RIGHT);
		question_icon.setForeground(Color.decode("#aaaaaa"));
		question_icon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, question_icon, 0,
				SpringLayout.NORTH, contest_icon);
		currentLayout.putConstraint(SpringLayout.SOUTH, question_icon, 0,
				SpringLayout.SOUTH, contest_icon);
		currentLayout.putConstraint(SpringLayout.WEST, question_icon, 50,
				SpringLayout.EAST, contest_icon);

		card1.add(question_icon);

		JLabel online_icon = new JLabel(
				"<html>Online contests are visible to students.<br>Right click on contest to toggle this mode.",
				new ImageIcon(HelpPanel.class
						.getResource("/img/table_accept.png")),
				SwingConstants.RIGHT);
		online_icon.setForeground(Color.decode("#aaaaaa"));
		online_icon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, online_icon, 10,
				SpringLayout.SOUTH, contest_icon);
		currentLayout.putConstraint(SpringLayout.WEST, online_icon, 0,
				SpringLayout.WEST, contest_icon);

		card1.add(online_icon);

		JLabel offline_icon = new JLabel(
				"<html>Offline contests are not visible<br> to students. ",
				new ImageIcon(HelpPanel.class
						.getResource("/img/table_delete2.png")),
				SwingConstants.RIGHT);
		offline_icon.setForeground(Color.decode("#aaaaaa"));
		offline_icon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, offline_icon, 0,
				SpringLayout.NORTH, online_icon);
		currentLayout.putConstraint(SpringLayout.SOUTH, offline_icon, 0,
				SpringLayout.SOUTH, online_icon);
		currentLayout.putConstraint(SpringLayout.WEST, offline_icon, 5,
				SpringLayout.EAST, online_icon);

		card1.add(offline_icon);

		JLabel test_mode = new JLabel(
				"<html>These type of contests are used to <br>"
						+ "conduct tests. Here, students are required <br>"
						+ "to know the question code to attempt any <br>"
						+ "question.</html>", new ImageIcon(
						HelpPanel.class.getResource("/img/testtypeicon.png")),
				SwingConstants.RIGHT);
		test_mode.setForeground(Color.decode("#aaaaaa"));
		test_mode.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, test_mode, 10,
				SpringLayout.SOUTH, online_icon);
		currentLayout.putConstraint(SpringLayout.WEST, test_mode, 0,
				SpringLayout.WEST, online_icon);

		card1.add(test_mode);

		JLabel practice_mode = new JLabel(
				"<html>These type of contests are used <br>"
						+ "for practice. Here, students are <br>"
						+ "free to solve any question <br>without knowing the code.</html>",
				new ImageIcon(HelpPanel.class
						.getResource("/img/practicetypeicon.png")),
				SwingConstants.RIGHT);
		practice_mode.setForeground(Color.decode("#aaaaaa"));
		practice_mode.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, practice_mode, 0,
				SpringLayout.NORTH, test_mode);
		currentLayout.putConstraint(SpringLayout.SOUTH, practice_mode, 0,
				SpringLayout.SOUTH, test_mode);
		currentLayout.putConstraint(SpringLayout.WEST, practice_mode, 5,
				SpringLayout.EAST, test_mode);

		card1.add(practice_mode);

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
		JLabel lbl_name = new JLabel("LEADERBOARD");

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
				"<html><b>LeaderBoard:</b> Used to see all submissions for a contest. Submission icons:-</html>");
		lb_info.setForeground(Color.decode("#aaaaaa"));
		lb_info.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, lb_info, 0,
				SpringLayout.SOUTH, lbl_name);
		currentLayout.putConstraint(SpringLayout.WEST, lb_info, 10,
				SpringLayout.WEST, card1);
		card1.add(lb_info);

		JPanel types = new JPanel(new GridLayout(2, 3, 5, 5));
		types.setOpaque(false);
		currentLayout.putConstraint(SpringLayout.NORTH, types, 10,
				SpringLayout.SOUTH, lb_info);
		currentLayout.putConstraint(SpringLayout.WEST, types, 0,
				SpringLayout.WEST, lbl_name);
		currentLayout.putConstraint(SpringLayout.EAST, types, 0,
				SpringLayout.EAST, lbl_name);

		JLabel not_sub = new JLabel("Not submitted", new ImageIcon(
				HelpPanel.class.getResource("/img/putoffline.png")),
				SwingConstants.LEFT);
		not_sub.setForeground(Color.decode("#aaaaaa"));
		not_sub.setFont(new Font("Tahoma", Font.PLAIN, 11));
		types.add(not_sub);

		JLabel ans_wrng = new JLabel("Wrong answer", new ImageIcon(
				HelpPanel.class.getResource("/img/cross-icon.gif")),
				SwingConstants.LEFT);
		ans_wrng.setForeground(Color.decode("#aaaaaa"));
		ans_wrng.setFont(new Font("Tahoma", Font.PLAIN, 11));
		types.add(ans_wrng);

		JLabel ans_acc = new JLabel("Answer accepted", new ImageIcon(
				HelpPanel.class.getResource("/img/putonline.png")),
				SwingConstants.LEFT);
		ans_acc.setForeground(Color.decode("#aaaaaa"));
		ans_acc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		types.add(ans_acc);

		JLabel cmp_err = new JLabel("Compile-time error", new ImageIcon(
				HelpPanel.class.getResource("/img/050.png")),
				SwingConstants.LEFT);
		cmp_err.setForeground(Color.decode("#aaaaaa"));
		cmp_err.setFont(new Font("Tahoma", Font.PLAIN, 11));
		types.add(cmp_err);

		JLabel run_err = new JLabel("Run-time error", new ImageIcon(
				HelpPanel.class.getResource("/img/runtime-error.png")),
				SwingConstants.LEFT);
		run_err.setForeground(Color.decode("#aaaaaa"));
		run_err.setFont(new Font("Tahoma", Font.PLAIN, 11));
		types.add(run_err);

		JLabel uploaded = new JLabel("Only uploaded", new ImageIcon(
				HelpPanel.class.getResource("/img/editicon_small.png")),
				SwingConstants.LEFT);
		uploaded.setForeground(Color.decode("#aaaaaa"));
		uploaded.setFont(new Font("Tahoma", Font.PLAIN, 11));
		types.add(uploaded);
		card1.add(types);

		JLabel tip1 = new JLabel(
				"<html><b>(1)</b> To see the time of submission of any program, hover mouse over the submission icon <br>"
						+ "in the leaderboard.</html>");
		tip1.setForeground(Color.decode("#aaaaaa"));
		tip1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, tip1, 10,
				SpringLayout.SOUTH, types);
		currentLayout.putConstraint(SpringLayout.WEST, tip1, 10,
				SpringLayout.WEST, card1);
		card1.add(tip1);

		JLabel tip2 = new JLabel(
				"<html><b>(2)</b> To sort the time of submission according to any question, click on the question name in <br>"
						+ "the leaderboard.</html>");
		tip2.setForeground(Color.decode("#aaaaaa"));
		tip2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, tip2, 5,
				SpringLayout.SOUTH, tip1);
		currentLayout.putConstraint(SpringLayout.WEST, tip2, 10,
				SpringLayout.WEST, card1);
		card1.add(tip2);

		JLabel tip3 = new JLabel(
				"<html><b>(3)</b> Click on the submission icon to view the submitted program.</html>");
		tip3.setForeground(Color.decode("#aaaaaa"));
		tip3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentLayout.putConstraint(SpringLayout.NORTH, tip3, 5,
				SpringLayout.SOUTH, tip2);
		currentLayout.putConstraint(SpringLayout.WEST, tip3, 10,
				SpringLayout.WEST, card1);
		card1.add(tip3);

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

	public void register(NewQuestionAddedListener cp) {
		cp.refreshpane();
	}

}
