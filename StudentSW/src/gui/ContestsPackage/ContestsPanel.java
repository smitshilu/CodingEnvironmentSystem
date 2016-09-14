package gui.ContestsPackage;

import gui.CommonPackage.JBackgroundPanel;
import gui.CommonPackage.ToolsBackgroundPanel;
import gui.ContestsPackage.contest.about.AboutFrame;
import gui.ContestsPackage.contest.help.HelpFrame;
import gui.ContestsPackage.verifyQCode.QCodeFrame;
import gui.QuestionsPackage.AllQuestionsFrame;
import gui.login.LoginMainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import objectclasses.OnlineContests;
import objectclasses.OnlinePracticeContests;
import objectclasses.OnlineTestContests;

@SuppressWarnings("serial")
public class ContestsPanel extends JPanel implements ActionListener {
	private SpringLayout currentLayout;

	List<String> onlineContests = new ArrayList<String>();
	List<String> onlineTestContests = new ArrayList<String>();
	List<String> onlinePracticeContests = new ArrayList<String>();

	String username = "";
	JPanel practicepanelgrid, testpanelgrid;
	Font f;

	public ContestsPanel(String username) {
		this.username = username;
		f = new Font("SansSerif", Font.BOLD, 15);
		currentLayout = new SpringLayout();
		try {
			OnlineContests.reload();
			OnlineTestContests.reload();
			OnlinePracticeContests.reload();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		onlineContests = OnlineContests.getOnlineContests();
		onlineTestContests = OnlineTestContests.getOnlineTestContests();
		onlinePracticeContests = OnlinePracticeContests
				.getOnlinePracticeContests();
		onlineTestContests.retainAll(onlineContests);
		onlinePracticeContests.retainAll(onlineContests);
		setUpPanel();
	}

	private void setUpPanel() {
		int testcount = 0, practicecount = 0;
		for (String s : onlineContests) {
			if (onlineTestContests.contains(s))
				testcount++;
			if (onlinePracticeContests.contains(s))
				practicecount++;
		}

		setLayout(currentLayout);
		this.setSize(500, 400);

		JPanel cinfo = new JPanel(new GridLayout(1, 4));
		cinfo.setOpaque(true);
		cinfo.setBackground(Color.decode("#3c3f41"));
		cinfo.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.decode("#555555"), 1),
				new EmptyBorder(10, 10, 10, 10)));

		currentLayout.putConstraint(SpringLayout.NORTH, cinfo, 30,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, cinfo, -40,
				SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.WEST, cinfo, 40,
				SpringLayout.WEST, this);

		JLabel tcl = new JLabel("Total contests: " + onlineContests.size());
		tcl.setHorizontalAlignment(SwingConstants.CENTER);
		tcl.setVerticalAlignment(SwingConstants.CENTER);
		tcl.setOpaque(true);
		tcl.setForeground(Color.decode("#aaaaaa"));
		tcl.setBackground(Color.decode("#3c3f41"));
		tcl.setFont(f);
		cinfo.add(tcl);

		JLabel tscl = new JLabel("Test contests: " + testcount);
		tscl.setHorizontalAlignment(SwingConstants.CENTER);
		tscl.setVerticalAlignment(SwingConstants.CENTER);
		tscl.setOpaque(true);
		tscl.setForeground(Color.decode("#aaaaaa"));
		tscl.setBackground(Color.decode("#3c3f41"));
		tscl.setFont(f);
		cinfo.add(tscl);

		JLabel pcl = new JLabel("Practice contests: " + practicecount);
		pcl.setHorizontalAlignment(SwingConstants.CENTER);
		pcl.setVerticalAlignment(SwingConstants.CENTER);
		pcl.setOpaque(true);
		pcl.setForeground(Color.decode("#aaaaaa"));
		pcl.setBackground(Color.decode("#3c3f41"));
		pcl.setFont(f);
		cinfo.add(pcl);

		add(cinfo);

		// add "new contest" button

		JLabel jb = new JLabel("TEST CONTESTS");
		jb.setOpaque(false);
		jb.setForeground(Color.decode("#cccccc"));
		jb.setBorder(new EmptyBorder(10, 40, 10, 15));
		jb.setFont(new Font("SanSerif", Font.BOLD, 15));
		currentLayout.putConstraint(SpringLayout.NORTH, jb, 30,
				SpringLayout.SOUTH, cinfo);
		currentLayout.putConstraint(SpringLayout.EAST, jb, -40,
				SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.WEST, jb, 40,
				SpringLayout.WEST, this);
		this.add(jb);

		JLabel testicon = new JLabel(new ImageIcon(
				ContestsPanel.class.getResource("/img/testtypeicon.png")));
		testicon.setBorder(new EmptyBorder(10, 10, 10, 5));
		testicon.setOpaque(false);
		currentLayout.putConstraint(SpringLayout.NORTH, testicon, 0,
				SpringLayout.NORTH, jb);
		currentLayout.putConstraint(SpringLayout.WEST, testicon, 0,
				SpringLayout.WEST, jb);
		this.add(testicon);

		testpanelgrid = new JPanel();
		testpanelgrid.setOpaque(false);
		testpanelgrid.setBorder(new EmptyBorder(0, 0, 0, 0));
		currentLayout.putConstraint(SpringLayout.NORTH, testpanelgrid, 20,
				SpringLayout.SOUTH, jb);
		currentLayout.putConstraint(SpringLayout.WEST, testpanelgrid, 40,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.EAST, testpanelgrid, -40,
				SpringLayout.EAST, this);
		// testpanelgrid.setLayout(new ColumnsFlowLayout(10, 10));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		if (dim.getWidth() < 1300) {
			testpanelgrid.setLayout(new GridLayout(0, 5));
		} else {
			testpanelgrid.setLayout(new GridLayout(0, 8));
		}
		JLabel jb2 = new JLabel("PRACTICE CONTESTS");
		jb2.setOpaque(false);
		jb2.setForeground(Color.decode("#cccccc"));
		jb2.setBorder(new EmptyBorder(10, 40, 10, 10));
		jb2.setFont(new Font("SanSerif", Font.BOLD, 15));
		currentLayout.putConstraint(SpringLayout.NORTH, jb2, 30,
				SpringLayout.SOUTH, testpanelgrid);
		currentLayout.putConstraint(SpringLayout.EAST, jb2, -40,
				SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.WEST, jb2, 40,
				SpringLayout.WEST, this);
		this.add(jb2);

		practicepanelgrid = new JPanel();
		practicepanelgrid.setOpaque(false);
		practicepanelgrid.setBorder(new EmptyBorder(0, 0, 0, 0));
		currentLayout.putConstraint(SpringLayout.NORTH, practicepanelgrid, 20,
				SpringLayout.SOUTH, jb2);
		currentLayout.putConstraint(SpringLayout.WEST, practicepanelgrid, 40,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.EAST, practicepanelgrid, -40,
				SpringLayout.EAST, this);
		// practicepanelgrid.setLayout(new ColumnsFlowLayout(10, 10));

		if (dim.getWidth() < 1300) {
			practicepanelgrid.setLayout(new GridLayout(0, 5));
		} else {
			practicepanelgrid.setLayout(new GridLayout(0, 8));
		}
		// add other contest buttons
		
		if (onlineTestContests.isEmpty()) {

			JLabel emptylabel = new JLabel("         No Contest found.");
			emptylabel.setForeground(Color.decode("#aaaaaa"));
			emptylabel.setFont(new Font("SanSerif", Font.BOLD, 13));
			testpanelgrid.add(emptylabel);
		}

		if (onlinePracticeContests.isEmpty()) {
			JLabel emptylabel = new JLabel("         No Contest found.");
			emptylabel.setForeground(Color.decode("#aaaaaa"));
			emptylabel.setFont(new Font("SanSerif", Font.BOLD, 13));
			practicepanelgrid.add(emptylabel);
		}

		for (String c : onlineContests) {

			final JButton jl1 = new JButton(c.replace("_", " "), new ImageIcon(
					ContestsPanel.class.getResource("/img/table.png")));

			jl1.setOpaque(true);
			jl1.setContentAreaFilled(false);
			jl1.setVerticalTextPosition(SwingConstants.BOTTOM);
			jl1.setHorizontalTextPosition(SwingConstants.CENTER);
			jl1.setBorderPainted(false);
			jl1.setFocusPainted(false);
			jl1.setBorder(new EmptyBorder(10, 10, 10, 10));
			jl1.setFont(new Font("SanSerif", Font.BOLD, 15));
			jl1.setForeground(Color.decode("#aaaaaa"));

			if (onlineTestContests.contains(c)) {
				jl1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						new QCodeFrame(ContestsPanel.this, username, jl1
								.getText().replace(" ", "_")).setVisible(true);

					}
				});
				testpanelgrid.add(jl1);
			} else {

				jl1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						new AllQuestionsFrame(username, jl1.getText().replace(
								" ", "_")).setVisible(true);
						JFrame topFrame = (JFrame) SwingUtilities
								.getWindowAncestor(ContestsPanel.this);
						topFrame.dispose();

					}
				});
				practicepanelgrid.add(jl1);
			}

		}
		
				JLabel practiceicon = new JLabel(new ImageIcon(
						ContestsPanel.class.getResource("/img/practicetypeicon.png")));
				
						currentLayout.putConstraint(SpringLayout.NORTH, practiceicon, 0,
								SpringLayout.NORTH, jb2);
						currentLayout.putConstraint(SpringLayout.WEST, practiceicon, 0,
								SpringLayout.WEST, jb2);
				practiceicon.setBorder(new EmptyBorder(10, 10, 10, 5));
				practiceicon.setOpaque(false);
						this.add(practiceicon);

		add(testpanelgrid);
		add(practicepanelgrid);

		JPanel toolspanel = new JPanel(new GridLayout(1, 5));
		toolspanel.setOpaque(false);
		toolspanel.setBorder(new EmptyBorder(10, 10, 5, 10));
		currentLayout.putConstraint(SpringLayout.WEST, toolspanel, 0,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, toolspanel, 0,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, toolspanel, 0,
				SpringLayout.EAST, this);

		JBackgroundPanel panel_background = new JBackgroundPanel();
		currentLayout.putConstraint(SpringLayout.NORTH, panel_background, 0,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, panel_background, 0,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, panel_background, 0,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, panel_background, 0,
				SpringLayout.EAST, this);

		JButton btnRefresh = new JButton("Refresh", new ImageIcon(
				ContestsPanel.class.getResource("/img/Refreshicon.png")));
		btnRefresh.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRefresh.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRefresh.setActionCommand("Refresh");
		btnRefresh.setBorder(new EmptyBorder(2, 2, 2, 2));

		btnRefresh.setForeground(Color.decode("#cccccc"));
		btnRefresh.setOpaque(true);
		btnRefresh.setContentAreaFilled(false);

		btnRefresh.setFocusPainted(false);

		currentLayout.putConstraint(SpringLayout.SOUTH, btnRefresh, -5,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, btnRefresh, 20,
				SpringLayout.WEST, this);

		currentLayout.putConstraint(SpringLayout.SOUTH, btnRefresh, 0,
				SpringLayout.SOUTH, btnRefresh);
		btnRefresh.addActionListener(this);

		toolspanel.add(btnRefresh);

		JButton homebtn = new JButton("About CES", new ImageIcon(
				ContestsPanel.class.getResource("/img/ceshome.png")));
		homebtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		homebtn.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtn.setBorder(new EmptyBorder(2, 2, 2, 2));

		homebtn.setForeground(Color.decode("#cccccc"));
		homebtn.setOpaque(true);
		homebtn.setContentAreaFilled(false);

		homebtn.setFocusPainted(false);
		currentLayout.putConstraint(SpringLayout.WEST, homebtn, 20,
				SpringLayout.EAST, btnRefresh);
		currentLayout.putConstraint(SpringLayout.SOUTH, homebtn, -5,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.NORTH, homebtn, 0,
				SpringLayout.NORTH, btnRefresh);
		homebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutFrame().setVisible(true);
			}
		});
		toolspanel.add(homebtn);

		JButton helpbtn = new JButton("Help", new ImageIcon(
				ContestsPanel.class.getResource("/img/help.png")));
		helpbtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		helpbtn.setHorizontalTextPosition(SwingConstants.CENTER);
		helpbtn.setBorder(new EmptyBorder(2, 2, 2, 2));
		helpbtn.addActionListener(this);
		helpbtn.setForeground(Color.decode("#cccccc"));
		helpbtn.setOpaque(true);
		helpbtn.setContentAreaFilled(false);
		helpbtn.setBorderPainted(false);
		helpbtn.setFocusPainted(false);
		currentLayout.putConstraint(SpringLayout.SOUTH, helpbtn, -5,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, helpbtn, 20,
				SpringLayout.EAST, homebtn);
		currentLayout.putConstraint(SpringLayout.NORTH, helpbtn, 0,
				SpringLayout.NORTH, btnRefresh);
		toolspanel.add(helpbtn);

		JButton btnlogout = new JButton("Logout", new ImageIcon(
				ContestsPanel.class.getResource("/img/logout.png")));
		btnlogout.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnlogout.setHorizontalTextPosition(SwingConstants.CENTER);
		btnlogout.setForeground(Color.decode("#cccccc"));
		btnlogout.setOpaque(true);
		btnlogout.setContentAreaFilled(false);
		btnlogout.setBorderPainted(false);
		btnlogout.setFocusPainted(false);
		currentLayout.putConstraint(SpringLayout.SOUTH, btnlogout, -5,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, btnlogout, 20,
				SpringLayout.EAST, helpbtn);
		currentLayout.putConstraint(SpringLayout.NORTH, btnlogout, 0,
				SpringLayout.NORTH, btnRefresh);
		btnlogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog(getParent(),
						"Are you sure you want to logout from " + username
								+ "?", "Logout", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					new LoginMainFrame().setVisible(true);
					JFrame topFrame = (JFrame) SwingUtilities
							.getWindowAncestor(ContestsPanel.this);
					topFrame.dispose();
				}
			}
		});
		toolspanel.add(btnlogout);

		JButton btnusername = new JButton(username, new ImageIcon(
				ContestsPanel.class.getResource("/img/basicicon.png")));
		btnusername.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnusername.setHorizontalTextPosition(SwingConstants.CENTER);
		btnusername.setForeground(Color.decode("#cccccc"));
		btnusername.setOpaque(true);
		btnusername.setContentAreaFilled(false);
		btnusername.setBorderPainted(false);
		btnusername.setFocusPainted(false);
		currentLayout.putConstraint(SpringLayout.SOUTH, btnusername, -5,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, btnusername, 20,
				SpringLayout.EAST, btnlogout);
		currentLayout.putConstraint(SpringLayout.NORTH, btnusername, 0,
				SpringLayout.NORTH, btnRefresh);

		toolspanel.add(btnusername);
		add(toolspanel);
		ToolsBackgroundPanel toolbar = new ToolsBackgroundPanel();
		toolbar.setOpaque(false);
		currentLayout.putConstraint(SpringLayout.NORTH, toolbar, 38,
				SpringLayout.NORTH, toolspanel);
		currentLayout.putConstraint(SpringLayout.WEST, toolbar, 0,
				SpringLayout.WEST, toolspanel);
		currentLayout.putConstraint(SpringLayout.SOUTH, toolbar, 0,
				SpringLayout.SOUTH, toolspanel);
		currentLayout.putConstraint(SpringLayout.EAST, toolbar, 0,
				SpringLayout.EAST, toolspanel);
		add(toolbar);

		add(panel_background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String button = e.getActionCommand();
		if (button.equals("Refresh")) {
			refreshpane();
		} else if (button.equals("Help")) {
			new HelpFrame().setVisible(true);
		}

	}

	void refreshpane() {
		try {

			OnlineContests.reload();
			OnlineTestContests.reload();
			OnlinePracticeContests.reload();
		} catch (SQLException ev) {

			ev.printStackTrace();
		}
		onlineContests = OnlineContests.getOnlineContests();
		onlineTestContests = OnlineTestContests.getOnlineTestContests();
		onlinePracticeContests = OnlinePracticeContests
				.getOnlinePracticeContests();
		onlineTestContests.retainAll(onlineContests);
		onlinePracticeContests.retainAll(onlineContests);
		removeAll();

		setUpPanel();
		revalidate();
		repaint();
	}
}
