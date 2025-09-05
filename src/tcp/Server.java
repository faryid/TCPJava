package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() throws Exception {
		ServerSocket server_socket = new ServerSocket(8080);
		System.out.println(":8080 - open");

		Socket socket = server_socket.accept();
		System.out.println(socket.getInetAddress( )+ " - connected");

		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

		// Business Logic of the game
		String message;
		int secret_number = (int)(Math.random() * 10 + 1);

		do {
			out_socket.println("Guess a number [1-10]: ");
			message = in_socket.readLine();
		} while (!(Integer.parseInt(message) == secret_number));

		out_socket.println("You got it!");
		System.out.println(":8080 - Got the number");
		System.out.println(":8080 - Secret number is out.  Exiting the app.");
		// End of logic of the game

		socket.close();
		System.out.println(socket.getInetAddress() + " - Client disconnected from the game.");
	}

	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
