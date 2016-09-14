package StaticMainPackage;

import gui.login.LoginMainFrame;

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
			// UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
			UIManager
					.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			// UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");

		} catch (Exception e) {

			e.printStackTrace();
		}
		LoginMainFrame sf = new LoginMainFrame();
		sf.setVisible(true);
	}

}
