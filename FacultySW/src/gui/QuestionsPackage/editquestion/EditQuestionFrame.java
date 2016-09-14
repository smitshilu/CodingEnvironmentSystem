package gui.QuestionsPackage.editquestion;

import gui.QuestionsPackage.questions.QuestionsPanel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class EditQuestionFrame extends JFrame {

	private EditQuestionPanel currentPanel;

	public EditQuestionFrame(String contestname, QuestionsPanel cp,
			String oldproblemcode, String question, String constraints,
			String inputs, String outputs, String examples, String test_output,
			String test_input) {

		currentPanel = new EditQuestionPanel(contestname, cp, oldproblemcode,
				question, constraints, inputs, outputs, examples, test_output,
				test_input);
		setUpFrame();
	}

	private void setUpFrame() {

		ImageIcon img = new ImageIcon(
				EditQuestionFrame.class.getResource("/img/codeicon.png"));
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
