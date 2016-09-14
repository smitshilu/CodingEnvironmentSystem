package session;

import gui.CommonPackage.SettingsHash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Login {

	public Login(String ip) throws UnknownHostException, IOException {

		@SuppressWarnings("resource")
		Socket sock = new Socket(ip, 23999);

		PrintWriter writer = new PrintWriter(sock.getOutputStream(), true);

		writer.println("getinfo");

		BufferedReader br = new BufferedReader(new InputStreamReader(
				sock.getInputStream()));

		String[] msg = br.readLine().split(":::");

		try {
			SettingsHash.addSetting("DB username", msg[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			SettingsHash.addSetting("DB username", "");
		}
		try {
			SettingsHash.addSetting("DB password", msg[1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			SettingsHash.addSetting("DB password", "");
		}
		try {
			SettingsHash.addSetting("Host", msg[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			SettingsHash.addSetting("Host", "");
		}

		br.close();

	}

}
