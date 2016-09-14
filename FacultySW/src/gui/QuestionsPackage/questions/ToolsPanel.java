package gui.QuestionsPackage.questions;

import gui.QuestionsPackage.editquestion.EditQuestionFrame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.io.FileUtils;

import database.delete.DeleteQuestion;

@SuppressWarnings("serial")
public class ToolsPanel extends JPanel {

	private JButton testButton;

	String contestname;

	currentQuestion cq;

	public ToolsPanel(String contestname, currentQuestion cq) {
		this.contestname = contestname;
		this.cq = cq;
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#555555"),
				1));

		setUpPanel();
	}

	private void setUpPanel() {
		this.setBackground(Color.decode("#3c3f41"));
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#555555"),
				1));
		this.setSize(550, 50);

		JButton btnBrowse = new JButton("Edit Question", new ImageIcon(
				ToolsPanel.class.getResource("/img/icon_medium.png")));
		btnBrowse.setOpaque(true);
		btnBrowse.setContentAreaFilled(false);
		btnBrowse.setBorderPainted(false);
		btnBrowse.setFocusPainted(false);
		// btnBrowse.setBackground(Color.decode("#2b2e30"));
		btnBrowse.setForeground(Color.decode("#aaaaaa"));

		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new EditQuestionFrame(contestname, cq.getCp(),
						cq.getCurrentQ(), cq.getQuestions(), cq
								.getConstraints(), cq.getInputs(), cq
								.getOutputs(), cq.getExamples(), cq
								.getTest_inputs(), cq.getTest_outputs())
						.setVisible(true);
			}

		});
		add(btnBrowse);
		testButton = new JButton("Delete Question", new ImageIcon(
				ToolsPanel.class.getResource("/img/trashcan_medium.png")));
		testButton.setOpaque(true);
		testButton.setContentAreaFilled(false);
		testButton.setBorderPainted(false);
		testButton.setFocusPainted(false);

		this.add(testButton);
		testButton.setForeground(Color.decode("#aaaaaa"));
		testButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int dialogResult = JOptionPane.showConfirmDialog(getParent(),
						"Are you sure you want to delete the question?",
						"Delete Question", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						new DeleteQuestion(contestname, cq.getCurrentQ());
						FileUtils.deleteDirectory(new File("C:/CES/"
								+ contestname + "/" + cq.getCurrentQ()));
						JOptionPane.showMessageDialog(getParent(),
								"Successfully deleted the question.");
						ToolsPanel.this.register(cq.getCp());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(getParent(),
								"Failed to delete the question.");
					}
				} else {

				}
			}
		});

		setLayout(new GridLayout(1, 2));

	}

	public void reloadCQ(currentQuestion cq) {
		this.cq = cq;
	}

	public void register(NewQuestionAddedListener cp) {
		cp.refreshpane();
	}
}
