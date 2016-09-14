package session;

import gui.CommonPackage.SettingsHash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class LoginSocket {

	public LoginSocket(ServerSocket servsock) throws IOException {

		while (true) {
			final Socket sock;
			try {
				sock = servsock.accept();
			} catch (SocketException e) {
				break;
			}
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						connectToNewClient(sock);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();

		}

		//System.out.println("login server stopped");

	}

	void connectToNewClient(Socket sock) throws IOException,
			InterruptedException {

		PrintWriter pw = null;
		// receiving language from client
		BufferedReader br = new BufferedReader(new InputStreamReader(
				sock.getInputStream()));
		String msg = br.readLine();
		if (msg.equals("getinfo")) {
			// sending ack
			pw = new PrintWriter(sock.getOutputStream(), true);
			pw.println(SettingsHash.getSetting("DB username") + ":::"
					+ SettingsHash.getSetting("DB password")+":::"+ SettingsHash.getSetting("Host"));
		}

		sock.close();
	}
}