package session;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import database.server.load.LoadTestIOP;
import database.server.update.UpdateResult;

public class Program {

	String response = "Error";
	String cmp, run;
	String outputstring, input_right, output_right;
	String username = "", contestname = "", questionname = "";

	public Program(String username, String contestname, String questionname,
			int code) throws IOException, InterruptedException {

		this.username = username;
		this.contestname = contestname.replace(" ", "_");
		this.questionname = questionname;

		/*
		 * Codes:- (1-Java) (2-C) (3-CPP)
		 */
		switch (code) {
		case 1:

			cmp = "javac C:\\CES\\" + contestname + "\\" + questionname + "\\"
					+ username + "\\Main.java";
			run = "java -cp C:\\CES\\" + contestname + "\\" + questionname
					+ "\\" + username + " Main";
			break;
		case 2:

			cmp = "g++ C:\\CES\\" + contestname + "\\" + questionname + "\\"
					+ username + "\\Main.c -o C:\\CES\\" + contestname + "\\"
					+ questionname + "\\" + username + "\\Main.o";
			run = "C:\\CES\\" + contestname + "\\" + questionname + "\\"
					+ username + "\\Main.o";
			break;
		case 3:

			cmp = "g++ C:\\CES\\" + contestname + "\\" + questionname + "\\"
					+ username + "\\Main.cpp -o C:\\CES\\" + contestname + "\\"
					+ questionname + "\\" + username + "\\Main.o";
			run = "C:\\CES\\" + contestname + "\\" + questionname + "\\"
					+ username + "\\Main.o";
			break;

		}

		@SuppressWarnings("unused")
		String str = "";
		if ((str = compile()) == null) {
			String err = run();
			if (err.equals("noerror")) {

				if ((compareoutput()) == true) {
					response = "Answer is accepted";

					// Update leaderboard

					try {
						new UpdateResult(contestname, questionname, username,
								"accepted");

					} catch (Exception e) {

						e.printStackTrace();
					}

				} else {
					response = "Wrong answer";
					try {
						new UpdateResult(contestname, questionname, username,
								"wrong answer");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else if (err.equals("Time limit exceeded.")) {
				response = "Time limit exceeded";
			} else {
				response = "Run time error";
				try {
					new UpdateResult(contestname, questionname, username,
							"run time error");
				} catch (Exception e) {

					e.printStackTrace();
				}
				// response = err;
			}
		} else {
			response = "Compile Time Error";
			try {
				new UpdateResult(contestname, questionname, username,
						"compile time error");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		try {
			File f = new File("C:\\CES\\" + contestname + "\\" + questionname
					+ "\\" + username + "\\Main.class");
			f.delete();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			File f = new File("C:\\CES\\" + contestname + "\\" + questionname
					+ "\\" + username + "\\Main.o");
			f.delete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String compile() throws IOException, InterruptedException {
		// System.out.println("start:" + cmp + ":end");
		Process compileProcess = Runtime.getRuntime().exec(cmp);

		compileProcess.waitFor();

		String error = null;

		InputStream is = compileProcess.getErrorStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		error = br.readLine();
		System.out.println("error: " + error);
		return error;
	}

	public String run() throws IOException, InterruptedException {

		LoadTestIOP liop = new LoadTestIOP(contestname, questionname);
		List<String> iop = liop.loadAllQuestions();
		input_right = iop.get(0);
		System.out.println("yo: "+input_right);
		output_right = iop.get(1);

		Process runProcess = Runtime.getRuntime().exec(run);

		java.io.OutputStream op = runProcess.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(op));
		bw.write(input_right);
		bw.write("\n");
		bw.flush();

		boolean isRunning = true;
		int time = 0;

		while (isRunning) {
			try {
				runProcess.exitValue();
				isRunning = false;
			} catch (IllegalThreadStateException e) {
				if (time >= 5) {
					runProcess.destroy();
					System.out.println("time limit exceeded.");
					return "Time limit exceeded.";
				} else {
					time++;
					Thread.sleep(1000);
				}
			}
		}
		System.out.println("process completed in " + time + " second(s).");

		InputStream is = runProcess.getErrorStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String error = br.readLine();
		InputStream ips = runProcess.getInputStream();
		BufferedReader input = new BufferedReader(new InputStreamReader(ips));

		StringBuilder sb = new StringBuilder("");

		String linput;

		while ((linput = input.readLine()) != null) {
			sb.append(linput + "\n");
		}
		outputstring = sb.toString();
		System.out.println("op : "+sb.toString());

		if (error == null) {
			return "noerror";
		} else {
			return error;
		}

	}

	public Boolean compareoutput() throws IOException {

		if ((outputstring.trim()).equals(output_right.trim())) {
			return true;
		} else {
			return false;
		}
	}

	public String getResponse() {
		return response;
	}

}
