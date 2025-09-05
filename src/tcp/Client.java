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

//		String message = in_socket.readLine();
//		System.out.println("localhost:8080 - " + message);

		// Business Logic of the game
		Scanner keyboard = new Scanner(System.in);
		String user_number;

		while (in_socket.readLine().startsWith("Guess")) {
			System.out.println("localhost:8080 - Guess a number [1-10]: ");
//			System.out.println("localhost:8080 - " + in_socket.readLine());
			user_number = keyboard.nextLine();
			out_socket.println(user_number);
		}

//		System.out.println("localhost:8080 - " + in_socket.readLine());
		System.out.println("localhost:8080 - You got it!");
		// End of logic of the game

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
