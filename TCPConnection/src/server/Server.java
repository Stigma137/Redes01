package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			Socket socket2 = new Socket("192.168.130.192", 5555);
			ServerSocket server = new ServerSocket(5555);
			System.out.println("...Waiting...");
			Socket socket = server.accept();
			System.out.println("...Connection achieved...");
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String message = br.readLine();
			System.out.println(message);
			
			OutputStream os = socket2.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(message + "\n");
			bw.flush();
			
			while(true) {}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
