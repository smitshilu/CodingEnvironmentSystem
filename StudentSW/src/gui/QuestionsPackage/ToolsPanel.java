package gui.QuestionsPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import session.Client;

@SuppressWarnings("serial")
public class ToolsPanel extends JPanel implements ChangeListener {

	private JButton testButton;
	private SpringLayout currentLayout;
	private File file;
	private String username = "", ip = "", contestname = "";
	ButtonGroup language;
	JRadioButton rdbtn1, rdbtn2, rdbtn3;
	private JRadioButton rdbtn4;

	public ToolsPanel(String ip, String username, String contestname) {

		this.username = username;
		this.contestname = contestname;
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#555555"),
				1));
		language = new ButtonGroup();
		currentLayout = new SpringLayout();
		this.ip = ip;

		setUpPanel();
	}

	private void setUpPanel() {
		this.setBackground(Color.decode("#3c3f41"));
		testButton = new JButton("Submit", new ImageIcon(
				ToolsPanel.class.getResource("/img/submit_small.png")));
		testButton.setOpaque(true);
		testButton.setContentAreaFilled(false);
		testButton.setBorderPainted(false);
		testButton.setFocusPainted(false);
		currentLayout.putConstraint(SpringLayout.EAST, testButton, -10,
				SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, testButton, 0,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, testButton, 410,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, testButton, 0,
				SpringLayout.SOUTH, this);
		this.add(testButton);
		this.setSize(550, 50);

		JButton btnBrowse = new JButton("Select File", new ImageIcon(
				ToolsPanel.class.getResource("/img/browse_small.png")));
		btnBrowse.setOpaque(true);
		btnBrowse.setContentAreaFilled(false);
		btnBrowse.setBorderPainted(false);
		btnBrowse.setFocusPainted(false);
		// btnBrowse.setBackground(Color.decode("#2b2e30"));
		btnBrowse.setForeground(Color.decode("#aaaaaa"));
		currentLayout.putConstraint(SpringLayout.EAST, btnBrowse, -150,
				SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.WEST, btnBrowse, 270,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, btnBrowse, 0,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, btnBrowse, 0,
				SpringLayout.SOUTH, this);
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name = "";
				JRadioButton[] btns = { rdbtn1, rdbtn2, rdbtn3, rdbtn4 };
				for (JRadioButton b : btns) {
					if (b.isSelected()) {
						name = b.getText();
						if (name.equals("C++"))
							name = "cpp";

						break;
					}
				}

				final JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						null, name);
				if (!name.equals("Other"))
					fc.setFileFilter(filter);
				int returnVal = fc.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();

				} else {

				}

			}

		});
		add(btnBrowse);
		testButton.setForeground(Color.decode("#aaaaaa"));
		testButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					int sel = 1;
					String name = "";
					JRadioButton[] btns = { rdbtn1, rdbtn2, rdbtn3, rdbtn4 };
					for (JRadioButton b : btns) {
						if (b.isSelected())
							name = b.getText();
					}

					if (name.equals("Java"))
						sel = 1;
					else if (name.equals("C"))
						sel = 2;
					else if (name.equals("C++"))
						sel = 3;
					else if (name.equals("Other"))
						sel = 4;

					Client c = new Client(ip, username, contestname,
							currentQuestion.getCurrentQ());
					JOptionPane.showMessageDialog(getParent(),
							c.uploadFile(file.getAbsolutePath(), sel));

				} catch (NullPointerException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(getParent(),
							"Please select a file to upload");
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(getParent(),
							"Could not connect to the server.");
				}

			}
		});

		setLayout(currentLayout);

		rdbtn1 = new JRadioButton("Java");
		rdbtn1.setOpaque(true);
		rdbtn1.setContentAreaFilled(false);
		rdbtn1.setBorderPainted(false);
		rdbtn1.setFocusPainted(false);
		rdbtn1.setForeground(Color.decode("#aaaaaa"));
		currentLayout.putConstraint(SpringLayout.EAST, rdbtn1, -430,
				SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.WEST, rdbtn1, 20,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, rdbtn1, 0,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, rdbtn1, 0,
				SpringLayout.SOUTH, this);
		rdbtn1.setSelected(true);
		add(rdbtn1);

		rdbtn2 = new JRadioButton("C");
		rdbtn2.setOpaque(true);
		rdbtn2.setContentAreaFilled(false);
		rdbtn2.setBorderPainted(false);
		rdbtn2.setFocusPainted(false);
		rdbtn2.setForeground(Color.decode("#aaaaaa"));

		currentLayout.putConstraint(SpringLayout.EAST, rdbtn1, 0,
				SpringLayout.WEST, rdbtn2);

		currentLayout.putConstraint(SpringLayout.WEST, rdbtn2, 75,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, rdbtn2, 0,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, rdbtn2, 0,
				SpringLayout.SOUTH, this);
		add(rdbtn2);

		rdbtn3 = new JRadioButton("C++");
		rdbtn3.setOpaque(true);
		rdbtn3.setForeground(Color.decode("#aaaaaa"));
		rdbtn3.setContentAreaFilled(false);
		rdbtn3.setBorderPainted(false);
		rdbtn3.setFocusPainted(false);
		currentLayout.putConstraint(SpringLayout.WEST, rdbtn3, 15,
				SpringLayout.EAST, rdbtn2);

		currentLayout.putConstraint(SpringLayout.NORTH, rdbtn3, 0,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, rdbtn3, 0,
				SpringLayout.SOUTH, this);
		add(rdbtn3);

		rdbtn4 = new JRadioButton("Other");

		rdbtn4.setOpaque(true);
		rdbtn4.setForeground(new Color(170, 170, 170));
		rdbtn4.setFocusPainted(false);
		rdbtn4.setContentAreaFilled(false);
		rdbtn4.setBorderPainted(false);
		currentLayout.putConstraint(SpringLayout.WEST, rdbtn4, 15,
				SpringLayout.EAST, rdbtn3);

		currentLayout.putConstraint(SpringLayout.NORTH, rdbtn4, 0,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, rdbtn4, 0,
				SpringLayout.SOUTH, this);
		add(rdbtn4);
		rdbtn1.addChangeListener(this);
		rdbtn2.addChangeListener(this);
		rdbtn3.addChangeListener(this);
		rdbtn4.addChangeListener(this);
		language.add(rdbtn1);
		language.add(rdbtn2);
		language.add(rdbtn3);
		language.add(rdbtn4);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		file=null;
	}
}
