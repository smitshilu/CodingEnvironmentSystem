package session;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	private String ip, username, contestname, questionname;

	public Client(String ip, String username, String contestname,
			String questionname) {
		this.ip = ip;
		this.username = username;
		this.contestname = contestname;
		this.questionname = questionname;
	}

	public String uploadFile(String filePath, int language) throws Exception {
		Socket sock = new Socket(ip, 24999);

		// select file
		File myFile = new File(filePath);

		// sending language to server
		PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
		pw.println(username + ":::" + contestname + ":::" + questionname
				+ ":::" + String.valueOf(language));

		// receiving the message from server
		BufferedReader br = new BufferedReader(new InputStreamReader(
				sock.getInputStream()));
		String message = br.readLine();

		// checking ack from sever
		if (message.equals("ok")) {

			// send the program file
			byte[] mybytearray = new byte[(int) myFile.length()];
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(myFile));
			OutputStream os = sock.getOutputStream();
			bis.read(mybytearray, 0, mybytearray.length);
			os = sock.getOutputStream();
			os.write(mybytearray, 0, mybytearray.length);
			os.flush();
			bis.close();

		}

		// receiving responce from server
		message = br.readLine();

		sock.close();

		return message;

	}
}