package gui.MainPackage;

import gui.LeaderboardPackage.LeaderboardPanel;
import gui.QuestionsPackage.questions.QuestionsPanel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	LeaderboardPanel leaderboardPanel;

	public MainPanel(String contestname) {

		setUpPanel(contestname);
	}

	private void setUpPanel(String contestname) {

		this.setVisible(true);

		ImageIcon icon = null;
		JTabbedPane jtbExample = new JTabbedPane();
		jtbExample.setBackground(Color.decode("#aaaaaa"));
		jtbExample.setOpaque(true);

		JPanel questionsPanel = new QuestionsPanel(contestname);

		jtbExample.addTab("Contest questions", icon, questionsPanel,
				"Contest questions");
		jtbExample.setSelectedIndex(0);

		leaderboardPanel = new LeaderboardPanel(contestname);
		jtbExample.addTab("Leaderboard", icon, leaderboardPanel);

		// Add the tabbed pane to this panel.
		setLayout(new GridLayout(1, 1));
		add(jtbExample);

	}

	public void refresh() {
		leaderboardPanel.removeAll();
		leaderboardPanel.refresh("TotalAccepted");
		leaderboardPanel.revalidate();
		leaderboardPanel.repaint();
	}
}
