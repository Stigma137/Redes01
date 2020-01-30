package client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 5000);
			System.out.println("Client connected");
			
			
			File f = new File("C:/Users/1004214182/Documents/hannahMontano.jpg");
			InputStream is = socket.getInputStream();
			FileOutputStream fos = new FileOutputStream(f);
			
			int readBytes = 0;
			byte[] buffer = new byte[100];
			
			while( (readBytes = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readBytes);
			}
			fos.close();
			
			while(true) {}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
