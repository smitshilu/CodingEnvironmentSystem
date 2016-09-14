package gui.ContestsPackage.editcontest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class RenameContestDir {

	public RenameContestDir(String oldcontestname, String newcontestname) {
		File oldFile = new File("C:/CES/" + oldcontestname);
		File newFile = new File("C:/CES/" + newcontestname);
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
