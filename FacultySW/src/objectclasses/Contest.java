package objectclasses;

import java.util.ArrayList;
import java.util.List;

public class Contest {

	List<Question> allQuestions = new ArrayList<Question>();
	String contestName = "";
	Boolean isOnline=false;

	public Boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

	public Contest(String contestName) {
		this.contestName = contestName;
	}

	public List<Question> getAllQuestions() {
		return allQuestions;
	}

	public void setAllQuestions(List<Question> allQuestions) {
		this.allQuestions = allQuestions;
	}

	public String getContestName() {
		return contestName;
	}

	void addQuestion(Question question) {
		if (question != null)
			allQuestions.add(question);
	}

	void removeQuestion(Question question) {
		if (question != null)
			allQuestions.remove(question);
	}

}
