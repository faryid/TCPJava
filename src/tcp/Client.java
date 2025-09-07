package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public Client() throws Exception {
		Socket socket = new Socket("localhost", 8080);
		System.out.println("localhost:8080 - Start");

		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

		String message = in_socket.readLine();
		System.out.println("localhost:8080 - " + message);

//		Scanner keyboard = new Scanner(System.in);
//		System.out.print(socket.getInetAddress() + " -: ");
//		message = keyboard.nextLine();
		out_socket.println("Sending data");

		socket.close();
		System.out.println("localhost:8080 - Ended");
	}

	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
