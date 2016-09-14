package gui.MainPackage;

import gui.CommonPackage.MyMenuBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {
	MainPanel mp;

	public MainFrame(String contestname) {

		setUpFrame(contestname);
	}

	private void setUpFrame(String contestname) {

		ImageIcon img = new ImageIcon(
				MainFrame.class.getResource("/img/code.png"));
		this.setIconImage(img.getImage());
		this.setTitle(contestname.replace("_", " "));
		// this.setType(JFrame.Type.UTILITY);
		this.setResizable(false);
		this.setSize(655, 400);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		mp = new MainPanel(contestname);
		setContentPane(mp);
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
		JMenuItem item2_1 = new JMenuItem("Refresh");
		item2_1.addActionListener(this);
		item2_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu2.add(item2_1);

		this.setJMenuBar(menuBar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String item_name = e.getActionCommand();
		if (item_name.equals("Refresh")) {
			mp.refresh();
		} else if (item_name.equals("Exit")) {
			this.dispose();
		} else {

		}
	}

}
