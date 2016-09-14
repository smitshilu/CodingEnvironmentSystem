package gui.QuestionsPackage.newquestion;

import gui.QuestionsPackage.questions.QuestionsPanel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class NewQuestionFrame extends JFrame {

	private NewQuestionPanel currentPanel;

	public NewQuestionFrame(String contestname, QuestionsPanel cp) {

		currentPanel = new NewQuestionPanel(contestname, cp);
		setUpFrame();
	}

	private void setUpFrame() {

		ImageIcon img = new ImageIcon(
				NewQuestionFrame.class.getResource("/img/codeicon.png"));
		this.setIconImage(img.getImage());
		// this.setType(JFrame.Type.NORMAL);
		this.setTitle("CODING ENVIRONMENT SYSTEM");
		this.setResizable(false);
		this.setSize(550, 230);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container c = new Container();
		c.add(currentPanel);
		this.add(c);
	}

}
