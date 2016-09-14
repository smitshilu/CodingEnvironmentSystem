package StaticMainPackage;

import gui.CommonPackage.SettingsHash;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;

public class StaticMainClass {

	public static void main(String[] args) {
		try {

			Properties props1 = new Properties();

			// props1.put("selectionBackgroundColor", "180 240 197");
			// props1.put("menuSelectionBackgroundColor", "180 240 197");

			// props1.put("controlColor", "218 254 230");
			// props1.put("controlColorLight", "218 254 230");
			// props1.put("controlColorDark", "180 240 197");

			// props1.put("buttonColor", "218 230 254");
			// props1.put("buttonColorLight", "255 255 255");
			// props1.put("buttonColorDark", "244 242 232");

			// props1.put("rolloverColor", "218 254 230");
			// props1.put("rolloverColorLight", "218 254 230");
			// props1.put("rolloverColorDark", "180 240 197");
			props1.put("logoString", "");
			props1.put("menuForegroundColor", "170 170 170");
			props1.put("menuBackgroundColor", "60 63 65");
			props1.put("menuSelectionForegroundColor", "170 170 170");
			props1.put("menuSelectionBackgroundColor", "77 81 82");
			props1.put("menuSelectionBackgroundColorLight", "77 81 82");
			props1.put("menuSelectionBackgroundColorDark", "60 63 65");
			props1.put("menuColorLight", "77 81 82");
			props1.put("menuColorDark", "60 63 65");
			props1.put("tabAreaBackgroundColor", "60 63 65");
			props1.put("tooltipForegroundColor", "204 204 204");
			props1.put("tooltipBackgroundColor", "60 63 65");
			props1.put("tooltipBorderSize", "1");

			AluminiumLookAndFeel.setCurrentTheme(props1);
			UIManager
					.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");

			// UIManager.put("MenuBar.background", Color.decode("#3C3F41"));
			// UIManager.put("Menu.background", Color.decode("#3C3F41"));
			// UIManager.put("MenuItem.background", Color.decode("#3C3F41"));

		} catch (Exception e) {

			e.printStackTrace();
		}

		File settings = new File("C:/CES");
		if (!settings.exists())
			settings.mkdir();
		settings = new File("C:/CES/settings.txt");
		if (!settings.exists()) {
			PrintWriter writer;
			try {
				InetAddress ip = InetAddress.getLocalHost();
				String hostname = ip.getHostAddress();
				writer = new PrintWriter("C:/CES/settings.txt", "UTF-8");
				writer.println("DB username:::root");
				writer.println("DB password:::");
				writer.println("Host:::"+hostname);
				SettingsHash.addSetting("DB username", "root");
				SettingsHash.addSetting("DB password", "");
				SettingsHash.addSetting("Host", hostname);
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				String templine = "";
				BufferedReader br = new BufferedReader(new FileReader(settings));
				int count = 0;
				while ((templine = br.readLine()) != null) {
					count++;
					String[] s = templine.split(":::");
					String key, value;
					try {
						key = s[0];
					} catch (ArrayIndexOutOfBoundsException e) {
						key = "";
					}
					try {
						value = s[1];
					} catch (ArrayIndexOutOfBoundsException e) {
						value = "";
					}

					SettingsHash.addSetting(key, value);
				}
				if (count == 0) {
					PrintWriter writer;
					try {
						InetAddress ip = InetAddress.getLocalHost();
						String hostname = ip.getHostAddress();
						writer = new PrintWriter("C:/CES/settings.txt", "UTF-8");
						writer.println("DB username:::root");
						writer.println("DB password:::");
						writer.println("Host:::"+hostname);
						SettingsHash.addSetting("DB username", "root");
						SettingsHash.addSetting("DB password", "");
						SettingsHash.addSetting("Host", hostname);
						writer.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// System.out.println("username:" +
		// SettingsHash.getSetting("DB username")
		// + "\npwd:" + SettingsHash.getSetting("DB password"));
		gui.login.LoginMainframe sf = new gui.login.LoginMainframe();
		sf.setVisible(true);

	}
}
