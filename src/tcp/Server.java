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
		System.out.println(socket.getInetAddress( )+ " - connected.");

		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

		out_socket.println("Welcome!");
		String message = in_socket.readLine();
		System.out.println(socket.getInetAddress() + " - " + message);

		socket.close();
		System.out.println(socket.getInetAddress() + " - disconnected");
	}

	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
