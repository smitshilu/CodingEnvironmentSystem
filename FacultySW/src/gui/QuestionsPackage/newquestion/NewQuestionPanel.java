package gui.QuestionsPackage.newquestion;

import gui.CommonPackage.JBackgroundPanel;
import gui.QuestionsPackage.questions.NewQuestionAddedListener;
import gui.QuestionsPackage.questions.QuestionsPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import validation.Validation;
import database.create.CreateQuestion;

@SuppressWarnings("serial")
public class NewQuestionPanel extends JPanel {

	CardLayout cards;
	JPanel cardPanel;
	String contestname = "";
	JTextField c_name1;
	JTextArea c_name2, c_name3, c_name4, c_name5, c_name6, c_name7, c_name8;
	QuestionsPanel cp;

	public NewQuestionPanel(String contestname, QuestionsPanel cp) {
		this.cp = cp;
		this.contestname = contestname;
		cards = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cards);
		setUpPanel();
	}

	void setUpPanel() {
		setSize(550, 200);
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
		JLabel contest_lbl = new JLabel("QUESTION");
		contest_lbl.setForeground(Color.decode("#aaaaaa"));
		contest_lbl.setFont(new Font("SansSerif", Font.BOLD, 28));
		currentLayout.putConstraint(SpringLayout.EAST, contest_lbl, -325,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, contest_lbl, 55,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, contest_lbl, 25,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, contest_lbl, -125,
				SpringLayout.SOUTH, card1);
		card1.add(contest_lbl);

		// Name label
		JLabel lbl_name = new JLabel("Q. Code:");

		lbl_name.setBorder(new EmptyBorder(10, 10, 10, 10));
		lbl_name.setForeground(Color.decode("#aaaaaa"));
		lbl_name.setFont(new Font("SansSerif", Font.BOLD, 16));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name, -375,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name, 75,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name, 100,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name, -50,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name);

		// Name textfield
		c_name1 = new JTextField();
		c_name1.setBackground(Color.decode("#3c3f41"));
		c_name1.setForeground(Color.decode("#aaaaaa"));
		c_name1.setFont(new Font("SansSerif", Font.BOLD, 15));
		currentLayout.putConstraint(SpringLayout.EAST, c_name1, -175,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, c_name1, 175,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, c_name1, 105,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, c_name1, -55,
				SpringLayout.SOUTH, card1);
		card1.add(c_name1);

		JButton button_create = new JButton("Next", new ImageIcon(
				NewQuestionPanel.class.getResource("/img/go.png")));
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

				if (!Validation.isQuestionCodeValid(c_name1.getText())) {
					JOptionPane.showMessageDialog(null,
							"Invalid question code.");
					return;
				}

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
		JLabel lbl_name = new JLabel("Question:");

		lbl_name.setBorder(new EmptyBorder(10, 10, 10, 10));
		lbl_name.setForeground(Color.decode("#aaaaaa"));
		lbl_name.setFont(new Font("SansSerif", Font.BOLD, 16));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name, -400,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name, 25,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name, 0,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name, -150,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name);

		// Name textfield

		c_name2 = new JTextArea();

		c_name2.setLineWrap(true);
		c_name2.setBackground(Color.decode("#3c3f41"));
		c_name2.setForeground(Color.decode("#aaaaaa"));

		c_name2.setFont(new Font("SansSerif", Font.BOLD, 15));
		JScrollPane scroll = new JScrollPane(c_name2);
		currentLayout.putConstraint(SpringLayout.EAST, scroll, -125,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, scroll, 25,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, scroll, 50,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, scroll, -25,
				SpringLayout.SOUTH, card1);

		card1.add(scroll);

		JButton button_create = new JButton("Next", new ImageIcon(
				NewQuestionPanel.class.getResource("/img/go.png")));
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

				if (!Validation.isQuestionValid(c_name2.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid question.");
					return;
				}

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
		JLabel lbl_name = new JLabel("Input:");

		lbl_name.setBorder(new EmptyBorder(10, 10, 10, 10));
		lbl_name.setForeground(Color.decode("#aaaaaa"));
		lbl_name.setFont(new Font("SansSerif", Font.BOLD, 16));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name, -425,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name, 17,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name, 10,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name, -150,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name);

		// Name textfield
		c_name3 = new JTextArea();
		c_name3.setLineWrap(true);
		c_name3.setBackground(Color.decode("#3c3f41"));
		c_name3.setForeground(Color.decode("#aaaaaa"));
		c_name3.setFont(new Font("SansSerif", Font.BOLD, 15));
		JScrollPane scroll = new JScrollPane(c_name3);
		currentLayout.putConstraint(SpringLayout.EAST, scroll, -338,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, scroll, 25,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, scroll, 50,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, scroll, -25,
				SpringLayout.SOUTH, card1);
		card1.add(scroll);

		// Name label
		JLabel lbl_name2 = new JLabel("Output:");

		lbl_name2.setBorder(new EmptyBorder(10, 10, 10, 10));
		lbl_name2.setForeground(Color.decode("#aaaaaa"));
		lbl_name2.setFont(new Font("SansSerif", Font.BOLD, 16));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name2, -150,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name2, 232,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name2, 10,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name2, -150,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name2);

		// Name textfield
		c_name4 = new JTextArea();
		c_name4.setLineWrap(true);
		c_name4.setBackground(Color.decode("#3c3f41"));
		c_name4.setForeground(Color.decode("#aaaaaa"));
		c_name4.setFont(new Font("SansSerif", Font.BOLD, 15));
		JScrollPane scroll2 = new JScrollPane(c_name4);
		currentLayout.putConstraint(SpringLayout.EAST, scroll2, -125,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, scroll2, 238,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, scroll2, 50,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, scroll2, -25,
				SpringLayout.SOUTH, card1);
		card1.add(scroll2);

		JButton button_create = new JButton("Next", new ImageIcon(
				NewQuestionPanel.class.getResource("/img/go.png")));
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

				if (!Validation.isInputValid(c_name3.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid input data.");
					return;
				}

				if (!Validation.isOutputValid(c_name4.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid output data.");
					return;
				}

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
		JLabel lbl_name = new JLabel("Constraints:");

		lbl_name.setBorder(new EmptyBorder(10, 10, 10, 10));
		lbl_name.setForeground(Color.decode("#aaaaaa"));
		lbl_name.setFont(new Font("SansSerif", Font.BOLD, 16));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name, -400,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name, 17,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name, 10,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name, -150,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name);

		// Name textfield
		c_name5 = new JTextArea();
		c_name5.setLineWrap(true);
		c_name5.setBackground(Color.decode("#3c3f41"));
		c_name5.setForeground(Color.decode("#aaaaaa"));
		c_name5.setFont(new Font("SansSerif", Font.BOLD, 15));
		JScrollPane scroll = new JScrollPane(c_name5);
		currentLayout.putConstraint(SpringLayout.EAST, scroll, -338,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, scroll, 25,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, scroll, 50,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, scroll, -25,
				SpringLayout.SOUTH, card1);
		card1.add(scroll);

		// Name label
		JLabel lbl_name2 = new JLabel("Example:");

		lbl_name2.setBorder(new EmptyBorder(10, 10, 10, 10));
		lbl_name2.setForeground(Color.decode("#aaaaaa"));
		lbl_name2.setFont(new Font("SansSerif", Font.BOLD, 16));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name2, -150,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name2, 232,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name2, 10,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name2, -150,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name2);

		// Name textfield
		c_name6 = new JTextArea();
		c_name6.setLineWrap(true);
		c_name6.setBackground(Color.decode("#3c3f41"));
		c_name6.setForeground(Color.decode("#aaaaaa"));
		c_name6.setFont(new Font("SansSerif", Font.BOLD, 15));
		JScrollPane scroll2 = new JScrollPane(c_name6);
		currentLayout.putConstraint(SpringLayout.EAST, scroll2, -125,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, scroll2, 238,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, scroll2, 50,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, scroll2, -25,
				SpringLayout.SOUTH, card1);
		card1.add(scroll2);

		JButton button_create = new JButton("Next", new ImageIcon(
				NewQuestionPanel.class.getResource("/img/go.png")));
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

				if (!Validation.isConstraintsValid(c_name5.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid constaints.");
					return;
				}
				if (!Validation.isExamplesValid(c_name6.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid example.");
					return;
				}

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
		JLabel lbl_name = new JLabel("Test Input:");

		lbl_name.setBorder(new EmptyBorder(10, 10, 10, 10));
		lbl_name.setForeground(Color.decode("#aaaaaa"));
		lbl_name.setFont(new Font("SansSerif", Font.BOLD, 16));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name, -425,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name, 17,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name, 10,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name, -150,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name);

		// Name textfield
		c_name7 = new JTextArea();
		c_name7.setLineWrap(true);
		c_name7.setBackground(Color.decode("#3c3f41"));
		c_name7.setForeground(Color.decode("#aaaaaa"));
		c_name7.setFont(new Font("SansSerif", Font.BOLD, 15));
		JScrollPane scroll = new JScrollPane(c_name7);
		currentLayout.putConstraint(SpringLayout.EAST, scroll, -338,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, scroll, 25,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, scroll, 50,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, scroll, -25,
				SpringLayout.SOUTH, card1);
		card1.add(scroll);

		// Name label
		JLabel lbl_name2 = new JLabel("Test Output:");

		lbl_name2.setBorder(new EmptyBorder(10, 10, 10, 10));
		lbl_name2.setForeground(Color.decode("#aaaaaa"));
		lbl_name2.setFont(new Font("SansSerif", Font.BOLD, 16));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name2, -150,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name2, 232,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name2, 10,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name2, -150,
				SpringLayout.SOUTH, card1);
		card1.add(lbl_name2);

		// Name textfield
		c_name8 = new JTextArea();
		c_name8.setLineWrap(true);
		c_name8.setBackground(Color.decode("#3c3f41"));
		c_name8.setForeground(Color.decode("#aaaaaa"));
		c_name8.setFont(new Font("SansSerif", Font.BOLD, 15));
		JScrollPane scroll2 = new JScrollPane(c_name8);
		currentLayout.putConstraint(SpringLayout.EAST, scroll2, -125,
				SpringLayout.EAST, card1);
		currentLayout.putConstraint(SpringLayout.WEST, scroll2, 238,
				SpringLayout.WEST, card1);
		currentLayout.putConstraint(SpringLayout.NORTH, scroll2, 50,
				SpringLayout.NORTH, card1);
		currentLayout.putConstraint(SpringLayout.SOUTH, scroll2, -25,
				SpringLayout.SOUTH, card1);
		card1.add(scroll2);

		JButton button_create = new JButton("Create", new ImageIcon(
				NewQuestionPanel.class.getResource("/img/go.png")));
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

				if (!Validation.isInputValid(c_name7.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid input data.");
					return;
				}

				if (!Validation.isOutputValid(c_name8.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid output data.");
					return;
				}

				try {
									
					new CreateQuestion(contestname, c_name1.getText(), c_name2
							.getText().replace("'", "\\'"), c_name3.getText(),
							c_name4.getText(), c_name5.getText(), c_name6
									.getText(), c_name7.getText(), c_name8
									.getText());
					JFrame topFrame = (JFrame) SwingUtilities
							.getWindowAncestor(NewQuestionPanel.this);
					topFrame.dispose();
					NewQuestionPanel.this.register(cp);
				} catch (Exception e1) {
					JOptionPane
							.showMessageDialog(NewQuestionPanel.this,
									"Error in creating the question. Try some other Question Code.");
					e1.printStackTrace();
				}
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
