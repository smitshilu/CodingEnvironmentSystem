package gui.ContestsPackage.contest.account;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class AccountPanel extends JPanel {

	String programtext = new String("About us");
	private JTextField textField1, textField2;

	public AccountPanel() {
		setUpPanel();
	}

	void setUpPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		setBackground(Color.decode("#3c3f41"));

		textField1 = new JTextField();
		textField2 = new JTextField();
		
		textField1.setText("Username");
		textField2.setText("Password");
		
		springLayout.putConstraint(SpringLayout.NORTH, textField1, 53,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField1, 53,
				SpringLayout.WEST, this);

		springLayout.putConstraint(SpringLayout.NORTH, textField2, 53,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField2, 10,
				SpringLayout.EAST, textField1);
		add(textField1);
		add(textField2);

	}
}
