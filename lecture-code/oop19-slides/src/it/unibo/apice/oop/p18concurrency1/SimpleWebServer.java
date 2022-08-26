package it.unibo.apice.oop.p18concurrency1;

import java.io.*;
import java.net.*;

class ClientWorker extends Thread {
	private Socket clientSock;
	private static final String errorMsg = "<!DOCTYPE html><html><body><h1>Sorry, page not found.</h1></body></html>";
	
	public ClientWorker(Socket sock){
		this.clientSock = sock;
	}
	
	public void run(){
		try {
			OutputStream output = clientSock.getOutputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(output));
			String fileName = rd.readLine().split(" ")[1].substring(1);
			try {
				BufferedReader fd = new BufferedReader(new FileReader(fileName));
				String line = fd.readLine();
				while (line != null){
					wr.write(line+"\n");
					line = fd.readLine();
				}
				fd.close();
			} catch (Exception ex){
				wr.write(errorMsg);
			} finally {
				wr.flush();
				wr.close();
			}
		} catch (IOException ex){
			System.err.println("[CLIENT WORKER] I/O Exception.");
		}
	}
}

public class SimpleWebServer {
	public static void main(String[] args) {
		try {
			ServerSocket s = new ServerSocket(8080);
			while (true){
				Socket clientSock = s.accept();
				new ClientWorker(clientSock).start();
			}
		} catch (IOException ex){
			System.err.println("[SERVER] I/O Exception.");
			System.exit(-1);
		}
		
	}

}
