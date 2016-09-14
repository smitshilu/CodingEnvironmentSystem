package gui.QuestionsPackage.editquestion;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class RenameQuestionDir {

	public RenameQuestionDir(String contestname, String oldquestionname,
			String newquestionname) {
		File oldFile = new File("C:/CES/" + contestname + "/" + oldquestionname);
		File newFile = new File("C:/CES/" + contestname + "/" + newquestionname);
		try {
			FileUtils.moveDirectoryToDirectory(oldFile, newFile, true);
			for (File file : newFile.listFiles()) {
				for (File f : file.listFiles()) {
					FileUtils.moveToDirectory(f, newFile, true);
				}
				FileUtils.deleteDirectory(file);
			}
			FileUtils.deleteDirectory(oldFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
