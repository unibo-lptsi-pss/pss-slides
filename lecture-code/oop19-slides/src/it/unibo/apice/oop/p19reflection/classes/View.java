package it.unibo.apice.oop.p19reflection.classes;

import java.io.*;

public interface View {
	
	void setAnswer(String answer);

	void setLogString(String s);

	String ask(String question);
	
	public static class SystemInOut implements View {

		private String answerString;
		private String logString;
		private BufferedReader reader;
		
		
		public SystemInOut() {
			this.reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public void setAnswer(String s) {
			this.answerString = s;
			System.out.println(this.answerString);
		}

		public void setLogString(String s) {
			this.logString = s;
			System.out.println(this.logString);	
		}

		public String ask(String question){
			System.out.print(question); // Asking message
			//System.out.flush();	 // Make sure it is written
			String result = null;
			try {
				result = reader.readLine();
			} catch (IOException e){
			}
			return result;
		}

	}

}
