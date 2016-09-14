package gui.LeaderboardPackage;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import database.load.LoadLeaderboard;

@SuppressWarnings("serial")
public class LeaderboardPanel extends JPanel {

	String contestname = "";
	Object temp2[];
	String str, currentsel = "TotalAccepted";

	public LeaderboardPanel(String contestname) {
		this.contestname = contestname;
		setUpPanel();
	}

	private void setUpPanel() {

		try {
			// System.out.println("contest:" + contestname + "\torder by:"
			// + currentsel);
			LoadLeaderboard lb = new LoadLeaderboard(contestname, currentsel);
			ArrayList<String> temp = lb.loadNames();

			str = temp.get(0).toString();

			temp2 = temp.toArray();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String column[] = str.split("____");
		String values[] = new String[temp2.length];
		System.out.println(column.length);

		values[0] = temp2[0].toString();
		System.out.println(temp2.length);

		for (int i = 1; i < temp2.length; i++) {
			String temp3 = temp2[i].toString();
			String temp4 = temp2[i - 1].toString();
			System.out.println("temp4  : "+temp4);
			values[i] = temp3.replace(temp4, "");
		}

		JScrollPane scrollPane = new JScrollPane();

		JPanel cont = new JPanel();
		cont.setLayout(new GridLayout(0, 1));
		cont.setBackground(Color.decode("#3c3f41"));

		String data = temp2[0].toString();
		String headings[] = data.split("____");

		for (int i = 0; i < temp2.length; i++) {
			JPanel jp1 = new JPanel();
			jp1.setLayout(new GridLayout(1, headings.length));
			jp1.setBackground(Color.decode("#3c3f41"));
			data = temp2[i].toString();
			String datas[] = values[i].split("____");
			JButton btnBrowse = null;

			for (int j = 0; j < datas.length; j += 2) {

				if (datas[j].equals("ID") && i == 0) {
					btnBrowse = new JButton(datas[j], new ImageIcon(
							LeaderboardPanel.class
									.getResource("/img/basic_small.png")));
				} else {

					if (!datas[j].equals("null") && !datas[j].equals("ID")
							&& !datas[j].equals("accepted") && j != 0
							&& j != (datas.length - 1)
							&& !datas[j].equals("still not uploaded")
							&& !datas[j].equals("compile time error")
							&& !datas[j].equals("run time error") && i != 0) {

						String s[] = datas[j].split(" ");
						s = s[1].split(":");

						if (datas[j - 1].equals("accepted")) {

							btnBrowse = new JButton(s[0] + ":" + s[1],
									new ImageIcon(LeaderboardPanel.class
											.getResource("/img/putonline.png")));

							btnBrowse.setToolTipText(datas[j]);

						} else if (datas[j - 1].equals("compile time error")) {
							btnBrowse = new JButton(s[0] + ":" + s[1],
									new ImageIcon(LeaderboardPanel.class
											.getResource("/img/050.png")));
							btnBrowse.setToolTipText(datas[j]);
						} else if (datas[j - 1].equals("run time error")) {
							btnBrowse = new JButton(
									s[0] + ":" + s[1],
									new ImageIcon(
											LeaderboardPanel.class
													.getResource("/img/runtime-error.png")));
							btnBrowse.setToolTipText(datas[j]);
						} else if (datas[j - 1].equals("wrong answer")) {
							btnBrowse = new JButton(
									s[0] + ":" + s[1],
									new ImageIcon(LeaderboardPanel.class
											.getResource("/img/cross-icon.gif")));
							btnBrowse.setToolTipText(datas[j]);
						} else if (datas[j - 1].equals("only file submitted")) {
							btnBrowse = new JButton(
									s[0] + ":" + s[1],
									new ImageIcon(
											LeaderboardPanel.class
													.getResource("/img/editicon_small.png")));
							btnBrowse.setToolTipText(datas[j]);
							// System.out.println("sub");
						} else if (datas[j - 1].equals("time limit exceeded")) {
							btnBrowse = new JButton(
									s[0] + ":" + s[1],
									new ImageIcon(
											LeaderboardPanel.class
													.getResource("/img/clock_error.png")));
							btnBrowse.setToolTipText(datas[j]);
						} else {
							btnBrowse = new JButton(
									s[0] + ":" + s[1],
									new ImageIcon(LeaderboardPanel.class
											.getResource("/img/cross-icon.gif")));
							btnBrowse.setToolTipText(datas[j]);
						}
						btnBrowse.addActionListener(new OpenSubmission(
								datas[0], headings[j], datas[j]));
					} else if (datas[j].equals("null")
							&& !datas[j].equals(values[0]) && i != 0) {
						btnBrowse = new JButton(new ImageIcon(
								LeaderboardPanel.class
										.getResource("/img/putoffline.png")));
					} else {
						btnBrowse = new JButton(datas[j]);
						if (i == 0) {
							currentsel = datas[j];
							btnBrowse.addActionListener(new SortAndRefresh(
									currentsel));
						}
					}
					btnBrowse.setHorizontalTextPosition(SwingConstants.RIGHT);
				}

				btnBrowse.setOpaque(true);
				btnBrowse.setContentAreaFilled(false);
				btnBrowse.setBorderPainted(false);
				btnBrowse.setFocusPainted(false);

				btnBrowse.setForeground(Color.decode("#aaaaaa"));

				jp1.add(btnBrowse);
				if (j == (datas.length - 2))
					j--;
			}

			cont.add(jp1);
		}

		scrollPane.setViewportView(cont);
		add(scrollPane);
		setLayout(new GridLayout(1, 1));
	}

	class OpenSubmission implements ActionListener {
		private String id, question, time;

		public OpenSubmission(String id, String question, String time) {

			this.id = id;
			this.question = question;
			this.time = time;
		}

		public void actionPerformed(ActionEvent evt) {
			new SubmissionFrame(contestname, question, id, time)
					.setVisible(true);

		}
	}

	class SortAndRefresh implements ActionListener {
		private String value;

		public SortAndRefresh(String vaue) {
			this.value = vaue;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			removeAll();
			// System.out.println("refresh:" + value);
			refresh(value);
			revalidate();
			repaint();
		}

	}

	public void refresh(String value) {
		// System.out.println("after refresh:" + value);
		currentsel = value;
		temp2 = null;
		str = "";
		setUpPanel();
	}

}
