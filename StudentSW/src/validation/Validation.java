package validation;

public class Validation {

	public static boolean isIPValid(String ip) {
		return  checkstrings(
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

	public static boolean checkstrings(String str, String regex) {
		if (str.matches(regex)) {
			return true;
		} else {
			return false;
		}
	}
}