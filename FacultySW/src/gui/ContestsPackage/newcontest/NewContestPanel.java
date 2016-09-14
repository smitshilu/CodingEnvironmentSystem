package gui.ContestsPackage.newcontest;

import gui.CommonPackage.JBackgroundPanel;
import gui.ContestsPackage.contest.GridLayoutContests;
import gui.ContestsPackage.contest.MyPopUpSelectionListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

import validation.Validation;
import database.create.CreateContest;
import database.create.CreateTestContest;

@SuppressWarnings("serial")
public class NewContestPanel extends JPanel implements ActionListener,
		KeyListener {

	private SpringLayout currentLayout;

	JTextField c_name;
	GridLayoutContests cp;

	public NewContestPanel(GridLayoutContests cp) {
		this.cp = cp;
		currentLayout = new SpringLayout();

		setUpPanel();
	}

	private void setUpPanel() {

		this.setSize(550, 200);
		this.setFocusable(true);
		this.addKeyListener(this);
		// Contest label
		JLabel contest_lbl = new JLabel("CONTEST");
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
		JLabel lbl_name = new JLabel("Name:");

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
		c_name.addKeyListener(this);
		add(c_name);

		JButton button_create = new JButton(new ImageIcon(
				NewContestPanel.class.getResource("/img/go.png")));
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
		go();
	}

	public void register(MyPopUpSelectionListener cp) {
		cp.refreshpane();
	}

	void go() {
		if (Validation.isContestNameValid(c_name.getText())) {
			try {
				new CreateContest(c_name.getText().replace(" ", "_"));
				new CreateTestContest(c_name.getText().replace(" ", "_"));
				JFrame topFrame = (JFrame) SwingUtilities
						.getWindowAncestor(NewContestPanel.this);
				topFrame.dispose();
				NewContestPanel.this.register(cp);
			} catch (Exception e1) {
				JOptionPane
						.showMessageDialog(null,
								"Duplicate contest name entered. Please try another name.");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Invalid contest name. Try another name.");
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {
			go();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}
