package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.130.192", 5555);
			System.out.println("Client connected");
			
			String messsage = "Hello from the client";
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(messsage + "\n");
			bw.flush();
			
			
			while(true) {}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
