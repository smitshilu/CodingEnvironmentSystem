package gui.ContestsPackage.contest;

import gui.CommonPackage.JBackgroundPanel;
import gui.CommonPackage.ToolsBackgroundPanel;
import gui.ContestsPackage.contest.about.AboutFrame;
import gui.ContestsPackage.contest.help.HelpFrame;
import gui.ContestsPackage.newcontest.NewContestFrame;
import gui.login.LoginMainframe;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.apache.commons.io.FileUtils;

import session.StartServer;
import database.delete.DeleteAllContests;

@SuppressWarnings("serial")
public class ContestPanel extends JPanel implements ActionListener {
	private SpringLayout currentLayout;

	GridLayoutContests panelgrid;
	String username = "";
	StartServer ss = new StartServer();

	public ContestPanel(String username) {
		this.username = username;
		currentLayout = new SpringLayout();

		setUpPanel();
	}

	private void setUpPanel() {

		setLayout(currentLayout);
		this.setSize(500, 400);

		// add "new contest" button
		panelgrid = new GridLayoutContests(username);
		panelgrid.setOpaque(false);
		panelgrid.setBorder(new EmptyBorder(2, 2, 2, 2));
		currentLayout.putConstraint(SpringLayout.NORTH, panelgrid, 10,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, panelgrid, 0,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, panelgrid, -80,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, panelgrid, 0,
				SpringLayout.EAST, this);
		// panelgrid.setLayout(new ColumnsFlowLayout(10, 10));

		add(panelgrid);

		JBackgroundPanel panel_background = new JBackgroundPanel();
		// panel_background.setBorder(BorderFactory.createLineBorder(
		// Color.decode("#555555"), 1));
		currentLayout.putConstraint(SpringLayout.NORTH, panel_background, 0,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, panel_background, 0,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, panel_background, 0,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, panel_background, 0,
				SpringLayout.EAST, this);

		setBackground(Color.decode("#3c3f41"));
		setBorder(BorderFactory.createLineBorder(Color.decode("#555555"), 1));

		JPanel toolspanel = new JPanel(new GridLayout(1, 8));
		toolspanel.setOpaque(false);
		toolspanel.setBorder(new EmptyBorder(10, 10, 5, 10));
		currentLayout.putConstraint(SpringLayout.WEST, toolspanel, 0,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, toolspanel, 0,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, toolspanel, 0,
				SpringLayout.EAST, this);
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {

			e1.printStackTrace();
		}
		final JToggleButton jtb = new JToggleButton(ip,
				new ImageIcon(
						GridLayoutContests.class
								.getResource("/img/serverisonline.png")));
		jtb.setToolTipText("Server status");
		jtb.setSelected(false);

		jtb.setSelectedIcon(new ImageIcon(ContestPanel.class
				.getResource("/img/serverisoffline.png")));
		jtb.setBorder(new EmptyBorder(2, 2, 2, 2));

		jtb.setVerticalTextPosition(SwingConstants.BOTTOM);
		jtb.setHorizontalTextPosition(SwingConstants.CENTER);
		// jtb.setFont(new Font("SanSerif", Font.BOLD, 15));
		jtb.setForeground(Color.decode("#cccccc"));
		jtb.setOpaque(true);
		jtb.setFocusPainted(false);
		jtb.setContentAreaFilled(false);

		jtb.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == ItemEvent.SELECTED) {
					ss.putOffline();
				} else if (ev.getStateChange() == ItemEvent.DESELECTED) {
					ss.putOnline();
				}
			}
		});
		toolspanel.add(jtb);

		JButton jl_add = new JButton("Add Contest", new ImageIcon(
				ContestPanel.class.getResource("/img/table.png")));

		jl_add.setBorder(new EmptyBorder(2, 2, 2, 2));

		jl_add.setVerticalTextPosition(SwingConstants.BOTTOM);
		jl_add.setHorizontalTextPosition(SwingConstants.CENTER);
		// jl_add.setFont(new Font("SanSerif", Font.BOLD, 15));
		jl_add.setForeground(Color.decode("#cccccc"));
		jl_add.setOpaque(true);
		jl_add.setFocusPainted(false);
		jl_add.setContentAreaFilled(false);

		jl_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewContestFrame(panelgrid).setVisible(true);
			}
		});
		toolspanel.add(jl_add);

		JButton btnRefresh = new JButton("Refresh", new ImageIcon(
				ContestPanel.class.getResource("/img/Refreshicon.png")));
		btnRefresh.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRefresh.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRefresh.setActionCommand("Refresh");
		btnRefresh.setBorder(new EmptyBorder(2, 2, 2, 2));

		btnRefresh.setForeground(Color.decode("#cccccc"));
		btnRefresh.setOpaque(true);
		btnRefresh.setContentAreaFilled(false);

		btnRefresh.setFocusPainted(false);

		btnRefresh.addActionListener(this);

		toolspanel.add(btnRefresh);

		JButton button = new JButton("Delete All", new ImageIcon(
				ContestPanel.class.getResource("/img/deleteall_small.png")));
		button.setBorder(new EmptyBorder(2, 2, 2, 2));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);

		button.setForeground(Color.decode("#cccccc"));
		button.setOpaque(true);
		button.setContentAreaFilled(false);

		button.setFocusPainted(false);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(getParent(),
						"Are you sure you want to delete all contests?",
						"Delete Contests", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						new DeleteAllContests();
						for (File f : (new File("C:/CES/")).listFiles()) {
							if (!f.getName().equals("settings.txt"))
								FileUtils.deleteDirectory(f);
						}

						JOptionPane.showMessageDialog(getParent(),
								"Successfully deleted all contests.");
						refreshpane();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getParent(),
								"Failed to delete all contests.");
					}

				} else {

				}
			}
		});
		toolspanel.add(button);

		JButton homebtn = new JButton("About CES", new ImageIcon(
				ContestPanel.class.getResource("/img/ceshome.png")));
		homebtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		homebtn.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtn.setBorder(new EmptyBorder(2, 2, 2, 2));
		homebtn.addActionListener(this);
		homebtn.setForeground(Color.decode("#cccccc"));
		homebtn.setOpaque(true);
		homebtn.setContentAreaFilled(false);

		homebtn.setFocusPainted(false);

		toolspanel.add(homebtn);

		JButton helpbtn = new JButton("Help", new ImageIcon(
				ContestPanel.class.getResource("/img/help.png")));
		helpbtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		helpbtn.setHorizontalTextPosition(SwingConstants.CENTER);
		helpbtn.setBorder(new EmptyBorder(2, 2, 2, 2));
		helpbtn.setActionCommand("Help");
		helpbtn.addActionListener(this);
		helpbtn.setForeground(Color.decode("#cccccc"));
		helpbtn.setOpaque(true);
		helpbtn.setContentAreaFilled(false);
		helpbtn.setBorderPainted(false);
		helpbtn.setFocusPainted(false);

		toolspanel.add(helpbtn);

		JButton btnlogout = new JButton("Logout", new ImageIcon(
				ContestPanel.class.getResource("/img/logout.png")));
		btnlogout.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnlogout.setHorizontalTextPosition(SwingConstants.CENTER);
		btnlogout.setForeground(Color.decode("#cccccc"));
		btnlogout.setOpaque(true);
		btnlogout.setContentAreaFilled(false);
		btnlogout.setBorderPainted(false);
		btnlogout.setFocusPainted(false);

		btnlogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog(getParent(),
						"Are you sure you want to logout from " + username
								+ "?", "Logout", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					ss.putOffline();
					JFrame topFrame = (JFrame) SwingUtilities
							.getWindowAncestor(ContestPanel.this);
					topFrame.dispose();
					new LoginMainframe().setVisible(true);
				}
			}
		});
		toolspanel.add(btnlogout);

		final JButton btnusername = new JButton(username, new ImageIcon(
				ContestPanel.class.getResource("/img/adminicon.png")));
		btnusername.setActionCommand("Account");
		btnusername.addActionListener(this);
		btnusername.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnusername.setHorizontalTextPosition(SwingConstants.CENTER);
		btnusername.setForeground(Color.decode("#cccccc"));
		btnusername.setOpaque(true);
		btnusername.setContentAreaFilled(false);
		btnusername.setBorderPainted(false);
		btnusername.setFocusPainted(false);
		btnusername.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				// btnusername.setIcon(new ImageIcon(
				// ContestPanel.class.getResource("/img/admin.png")));
			}

			public void mouseExited(MouseEvent evt) {
				// btnusername.setIcon(new ImageIcon(
				// ContestPanel.class.getResource("/img/adminicon.png")));

			}

		});
		btnusername.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().browse(
							new URI("http://localhost/CES/insertaccount.php"));
				} catch (IOException e1) {

					e1.printStackTrace();
				} catch (URISyntaxException e1) {

					e1.printStackTrace();
				}
			}
		});
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
	public void actionPerformed(ActionEvent arg0) {
		String button = arg0.getActionCommand();
		if (button.equals("Refresh")) {
			panelgrid.refreshpane();
		} else if (button.equals("Help")) {
			new HelpFrame().setVisible(true);
		} else if (button.equals("About CES")) {
			new AboutFrame().setVisible(true);
		} else if (button.equals("Account")) {
			//new AccountFrame().setVisible(true);
		}

	}

	public void refreshpane() {
		panelgrid.refreshpane();
	}

}
