package gui.ContestsPackage.contest;

import gui.QuestionsPackage.questions.QuestionsPanel;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class WorkspacePanel extends JPanel {
	SpringLayout sl = new SpringLayout();

	WorkspacePanel() {
		setUpPanel();
	}

	void setUpPanel() {
		JScrollPane sp = new JScrollPane();
		sl.putConstraint(SpringLayout.WEST, sp, 0, SpringLayout.WEST, this);
		sl.putConstraint(SpringLayout.EAST, sp, 0, SpringLayout.EAST, this);
		sl.putConstraint(SpringLayout.NORTH, sp, 0, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.SOUTH, sp, 0, SpringLayout.SOUTH, this);
		FlowLayout f = new FlowLayout(FlowLayout.LEADING);
		JPanel gridpanel = new JPanel(f);
		sl.putConstraint(SpringLayout.WEST, gridpanel, 0, SpringLayout.WEST, sp);
		sl.putConstraint(SpringLayout.EAST, gridpanel, 0, SpringLayout.EAST, sp);
		sl.putConstraint(SpringLayout.NORTH, gridpanel, 0, SpringLayout.NORTH,
				sp);
		// sl.putConstraint(SpringLayout.SOUTH, gridpanel, 0,
		// SpringLayout.SOUTH, this);

		QuestionsPanel q = new QuestionsPanel("4th_sem");
		q.setSize(200,200);
		gridpanel.add(q);
		gridpanel.add(q);
		gridpanel.add(q);
		gridpanel.add(q);
		gridpanel.add(q);
		gridpanel.add(new JButton("dffsdf"));

		sp.setViewportView(gridpanel);
	}
}
