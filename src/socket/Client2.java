package socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
	private Socket socket;
	Scanner scan = new Scanner(System.in);
	public Client2(){
		try {
			socket = new Socket("localhost",8088);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void start(){
		try {
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os,"utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw,true);
			while(true){
				pw.println(scan.nextLine());
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		Client2 client = new Client2();
		client.start();

		

	}

}
