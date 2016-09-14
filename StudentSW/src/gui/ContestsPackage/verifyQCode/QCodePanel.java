package gui.ContestsPackage.verifyQCode;

import gui.CommonPackage.JBackgroundPanel;
import gui.ContestsPackage.ContestsPanel;
import gui.QuestionsPackage.SpecificQuestionFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import objectclasses.Question;
import database.load.LoadSpecificQuestion;

@SuppressWarnings("serial")
public class QCodePanel extends JPanel implements ActionListener {

	private SpringLayout currentLayout;
	String username, contestname;
	JTextField c_name;
	ContestsPanel cp;

	public QCodePanel(ContestsPanel cp, String username, String contestname) {

		currentLayout = new SpringLayout();
		this.cp = cp;
		this.username = username;
		this.contestname = contestname;
		setUpPanel();
	}

	private void setUpPanel() {

		this.setSize(550, 200);

		// Contest label
		JLabel contest_lbl = new JLabel("QUESTION");
		contest_lbl.setForeground(Color.decode("#aaaaaa"));
		contest_lbl.setFont(new Font("SansSerif", Font.BOLD, 28));
		currentLayout.putConstraint(SpringLayout.EAST, contest_lbl, -325,
				SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.WEST, contest_lbl, 55,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, contest_lbl, 25,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, contest_lbl, -125,
				SpringLayout.SOUTH, this);
		add(contest_lbl);

		// Name label
		JLabel lbl_name = new JLabel("Code:");

		lbl_name.setBorder(new EmptyBorder(10, 10, 10, 10));
		lbl_name.setForeground(Color.decode("#aaaaaa"));
		lbl_name.setFont(new Font("SansSerif", Font.BOLD, 16));
		currentLayout.putConstraint(SpringLayout.EAST, lbl_name, -375,
				SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.WEST, lbl_name, 75,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, lbl_name, 100,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, lbl_name, -50,
				SpringLayout.SOUTH, this);
		add(lbl_name);

		// Name textfield
		c_name = new JTextField();
		c_name.setBackground(Color.decode("#3c3f41"));
		c_name.setForeground(Color.decode("#aaaaaa"));
		c_name.setFont(new Font("SansSerif", Font.BOLD, 15));
		currentLayout.putConstraint(SpringLayout.EAST, c_name, -175,
				SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.WEST, c_name, 175,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, c_name, 105,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, c_name, -55,
				SpringLayout.SOUTH, this);
		add(c_name);

		JButton button_create = new JButton(new ImageIcon(
				QCodePanel.class.getResource("/img/go.png")));
		button_create.setOpaque(true);
		button_create.setContentAreaFilled(false);
		button_create.setBorderPainted(false);
		button_create.setFocusPainted(false);

		currentLayout.putConstraint(SpringLayout.EAST, button_create, 0,
				SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.WEST, button_create, 450,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, button_create, -105,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.NORTH, button_create, 40,
				SpringLayout.NORTH, this);
		this.add(button_create);

		button_create.addActionListener(this);
		JBackgroundPanel p = new JBackgroundPanel();
		currentLayout.putConstraint(SpringLayout.EAST, p, -100,
				SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.WEST, p, 0, SpringLayout.WEST,
				this);
		currentLayout.putConstraint(SpringLayout.NORTH, p, 0,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, p, 0,
				SpringLayout.SOUTH, this);
		this.setBackground(Color.decode("#3c3f41"));
		add(p);
		setLayout(currentLayout);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		LoadSpecificQuestion lq = new LoadSpecificQuestion(contestname,
				c_name.getText(),username);

		List<Question> questions = lq.loadAllQuestions();

		if (questions.isEmpty()) {
			JOptionPane
					.showMessageDialog(null,
							"Invalid question code. Please try again with the correct question code.");
		} else {
			new SpecificQuestionFrame(username, contestname, c_name.getText())
					.setVisible(true);
			JFrame topFrame = (JFrame) SwingUtilities
					.getWindowAncestor(QCodePanel.this);
			topFrame.dispose();
			JFrame topFrame2 = (JFrame) SwingUtilities
					.getWindowAncestor(cp);
			topFrame2.dispose();
		}
	}

}
