package session;

import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JOptionPane;

public class StartServer {
	Thread server_thread, login_thread;
	ServerSocket servsock, loginsocket;
	boolean success = false;

	public StartServer() {
		putOnline();
	}

	public boolean putOnline() {

		login_thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					loginsocket = new ServerSocket(23999);
					new LoginSocket(loginsocket);
					success = true;
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,
							"Socket already in use.");
					success = false;
					e.printStackTrace();
				}
			}
		});
		login_thread.start();

		server_thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					servsock = new ServerSocket(24999);
					new ProgramSocket(servsock);
					success = true;
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,
							"Socket already in use.");
					success = false;
					e.printStackTrace();
				}
			}
		});
		server_thread.start();
		return success;

	}

	public boolean putOffline() {
		try {
			servsock.close();
			loginsocket.close();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
			success = false;
		}
		return success;

	}
}
