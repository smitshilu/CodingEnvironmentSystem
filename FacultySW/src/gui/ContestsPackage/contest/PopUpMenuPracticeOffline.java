package gui.ContestsPackage.contest;

import gui.ContestsPackage.editcontest.EditContestFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import objectclasses.OnlineContests;

import org.apache.commons.io.FileUtils;

import database.create.CreateOnlineContest;
import database.create.CreateTestContest;
import database.delete.DeleteContest;
import database.delete.DeletePracticeContest;

@SuppressWarnings("serial")
class PopUpMenuPracticeOffline extends JPopupMenu implements ActionListener {
	JMenuItem Item1, Item2, Item3, Item4;
	String contestname;
	GridLayoutContests cp;

	public PopUpMenuPracticeOffline(String contestname, GridLayoutContests cp) {
		this.cp = cp;
		this.contestname = contestname;
		Item1 = new JMenuItem("Put Online", new ImageIcon(
				ImageIcon.class.getResource("/img/putonline.png")));
		Item1.setBorder(new EmptyBorder(5, 5, 5, 5));
		Item1.setFont(new Font("SanSerif", Font.BOLD, 12));
		Item2 = new JMenuItem("Delete Contest", new ImageIcon(
				ImageIcon.class.getResource("/img/trashcan_delete2.png")));
		Item2.setBorder(new EmptyBorder(5, 5, 5, 5));
		Item2.setFont(new Font("SanSerif", Font.BOLD, 12));

		Item3 = new JMenuItem("Edit Contest", new ImageIcon(
				ImageIcon.class.getResource("/img/editicon_small.png")));
		Item3.setBorder(new EmptyBorder(5, 5, 5, 5));
		Item3.setFont(new Font("SanSerif", Font.BOLD, 12));
		Item4 = new JMenuItem("Enable Test Mode", new ImageIcon(
				PopUpMenuPracticeOffline.class
						.getResource("/img/testtype_small.png")));
		Item4.setBorder(new EmptyBorder(5, 5, 5, 5));
		Item4.setFont(new Font("SanSerif", Font.BOLD, 12));
		Item1.addActionListener(this);
		Item2.addActionListener(this);
		Item3.addActionListener(this);
		Item4.addActionListener(this);
		add(Item4);
		add(Item1);
		add(Item3);
		add(Item2);		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String event = arg0.getActionCommand();
		if (event.equals("Put Online")) {
			OnlineContests.addContest(contestname);
			new CreateOnlineContest(contestname);

			PopUpMenuPracticeOffline.this.register(cp);
		} else if (event.equals("Delete Contest")) {
			try {
				int dialogResult = JOptionPane.showConfirmDialog(getParent(),
						"Are you sure you want to delete the contest?",
						"Delete Contest", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					new DeleteContest(contestname);
					FileUtils
							.deleteDirectory(new File("C:/CES/" + contestname));
					JOptionPane.showMessageDialog(getParent(),
							"Successfully deleted the contest.");
					PopUpMenuPracticeOffline.this.register(cp);
				} else {

				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(getParent(),
						"Failed to delete the contest.");
				e.printStackTrace();
			}
		} else if (event.equals("Edit Contest")) {
			new EditContestFrame(cp, contestname).setVisible(true);
		} else if (event.equals("Enable Test Mode")) {
			new CreateTestContest(contestname);
			new DeletePracticeContest(contestname);
			PopUpMenuPracticeOffline.this.register(cp);
		}

	}

	public void register(MyPopUpSelectionListener cp) {
		cp.refreshpane();
	}
}