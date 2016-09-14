package validation;

public class Validation {

	public static boolean isIPValid(String ip) {
		return checkstrings(
				ip,
				"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	}

	public static boolean isUserNameValid(String username) {
		if(username.isEmpty())
			return false;
		return checkstrings(username, "^[a-zA-Z0-9]*$");

	}

	public static boolean isPasswordValid(String password) {
		if(password.isEmpty())
			return false;
		return checkstrings(password, "^[a-zA-Z0-9]*$");

	}

	public static boolean isContestNameValid(String contestname) {
		if(contestname.isEmpty())
			return false;
		return checkstrings(contestname, "^[a-zA-Z0-9\\s]*$");

	}

	public static boolean isQuestionCodeValid(String questioncode) {
		if(questioncode.isEmpty())
			return false;
		return checkstrings(questioncode, "^[a-zA-Z0-9]*$");

	}

	public static boolean isQuestionValid(String question) {
		if(question.isEmpty())
			return false;
		return checkstrings(question, "^[^\'\"\\;]*$");

	}

	public static boolean isInputValid(String input) {
		return checkstrings(input, "^[^\'\"\\;]*$");

	}

	public static boolean isOutputValid(String output) {
		return checkstrings(output, "^[^\'\"\\;]*$");

	}

	public static boolean isConstraintsValid(String constrain) {
		return checkstrings(constrain, "^[^\'\"\\;]*$");

	}

	public static boolean isExamplesValid(String example) {
		return checkstrings(example, "^[^\'\"\\;]*$");

	}

	private static boolean checkstrings(String str, String regex) {
		if (str.matches(regex)) {
			return true;
		} else {
			return false;
		}
	}
}