package gui.CommonPackage;

import java.util.HashMap;

public class SettingsHash {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static HashMap<String, String> settings = new HashMap();

	static public void addSetting(String key, String value) {
		settings.put(key, value);
	}
	
	static public void removeSetting(String key) {
		settings.remove(key);
	}

	static public String getSetting(String key) {
		return settings.get(key);
	}

}
