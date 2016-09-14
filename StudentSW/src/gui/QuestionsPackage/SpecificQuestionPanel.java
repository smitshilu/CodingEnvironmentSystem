package gui.QuestionsPackage;

import gui.CommonPackage.JBackgroundPanel;
import gui.CommonPackage.SettingsHash;
import gui.ContestsPackage.ContestsFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JViewport;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import objectclasses.Question;
import database.load.LoadSpecificQuestion;

@SuppressWarnings("serial")
public class SpecificQuestionPanel extends JPanel implements ListSelectionListener {
	private SpringLayout currentLayout, rightc;
	List<Question> questions;
	List<String> listdata;
	@SuppressWarnings("rawtypes")
	JList list;
	StringBuilder qustn_detail = new StringBuilder();
	JPanel rightComponent;
	int index = 0;
	JLabel qstndetail;
	String contestname = "", username = "";

	public SpecificQuestionPanel(String username, String contestname,
			String questioncode) {
		this.username = username;
		questions = new ArrayList<Question>();
		listdata = new ArrayList<String>();
		currentLayout = new SpringLayout();
		LoadSpecificQuestion lq = new LoadSpecificQuestion(contestname,
				questioncode,username);
		// LoadQuestions lq = new LoadQuestions(contestname);
		questions = lq.loadAllQuestions();

		for (Question q : questions) {
			listdata.add(q.getQ_name());
		}
		this.contestname = contestname;

		setUpPanel();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setUpPanel() {
		this.setSize(700, 400);
		this.setVisible(true);

		setLayout(currentLayout);
		SpringLayout leftspring = new SpringLayout();
		JPanel leftComponent = new JPanel(leftspring);
		leftComponent.setBackground(Color.decode("#3c3f41"));
		JButton backBtn = new JButton(
				"Back to Contests",
				new ImageIcon(SpecificQuestionPanel.class.getResource("/img/backicon_small.png")));
		backBtn.setOpaque(true);
		backBtn.setContentAreaFilled(false);
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		backBtn.setForeground(Color.decode("#aaaaaa"));
		leftspring.putConstraint(SpringLayout.NORTH, backBtn, 0,
				SpringLayout.NORTH, leftComponent);
		leftspring.putConstraint(SpringLayout.WEST, backBtn, 0,
				SpringLayout.WEST, leftComponent);

		leftspring.putConstraint(SpringLayout.EAST, backBtn, 0,
				SpringLayout.EAST, leftComponent);
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ContestsFrame(username).setVisible(true);
				JFrame topFrame = (JFrame) SwingUtilities
						.getWindowAncestor(SpecificQuestionPanel.this);
				topFrame.dispose();
			}
		});
		leftComponent.add(backBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createLineBorder(
				Color.decode("#555555"), 1));
		leftspring.putConstraint(SpringLayout.NORTH, scrollPane, 0,
				SpringLayout.SOUTH, backBtn);
		leftspring.putConstraint(SpringLayout.WEST, scrollPane, 0,
				SpringLayout.WEST, leftComponent);
		leftspring.putConstraint(SpringLayout.SOUTH, scrollPane, 0,
				SpringLayout.SOUTH, leftComponent);
		leftspring.putConstraint(SpringLayout.EAST, scrollPane, 0,
				SpringLayout.EAST, leftComponent);

		list = new JList(listdata.toArray());
		list.setSelectedIndex(0);
		list.setFont(new Font("SansSerif", Font.BOLD, 15));
		// list.setBorder(BorderFactory.createEmptyBorder());
		list.setBackground(Color.decode("#3c3f41"));
		list.setForeground(Color.decode("#aaaaaa"));
		scrollPane.setViewportView(list);
		leftComponent.add(scrollPane);

		list.addListSelectionListener(this);

		rightc = new SpringLayout();
		rightComponent = new JPanel(rightc);
		if (!questions.isEmpty()) {

			qustn_detail.delete(0, qustn_detail.length());

			JScrollPane scrollPane2 = new JScrollPane();
			rightc.putConstraint(SpringLayout.EAST, rightComponent, 0,
					SpringLayout.EAST, scrollPane2);
			rightc.putConstraint(SpringLayout.WEST, rightComponent, 0,
					SpringLayout.WEST, scrollPane2);
			rightc.putConstraint(SpringLayout.NORTH, rightComponent, 0,
					SpringLayout.NORTH, scrollPane2);
			rightc.putConstraint(SpringLayout.SOUTH, rightComponent, 35,
					SpringLayout.SOUTH, scrollPane2);
			Question tempq = questions.get(index);
			currentQuestion.setCurrentQ(tempq.getQ_name());
			qustn_detail
					.append("<html><font size=\"5\"><b>Question code: </b></font>"
							+ tempq.getQ_name() + "<br><br>");
			qustn_detail.append("<font size=\"5\"><b>Question: </b></font><br>"
					+ tempq.getQ_qstn().replace("\n", "<br>") + "<br><br>");
			qustn_detail.append("<font size=\"5\"><b>Sample Input: </b></font>"
					+ tempq.getQ_ip().replace("\n", "<br>") + "<br><br>");
			qustn_detail
					.append("<font size=\"5\"><b>Sample Output: </b></font>"
							+ tempq.getQ_op().replace("\n", "<br>") + "<br><br>");
			qustn_detail.append("<font size=\"5\"><b>Constraints: </b></font>"
					+ tempq.getQ_cons().replace("\n", "<br>") + "<br><br>");
			qustn_detail.append("<font size=\"5\"><b>Explanation: </b></font>"
					+ tempq.getQ_ex().replace("\n", "<br>") + "<br><br></html>");

			qstndetail = new JLabel(String.format(
					"<html><div WIDTH=%d>%s</div><html>", 450,
					qustn_detail.toString()));
			qstndetail.setBackground(Color.decode("#3c3f41"));
			qstndetail.setBorder(new EmptyBorder(10, 10, 10, 10));
			qstndetail.setForeground(Color.decode("#aaaaaa"));

			JViewport viewport = new JViewport();
			viewport.setView(qstndetail);
			viewport.setOpaque(false);

			scrollPane2.setViewport(viewport);

			scrollPane2.getViewport().setOpaque(false);
			scrollPane2.setBorder(BorderFactory.createEmptyBorder());
			scrollPane2.setOpaque(false);

			rightComponent.add(scrollPane2);

			ToolsPanel submitpane = new ToolsPanel(SettingsHash.getSetting("Host"), username,
					contestname);
			rightc.putConstraint(SpringLayout.NORTH, submitpane, 0,
					SpringLayout.SOUTH, scrollPane2);
			rightc.putConstraint(SpringLayout.WEST, submitpane, 0,
					SpringLayout.WEST, rightComponent);
			rightc.putConstraint(SpringLayout.SOUTH, submitpane, 0,
					SpringLayout.SOUTH, rightComponent);
			rightc.putConstraint(SpringLayout.EAST, submitpane, 0,
					SpringLayout.EAST, rightComponent);
			rightComponent.add(submitpane);

			JBackgroundPanel panel_background = new JBackgroundPanel();
			panel_background.setBorder(BorderFactory.createLineBorder(
					Color.decode("#555555"), 1));
			rightc.putConstraint(SpringLayout.NORTH, panel_background, 0,
					SpringLayout.NORTH, rightComponent);
			rightc.putConstraint(SpringLayout.WEST, panel_background, 0,
					SpringLayout.WEST, rightComponent);
			rightc.putConstraint(SpringLayout.SOUTH, panel_background, -35,
					SpringLayout.SOUTH, rightComponent);
			rightc.putConstraint(SpringLayout.EAST, panel_background, 0,
					SpringLayout.EAST, rightComponent);
			rightComponent.setBackground(Color.decode("#3c3f41"));
			rightComponent.add(panel_background);
		} else {
			JBackgroundPanel panel_background = new JBackgroundPanel();
			rightc.putConstraint(SpringLayout.NORTH, panel_background, 0,
					SpringLayout.NORTH, rightComponent);
			rightc.putConstraint(SpringLayout.WEST, panel_background, 0,
					SpringLayout.WEST, rightComponent);
			rightc.putConstraint(SpringLayout.SOUTH, panel_background, 0,
					SpringLayout.SOUTH, rightComponent);
			rightc.putConstraint(SpringLayout.EAST, panel_background, 0,
					SpringLayout.EAST, rightComponent);

			rightComponent.add(panel_background);
		}

		JSplitPane splitPane = new JSplitPane();
		Dimension minimumSize = new Dimension(0, 0);
		leftComponent.setMinimumSize(minimumSize);
		rightComponent.setMinimumSize(minimumSize);
		currentLayout.putConstraint(SpringLayout.NORTH, splitPane, 0,
				SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, splitPane, 0,
				SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, splitPane, 0,
				SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, splitPane, 0,
				SpringLayout.EAST, this);

		splitPane.setDividerSize(0);

		splitPane.setLeftComponent(leftComponent);
		splitPane.setRightComponent(rightComponent);
		splitPane.setDividerLocation(150);
		splitPane.setEnabled(false);
		add(splitPane);

	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		int i;
		if ((i = list.getSelectedIndex()) != -1)
			refreshRightComponent(i);

	}

	private void refreshRightComponent(int index) {
		qustn_detail.delete(0, qustn_detail.length());
		Question tempq = questions.get(index);
		currentQuestion.setCurrentQ(tempq.getQ_name());
		qustn_detail
				.append("<html><font size=\"5\"><b>Question code: </b></font>"
						+ tempq.getQ_name() + "<br><br>");
		qustn_detail.append("<font size=\"5\"><b>Question: </b></font><br>"
				+ tempq.getQ_qstn().replace("\n", "<br>") + "<br><br>");
		qustn_detail.append("<font size=\"5\"><b>Sample Input: </b></font>"
				+ tempq.getQ_ip().replace("\n", "<br>") + "<br><br>");
		qustn_detail.append("<font size=\"5\"><b>Sample Output: </b></font>"
				+ tempq.getQ_op().replace("\n", "<br>") + "<br><br>");
		qustn_detail.append("<font size=\"5\"><b>Constraints: </b></font>"
				+ tempq.getQ_cons().replace("\n", "<br>") + "<br><br>");
		qustn_detail.append("<font size=\"5\"><b>Explanation: </b></font>"
				+ tempq.getQ_ex().replace("\n", "<br>") + "<br><br></html>");

		qstndetail.setText(String.format("<html><div WIDTH=%d>%s</div><html>",
				450, qustn_detail.toString()));
	}

}
