package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(5000);
			System.out.println("...Waiting...");
			Socket socket = server.accept();
			System.out.println("...Connection achieved...");
			
			File f = new File("C:/Users/1004214182/Documents/hannahMontana.jpg");
			FileInputStream fis = new FileInputStream(f);
			OutputStream os = socket.getOutputStream();
			
			int readBytes = 0;
			byte[] buffer = new byte[100];
			
			while( (readBytes = fis.read(buffer)) != -1) {
				os.write(buffer, 0, readBytes);
			}
			fis.close();
			
			while(true) {}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
