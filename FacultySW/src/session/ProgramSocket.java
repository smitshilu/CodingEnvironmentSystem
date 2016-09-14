package session;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import database.server.update.UpdateResult;

public class ProgramSocket {

	public ProgramSocket(ServerSocket servsock) throws IOException {

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

	}

	void connectToNewClient(Socket sock) throws IOException,
			InterruptedException {

		PrintWriter pw = null;
		// receiving language from client
		BufferedReader br = new BufferedReader(new InputStreamReader(
				sock.getInputStream()));
		String[] msg = br.readLine().split(":::");
		String username = msg[0];
		String contestname = msg[1];
		String questionname = msg[2];

		int language = Integer.parseInt(msg[3]);

		// converting msg into language
		String ftype = ".txt";
		switch (language) {
		case 1:
			ftype = ".java";
			break;
		case 2:
			ftype = ".c";
			break;
		case 3:
			ftype = ".cpp";
			break;
		case 4:
			ftype = ".txt";
			break;
		}

		// sending ack
		pw = new PrintWriter(sock.getOutputStream(), true);
		pw.println("ok");

		// Read client data and store in server
		byte[] mybytearray = new byte[50000];
		InputStream is = sock.getInputStream();

		File CESfolder = new File("C:\\CES\\");
		if (!CESfolder.exists())
			CESfolder.mkdir();
		CESfolder = new File("C:\\CES\\" + contestname);
		if (!CESfolder.exists())
			CESfolder.mkdir();
		CESfolder = new File("C:\\CES\\" + contestname + "\\" + questionname);
		if (!CESfolder.exists())
			CESfolder.mkdir();
		CESfolder = new File("C:\\CES\\" + contestname + "\\" + questionname
				+ "\\" + username);
		if (!CESfolder.exists())
			CESfolder.mkdir();

		FileOutputStream fos = new FileOutputStream("C:\\CES\\" + contestname
				+ "\\" + questionname + "\\" + username + "\\" + "Main" + ftype);

		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int bytesRead = is.read(mybytearray, 0, mybytearray.length);
		bos.write(mybytearray, 0, bytesRead);
		bos.close();

		if (ftype.equals(".txt")) {
			pw.println("File has been submitted successfully.");
			try {
				new UpdateResult(contestname, questionname, username,
						"only file submitted");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// compile and run
			Program prog = new Program(username, contestname, questionname,
					language);
			String response = prog.getResponse();
			// give back response
			pw.println(response);
		}
		sock.close();
	}
}