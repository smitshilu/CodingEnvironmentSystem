package gui.LeaderboardPackage;

import gui.CommonPackage.MyMenuBar;
import gui.login.LoginMainframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import org.apache.commons.io.FileUtils;

@SuppressWarnings("serial")
public class SubmissionFrame extends JFrame implements ActionListener {
	String contestname, questionname, username, time;

	public SubmissionFrame(String contestname, String questionname,
			String username, String time) {
		this.contestname = contestname;
		this.questionname = questionname;
		this.username = username;
		this.time = time;
		setUpFrame(contestname, questionname, username);

	}

	private void setUpFrame(String contestname, String questionname,
			String username) {

		ImageIcon img = new ImageIcon(
				LoginMainframe.class.getResource("/img/code.png"));
		this.setIconImage(img.getImage());
		this.setTitle("CODING ENVIRONMENT SYSTEM");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// this.setResizable(false);
		this.setSize(500, 500);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		this.setContentPane(new SubmissionPanel(contestname, questionname,
				username, time));

		MyMenuBar menuBar = new MyMenuBar("#3c3f41");

		// menuBar.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuBar.setBorder(new EmptyBorder(0, 0, 0, 0));
		JMenu menu1 = new JMenu("Menu");
		menu1.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu1.setForeground(Color.decode("#cccccc"));
		menuBar.add(menu1);
		JMenuItem item1_1 = new JMenuItem("Exit");
		item1_1.addActionListener(this);
		item1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu1.add(item1_1);

		JMenu menu2 = new JMenu("Options");
		menu2.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu2.setForeground(Color.decode("#cccccc"));
		JMenuItem item2_1 = new JMenuItem("Delete");
		item2_1.addActionListener(this);
		item2_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu2.add(item2_1);
		menuBar.add(menu2);

		this.setJMenuBar(menuBar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String item_name = e.getActionCommand();
		if (item_name.equals("Delete")) {
			try {
				File programdir = new File("C:/CES/" + contestname + "/"
						+ questionname + "/" + username);
				FileUtils.deleteDirectory(programdir);
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		} else if (item_name.equals("Exit")) {
			this.dispose();
		} else {

		}
	}

}
