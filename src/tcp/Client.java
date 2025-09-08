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
		System.out.println("connection:start");

		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

		Scanner keyboard = new Scanner(System.in);
		String message;

		while (in_socket.readLine().startsWith("connected")) {
			System.out.print("connection:send:");
			message = keyboard.nextLine();
			out_socket.println(message);
			message = in_socket.readLine();
			System.out.println("connection:receive:" + message);
		}

		socket.close();
		System.out.println("connection:ended");
	}

	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
