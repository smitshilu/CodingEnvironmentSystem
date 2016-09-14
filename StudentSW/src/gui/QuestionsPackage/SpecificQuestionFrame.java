package gui.QuestionsPackage;

import gui.CommonPackage.MyMenuBar;
import gui.ContestsPackage.contest.help.HelpFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SpecificQuestionFrame extends JFrame implements ActionListener {

	public SpecificQuestionFrame(String username, String contestname,
			String questionname) {

		setUpFrame(username, contestname, questionname);
	}

	private void setUpFrame(String username, String contestname,
			String questionname) {

		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				SpecificQuestionFrame.class.getResource("/img/code.png")));
		this.setTitle(username+" : "+contestname.replace("_", " "));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(700, 400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		setContentPane(new SpecificQuestionPanel(username, contestname,
				questionname));
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
		menuBar.add(menu2);
		JMenuItem item2_1 = new JMenuItem("Help");
		item2_1.addActionListener(this);
		item2_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu2.add(item2_1);

		this.setJMenuBar(menuBar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String item_name = e.getActionCommand();
		if (item_name.equals("Help")) {
			new HelpFrame().setVisible(true);
		} else if (item_name.equals("Exit")) {
			this.dispose();
		} else {

		}
	}

}
