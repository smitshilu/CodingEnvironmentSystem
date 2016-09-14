package gui.ContestsPackage.contest;

import gui.CommonPackage.JBackgroundPanel;
import gui.MainPackage.MainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import objectclasses.AllContests;
import objectclasses.Contest;
import objectclasses.OnlineContests;
import objectclasses.PracticeContests;
import objectclasses.TestContests;

@SuppressWarnings("serial")
public class GridLayoutContests extends JPanel implements
		MyPopUpSelectionListener {

	SpringLayout currentLayout, currentLayout2;
	Font f;
	List<Contest> allContests = new ArrayList<Contest>();
	List<String> onlineContests = new ArrayList<String>();
	List<String> testContests = new ArrayList<String>();
	List<String> practiceContests = new ArrayList<String>();
	JPanel cinfo;
	JPanel testPanel, practicePanel;
	String username = "";

	public GridLayoutContests(String username) {
		try {
			AllContests.reload();
			OnlineContests.reload();
			TestContests.reload();
			PracticeContests.reload();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		allContests = AllContests.getAllContests();
		onlineContests = OnlineContests.getOnlineContests();
		testContests = TestContests.getTestContests();
		practiceContests = PracticeContests.getPracticeContests();
		this.username = username;
		currentLayout = new SpringLayout();
		currentLayout2 = new SpringLayout();
		f = new Font("SansSerif", Font.BOLD, 15);
		setUpPanel();

	}

	void setUpPanel() {

		setLayout(currentLayout2);

		JScrollPane scrollpane = new JScrollPane();
		currentLayout2.putConstraint(SpringLayout.NORTH, scrollpane, 0,
				SpringLayout.NORTH, this);
		currentLayout2.putConstraint(SpringLayout.WEST, scrollpane, 0,
				SpringLayout.WEST, this);
		currentLayout2.putConstraint(SpringLayout.EAST, scrollpane, 0,
				SpringLayout.EAST, this);
		currentLayout2.putConstraint(SpringLayout.SOUTH, scrollpane, 0,
				SpringLayout.SOUTH, this);

		JPanel mainpanel = new JPanel(currentLayout);

		mainpanel.setOpaque(false);
		// currentLayout.putConstraint(SpringLayout.NORTH, mainpanel, 0,
		// SpringLayout.NORTH, c);
		// currentLayout.putConstraint(SpringLayout.WEST, mainpanel, 0,
		// SpringLayout.WEST, c);
		// currentLayout.putConstraint(SpringLayout.EAST, mainpanel, 0,
		// SpringLayout.EAST, c);
		// currentLayout.putConstraint(SpringLayout.SOUTH, mainpanel, 0,
		// SpringLayout.SOUTH, c);

		JViewport viewport = new JViewport();
		viewport.setView(mainpanel);

		// scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setViewport(viewport);
		scrollpane.getViewport().setOpaque(false);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		scrollpane.setOpaque(false);
		add(scrollpane);

		cinfo = new JPanel(new GridLayout(1, 4));
		cinfo.setOpaque(true);
		cinfo.setBackground(Color.decode("#3c3f41"));
		cinfo.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.decode("#555555"), 1),
				new EmptyBorder(10, 10, 10, 10)));

		currentLayout.putConstraint(SpringLayout.NORTH, cinfo, 20,
				SpringLayout.NORTH, mainpanel);
		currentLayout.putConstraint(SpringLayout.EAST, cinfo, -40,
				SpringLayout.EAST, mainpanel);
		currentLayout.putConstraint(SpringLayout.WEST, cinfo, 40,
				SpringLayout.WEST, mainpanel);

		countpane();

		mainpanel.add(cinfo);

		// TEST CONTESTS
		JLabel jb = new JLabel("TEST CONTESTS");
		jb.setOpaque(false);
		jb.setForeground(Color.decode("#cccccc"));
		jb.setBorder(new EmptyBorder(10, 40, 10, 15));
		jb.setFont(new Font("SanSerif", Font.BOLD, 15));
		currentLayout.putConstraint(SpringLayout.NORTH, jb, 30,
				SpringLayout.SOUTH, cinfo);
		currentLayout.putConstraint(SpringLayout.EAST, jb, -40,
				SpringLayout.EAST, mainpanel);
		currentLayout.putConstraint(SpringLayout.WEST, jb, 40,
				SpringLayout.WEST, mainpanel);
		mainpanel.add(jb);

		JLabel testicon = new JLabel(new ImageIcon(
				GridLayoutContests.class.getResource("/img/testtypeicon.png")));
		testicon.setBorder(new EmptyBorder(10, 10, 10, 5));
		testicon.setOpaque(false);
		currentLayout.putConstraint(SpringLayout.NORTH, testicon, 0,
				SpringLayout.NORTH, jb);
		currentLayout.putConstraint(SpringLayout.WEST, testicon, 0,
				SpringLayout.WEST, jb);
		mainpanel.add(testicon);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		if (dim.getWidth() < 1300) {
			testPanel = new JPanel(new GridLayout(0, 5, 10, 10));
		} else {
			testPanel = new JPanel(new GridLayout(0, 8, 10, 10));
		}
		testPanel.setOpaque(false);
		currentLayout.putConstraint(SpringLayout.NORTH, testPanel, 10,
				SpringLayout.SOUTH, jb);
		currentLayout.putConstraint(SpringLayout.EAST, testPanel, -40,
				SpringLayout.EAST, mainpanel);
		currentLayout.putConstraint(SpringLayout.WEST, testPanel, 40,
				SpringLayout.WEST, mainpanel);

		addTestContests(testPanel);

		mainpanel.add(testPanel);

		// PRACTICE CONTESTS

		JLabel jb2 = new JLabel("PRACTICE CONTESTS");
		jb2.setOpaque(false);
		jb2.setForeground(Color.decode("#cccccc"));
		jb2.setBorder(new EmptyBorder(10, 40, 10, 10));
		jb2.setFont(new Font("SanSerif", Font.BOLD, 15));
		currentLayout.putConstraint(SpringLayout.NORTH, jb2, 40,
				SpringLayout.SOUTH, testPanel);
		currentLayout.putConstraint(SpringLayout.EAST, jb2, -40,
				SpringLayout.EAST, mainpanel);
		currentLayout.putConstraint(SpringLayout.WEST, jb2, 40,
				SpringLayout.WEST, mainpanel);
		mainpanel.add(jb2);

		JLabel practiceicon = new JLabel(new ImageIcon(
				GridLayoutContests.class
						.getResource("/img/practicetypeicon.png")));
		practiceicon.setBorder(new EmptyBorder(10, 10, 10, 5));
		practiceicon.setOpaque(false);

		currentLayout.putConstraint(SpringLayout.NORTH, practiceicon, 0,
				SpringLayout.NORTH, jb2);
		currentLayout.putConstraint(SpringLayout.WEST, practiceicon, 0,
				SpringLayout.WEST, jb2);
		mainpanel.add(practiceicon);
		if (dim.getWidth() < 1300) {
			practicePanel = new JPanel(new GridLayout(0, 5, 10, 10));
		} else {
			practicePanel = new JPanel(new GridLayout(0, 8, 10, 10));
		}
		practicePanel.setOpaque(false);
		currentLayout.putConstraint(SpringLayout.NORTH, practicePanel, 10,
				SpringLayout.SOUTH, jb2);
		currentLayout.putConstraint(SpringLayout.EAST, practicePanel, -40,
				SpringLayout.EAST, mainpanel);
		currentLayout.putConstraint(SpringLayout.WEST, practicePanel, 40,
				SpringLayout.WEST, mainpanel);

		addPracticeContests(practicePanel);

		mainpanel.add(practicePanel);

		JBackgroundPanel panel_background = new JBackgroundPanel();
		currentLayout2.putConstraint(SpringLayout.NORTH, panel_background, 0,
				SpringLayout.NORTH, this);
		currentLayout2.putConstraint(SpringLayout.WEST, panel_background, 0,
				SpringLayout.WEST, this);
		currentLayout2.putConstraint(SpringLayout.SOUTH, panel_background, 0,
				SpringLayout.SOUTH, this);
		currentLayout2.putConstraint(SpringLayout.EAST, panel_background, 0,
				SpringLayout.EAST, this);
		add(panel_background);

	}

	private void addPracticeContests(JPanel practicePanel) {

		if (practiceContests.isEmpty()) {

			JLabel emptylabel = new JLabel("      No Contest found.");
			emptylabel.setForeground(Color.decode("#aaaaaa"));
			emptylabel.setFont(new Font("SanSerif", Font.BOLD, 13));

			practicePanel.add(emptylabel);
		}
		for (Contest c : allContests) {
			if (practiceContests.contains(c.getContestName())) {
				final JButton jl1;
				if (onlineContests.contains(c.getContestName())) {
					jl1 = new JButton(c.getContestName().replace("_", " "),
							new ImageIcon(ContestPanel.class
									.getResource("/img/table_accept.png")));

					jl1.addMouseListener(new MouseAdapterPracticeOnline(jl1
							.getText().replace(" ", "_")));
				}

				else {
					jl1 = new JButton(c.getContestName().replace("_", " "),
							new ImageIcon(ContestPanel.class
									.getResource("/img/table_delete2.png")));

					jl1.addMouseListener(new MouseAdapterPracticeOffline(jl1
							.getText().replace(" ", "_")));

				}
				jl1.setOpaque(true);
				jl1.setContentAreaFilled(false);
				jl1.setVerticalTextPosition(SwingConstants.BOTTOM);
				jl1.setHorizontalTextPosition(SwingConstants.CENTER);
				jl1.setBorderPainted(false);
				jl1.setFocusPainted(false);
				jl1.setBorder(new EmptyBorder(10, 10, 10, 10));
				jl1.setFont(new Font("SanSerif", Font.BOLD, 15));
				jl1.setForeground(Color.decode("#aaaaaa"));
				jl1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						new MainFrame(jl1.getText().replace(" ", "_"))
								.setVisible(true);

					}
				});

				practicePanel.add(jl1);

			}
		}
	}

	private void addTestContests(JPanel testPanel) {

		if (testContests.isEmpty()) {

			JLabel emptylabel = new JLabel("      No Contest found.");
			emptylabel.setForeground(Color.decode("#aaaaaa"));
			emptylabel.setFont(new Font("SanSerif", Font.BOLD, 13));
			testPanel.add(emptylabel);
		}
		for (Contest c : allContests) {
			if (testContests.contains(c.getContestName())) {
				final JButton jl1;
				if (onlineContests.contains(c.getContestName())) {
					jl1 = new JButton(c.getContestName().replace("_", " "),
							new ImageIcon(ContestPanel.class
									.getResource("/img/table_accept.png")));

					jl1.addMouseListener(new MouseAdapterTestOnline(jl1
							.getText().replace(" ", "_")));

				} else {
					jl1 = new JButton(c.getContestName().replace("_", " "),
							new ImageIcon(ContestPanel.class
									.getResource("/img/table_delete2.png")));

					jl1.addMouseListener(new MouseAdapterTestOffline(jl1
							.getText().replace(" ", "_")));

				}
				jl1.setOpaque(true);
				jl1.setContentAreaFilled(false);
				jl1.setVerticalTextPosition(SwingConstants.BOTTOM);
				jl1.setHorizontalTextPosition(SwingConstants.CENTER);
				jl1.setBorderPainted(false);
				jl1.setFocusPainted(false);
				jl1.setBorder(new EmptyBorder(10, 10, 10, 10));
				jl1.setFont(new Font("SanSerif", Font.BOLD, 15));
				jl1.setForeground(Color.decode("#aaaaaa"));
				jl1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new MainFrame(jl1.getText().replace(" ", "_"))
								.setVisible(true);
					}
				});

				testPanel.add(jl1);

			}
		}
	}

	void countpane() {
		JLabel tcl = new JLabel("Total contests: " + allContests.size());
		tcl.setHorizontalAlignment(SwingConstants.CENTER);
		tcl.setVerticalAlignment(SwingConstants.CENTER);
		tcl.setOpaque(true);
		tcl.setForeground(Color.decode("#aaaaaa"));
		tcl.setBackground(Color.decode("#3c3f41"));
		tcl.setFont(f);
		cinfo.add(tcl);

		JLabel tscl = new JLabel("Test contests: " + testContests.size());
		tscl.setHorizontalAlignment(SwingConstants.CENTER);
		tscl.setVerticalAlignment(SwingConstants.CENTER);
		tscl.setOpaque(true);
		tscl.setForeground(Color.decode("#aaaaaa"));
		tscl.setBackground(Color.decode("#3c3f41"));
		tscl.setFont(f);
		cinfo.add(tscl);

		JLabel pcl = new JLabel("Practice contests: " + practiceContests.size());
		pcl.setHorizontalAlignment(SwingConstants.CENTER);
		pcl.setVerticalAlignment(SwingConstants.CENTER);
		pcl.setOpaque(true);
		pcl.setForeground(Color.decode("#aaaaaa"));
		pcl.setBackground(Color.decode("#3c3f41"));
		pcl.setFont(f);
		cinfo.add(pcl);

		JLabel ocl = new JLabel("Online contests: " + onlineContests.size());
		ocl.setHorizontalAlignment(SwingConstants.CENTER);
		ocl.setVerticalAlignment(SwingConstants.CENTER);
		ocl.setOpaque(true);
		ocl.setForeground(Color.decode("#aaaaaa"));
		ocl.setBackground(Color.decode("#3c3f41"));
		ocl.setFont(f);
		cinfo.add(ocl);
	}

	public void refreshpane() {

		try {
			AllContests.reload();
			OnlineContests.reload();
			TestContests.reload();
			PracticeContests.reload();
			allContests = null;
			allContests = AllContests.getAllContests();
			onlineContests = null;
			onlineContests = OnlineContests.getOnlineContests();
			testContests = null;
			testContests = TestContests.getTestContests();
			practiceContests = null;
			practiceContests = PracticeContests.getPracticeContests();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		testPanel.removeAll();
		practicePanel.removeAll();
		cinfo.removeAll();
		addTestContests(testPanel);
		addPracticeContests(practicePanel);
		countpane();
		testPanel.revalidate();
		practicePanel.revalidate();
		cinfo.revalidate();
		testPanel.repaint();
		practicePanel.repaint();
		cinfo.repaint();

	}

	class MouseAdapterPracticeOnline extends MouseAdapter {
		String name = "";

		MouseAdapterPracticeOnline(String name) {
			this.name = name;
		}

		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger())
				doPop(e);
		}

		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger())
				doPop(e);

		}

		private void doPop(MouseEvent e) {
			PopUpMenuPracticeOnline menu = new PopUpMenuPracticeOnline(name,
					GridLayoutContests.this);
			menu.show(e.getComponent(), e.getX(), e.getY());

		}
	}

	class MouseAdapterTestOnline extends MouseAdapter {
		String name = "";

		MouseAdapterTestOnline(String name) {
			this.name = name;
		}

		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger())
				doPop(e);
		}

		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger())
				doPop(e);

		}

		private void doPop(MouseEvent e) {
			PopUpMenuTestOnline menu = new PopUpMenuTestOnline(name,
					GridLayoutContests.this);
			menu.show(e.getComponent(), e.getX(), e.getY());

		}
	}

	class MouseAdapterTestOffline extends MouseAdapter {
		String name = "";

		MouseAdapterTestOffline(String name) {
			this.name = name;
		}

		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger())
				doPop(e);

		}

		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger())
				doPop(e);

		}

		private void doPop(MouseEvent e) {
			PopUpMenuTestOffline menu = new PopUpMenuTestOffline(name,
					GridLayoutContests.this);
			menu.show(e.getComponent(), e.getX(), e.getY());

		}
	}

	class MouseAdapterPracticeOffline extends MouseAdapter {
		String name = "";

		MouseAdapterPracticeOffline(String name) {
			this.name = name;
		}

		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger())
				doPop(e);

		}

		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger())
				doPop(e);

		}

		private void doPop(MouseEvent e) {
			PopUpMenuPracticeOffline menu = new PopUpMenuPracticeOffline(name,
					GridLayoutContests.this);
			menu.show(e.getComponent(), e.getX(), e.getY());

		}
	}

}
