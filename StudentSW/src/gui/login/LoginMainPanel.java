package gui.login;

import gui.CommonPackage.JBackgroundPanel;
import gui.ContestsPackage.ContestsFrame;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import objectclasses.OnlineContests;
import objectclasses.OnlinePracticeContests;
import objectclasses.OnlineTestContests;
import session.Login;
import validation.Validation;
import database.load.LoadOnlineContests;
import database.load.LoadPracticeContests;
import database.load.LoadTestContests;
import database.login.ClientLogin;

@SuppressWarnings("serial")
public class LoginMainPanel extends JPanel implements KeyListener {

	private JTextField text_ip, text_id, text_pwd;
	private SpringLayout mainLayout;
	private Font f;

	public LoginMainPanel() {
		f = new Font("SansSerif", Font.BOLD, 15);
		// f = null;
		setUpPanel();
	}

	private void setUpPanel() {

		// set panel size
		setSize(500, 300);
		mainLayout = new SpringLayout();

		SpringLayout currentLayout = new SpringLayout();
		JPanel leftComponent = new JPanel(currentLayout);

		// LOGIN label
		JLabel label_login = new JLabel("LOGIN");
		label_login.setForeground(Color.decode("#aaaaaa"));
		label_login.setFont(new Font("SansSerif", Font.BOLD, 25));
		currentLayout.putConstraint(SpringLayout.NORTH, label_login, 25,
				SpringLayout.NORTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.SOUTH, label_login, -250,
				SpringLayout.SOUTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.WEST, label_login, 45,
				SpringLayout.WEST, leftComponent);
		currentLayout.putConstraint(SpringLayout.EAST, label_login, -250,
				SpringLayout.EAST, leftComponent);
		leftComponent.add(label_login);

		// Setup ip label and ip textfield
		// ip label
		JLabel label_ip = new JLabel("Server IP:");
		label_ip.setForeground(Color.decode("#aaaaaa"));
		currentLayout.putConstraint(SpringLayout.NORTH, label_ip, 65,
				SpringLayout.NORTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.SOUTH, label_ip, -165,
				SpringLayout.SOUTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.WEST, label_ip, 50,
				SpringLayout.WEST, leftComponent);
		currentLayout.putConstraint(SpringLayout.EAST, label_ip, -250,
				SpringLayout.EAST, leftComponent);
		leftComponent.add(label_ip);

		// ip textfield
		text_ip = new JTextField();
		text_ip.setBackground(Color.decode("#3c3f41"));
		text_ip.setForeground(Color.decode("#aaaaaa"));
		text_ip.setFont(f);
		text_ip.addKeyListener(this);
		text_ip.requestFocus();
		currentLayout.putConstraint(SpringLayout.NORTH, text_ip, 80,
				SpringLayout.NORTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.SOUTH, text_ip, -180,
				SpringLayout.SOUTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.WEST, text_ip, 150,
				SpringLayout.WEST, leftComponent);
		currentLayout.putConstraint(SpringLayout.EAST, text_ip, -50,
				SpringLayout.EAST, leftComponent);
		leftComponent.add(text_ip);
		text_ip.setColumns(10);

		// Setup id label and id textfield
		// id label
		JLabel label_id = new JLabel("Username:");
		label_id.setForeground(Color.decode("#aaaaaa"));
		currentLayout.putConstraint(SpringLayout.NORTH, label_id, 150,
				SpringLayout.NORTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.SOUTH, label_id, -100,
				SpringLayout.SOUTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.WEST, label_id, 50,
				SpringLayout.WEST, leftComponent);
		currentLayout.putConstraint(SpringLayout.EAST, label_id, -250,
				SpringLayout.EAST, leftComponent);
		leftComponent.add(label_id);

		// id textfield
		text_id = new JTextField();
		text_id.setBackground(Color.decode("#3c3f41"));
		text_id.setForeground(Color.decode("#aaaaaa"));
		text_id.setFont(f);
		text_id.addKeyListener(this);
		currentLayout.putConstraint(SpringLayout.NORTH, text_id, 155,
				SpringLayout.NORTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.SOUTH, text_id, -105,
				SpringLayout.SOUTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.WEST, text_id, 150,
				SpringLayout.WEST, leftComponent);
		currentLayout.putConstraint(SpringLayout.EAST, text_id, -50,
				SpringLayout.EAST, leftComponent);
		leftComponent.add(text_id);
		text_id.setColumns(10);

		// Setup pwd label and pwd textfield
		// pwd label
		JLabel label_pwd = new JLabel("Password:");
		label_pwd.setHorizontalTextPosition(SwingConstants.CENTER);
		label_pwd.setForeground(Color.decode("#aaaaaa"));
		currentLayout.putConstraint(SpringLayout.NORTH, label_pwd, 225,
				SpringLayout.NORTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.SOUTH, label_pwd, -25,
				SpringLayout.SOUTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.WEST, label_pwd, 50,
				SpringLayout.WEST, leftComponent);
		currentLayout.putConstraint(SpringLayout.EAST, label_pwd, -250,
				SpringLayout.EAST, leftComponent);
		leftComponent.add(label_pwd);

		// pwd textfield
		text_pwd = new JPasswordField();
		text_pwd.setBackground(Color.decode("#3c3f41"));
		text_pwd.setForeground(Color.decode("#aaaaaa"));
		text_pwd.addKeyListener(this);
		currentLayout.putConstraint(SpringLayout.NORTH, text_pwd, 230,
				SpringLayout.NORTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.SOUTH, text_pwd, -30,
				SpringLayout.SOUTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.WEST, text_pwd, 150,
				SpringLayout.WEST, leftComponent);
		currentLayout.putConstraint(SpringLayout.EAST, text_pwd, -50,
				SpringLayout.EAST, leftComponent);
		leftComponent.add(text_pwd);
		text_pwd.setColumns(10);

		// Setup background
		JBackgroundPanel panel_background = new JBackgroundPanel();
		currentLayout.putConstraint(SpringLayout.NORTH, panel_background, 0,
				SpringLayout.NORTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.WEST, panel_background, 0,
				SpringLayout.WEST, leftComponent);
		currentLayout.putConstraint(SpringLayout.SOUTH, panel_background, 0,
				SpringLayout.SOUTH, leftComponent);
		currentLayout.putConstraint(SpringLayout.EAST, panel_background, 0,
				SpringLayout.EAST, leftComponent);
		leftComponent.add(panel_background);
		SpringLayout currentLayout2 = new SpringLayout();
		JPanel rightComponent = new JPanel(currentLayout2);
		rightComponent.setBackground(Color.decode("#3c3f41"));
		// Setup login button
		JButton button_login = new JButton(new ImageIcon(
				LoginMainPanel.class.getResource("/img/go.png")));
		button_login.setOpaque(true);
		button_login.setContentAreaFilled(false);
		button_login.setBorderPainted(false);
		button_login.setFocusPainted(false);

		currentLayout2.putConstraint(SpringLayout.EAST, button_login, 0,
				SpringLayout.EAST, rightComponent);
		currentLayout2.putConstraint(SpringLayout.WEST, button_login, 0,
				SpringLayout.WEST, rightComponent);
		currentLayout2.putConstraint(SpringLayout.SOUTH, button_login, -125,
				SpringLayout.SOUTH, rightComponent);
		currentLayout2.putConstraint(SpringLayout.NORTH, button_login, 25,
				SpringLayout.NORTH, rightComponent);
		button_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				go();
			}
		});
		rightComponent.add(button_login);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(400);
		splitPane.setEnabled(false);
		splitPane.setDividerSize(0);
		mainLayout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST,
				splitPane);
		mainLayout.putConstraint(SpringLayout.WEST, this, 0, SpringLayout.WEST,
				splitPane);
		mainLayout.putConstraint(SpringLayout.SOUTH, this, 0,
				SpringLayout.SOUTH, splitPane);
		mainLayout.putConstraint(SpringLayout.NORTH, this, 0,
				SpringLayout.NORTH, splitPane);

		leftComponent.setMinimumSize(new Dimension(0, 0));
		rightComponent.setMinimumSize(new Dimension(0, 0));
		splitPane.setLeftComponent(leftComponent);
		splitPane.setRightComponent(rightComponent);
		add(splitPane);

		setLayout(mainLayout);
		setFocusable(true);
		addKeyListener(this);

	}

	void go() {
		try {

			if (!Validation.isIPValid(text_ip.getText())) {
				JOptionPane.showMessageDialog(null, "Invalid IP address.");
				return;
			}

			if (!Validation.isUserNameValid(text_id.getText())) {
				JOptionPane.showMessageDialog(null, "Invalid username.");
				return;
			}

			if (!Validation.isPasswordValid(text_pwd.getText())) {
				JOptionPane.showMessageDialog(null, "Invalid password.");
				return;
			}

			new Login(text_ip.getText());
			ClientLogin l = new ClientLogin();
			if (l.Log_in(text_id.getText(), text_pwd.getText())) {

				OnlineContests.setOnlineContests((new LoadOnlineContests()
						.loadAllContests()));
				OnlineTestContests
						.setOnlineTestContests((new LoadTestContests()
								.loadAllContests()));
				OnlinePracticeContests
						.setOnlinePracticeContests((new LoadPracticeContests()
								.loadAllContests()));
				new ContestsFrame(text_id.getText()).setVisible(true);
				JFrame topFrame = (JFrame) SwingUtilities
						.getWindowAncestor(LoginMainPanel.this);
				topFrame.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Invalid id/password.");
			}
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(getParent(),
							"Connection could not be established with the given server IP.");
			e.printStackTrace();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			go();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
