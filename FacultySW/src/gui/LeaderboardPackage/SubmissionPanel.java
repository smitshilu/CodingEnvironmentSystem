package gui.LeaderboardPackage;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SubmissionPanel extends JPanel {

	String contestname, questionname, username, time;
	StringBuffer programtext = new StringBuffer("");

	public SubmissionPanel(String contestname, String questionname,
			String username, String time) {
		this.contestname = contestname;
		this.questionname = questionname;
		this.username = username;
		this.time = time;
		setUpPanel();

	}

	void setUpPanel() {
		setLayout(new GridLayout(1, 1));
		setBackground(Color.decode("#3c3f41"));
		JScrollPane scrollPane = new JScrollPane();
		JLabel prog = new JLabel();
		prog.setVerticalAlignment(SwingConstants.TOP);
		prog.setBorder(new EmptyBorder(10, 10, 10, 10));
		prog.setBackground(Color.decode("#3c3f41"));
		prog.setForeground(Color.decode("#aaaaaa"));
		try {
			File programdir = new File("C:/CES/" + contestname + "/"
					+ questionname + "/" + username);
			if (programdir.listFiles().length != 0)
				programtext.append("<html><b>Contest: </b>"
						+ contestname.replace("_", " ")
						+ "<br><b>Question: </b>" + questionname
						+ "<br><b>Submitted by: </b>" + username
						+ "<br><b>Submission time: </b>" + time + "<br><br>");

			for (File programfile : programdir.listFiles()) {

				try {
					String templine = "";
					BufferedReader br = new BufferedReader(new FileReader(
							programfile));
					programtext.append("<center><b><u><font size='+1'>"
							+ programfile.getName()
							+ "</font></u></b></center><br>");
					while ((templine = br.readLine()) != null) {
						String values[] = templine.split("\t");
						for (String s : values)
							programtext.append(s + "&nbsp;&nbsp;&nbsp;&nbsp;");
						programtext.append("<br>");
					}
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				programtext.append("<br><br><br>");
			}
		} catch (NullPointerException ne) {
			programtext.append("Solution of " + questionname
					+ " has not been submitted by " + username
					+ " as yet or has been deleted.");
		}
		prog.setText(String.format("<html><div WIDTH=%d>%s</div><html>", 450,
				programtext.toString()));
		JViewport viewport = new JViewport();
		viewport.setView(prog);
		viewport.setOpaque(false);

		scrollPane.setViewport(viewport);

		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setOpaque(false);
		add(scrollPane);

	}
}
