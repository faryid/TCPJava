package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

	private Socket socket;

	private ServerMain server_main;
	
	public ServerThread(Socket socket, ServerMain server_main) {
		this.socket = socket;
		this.server_main = server_main;
	}

	@Override
	public void run() {
		try {
			int client_number = server_main.getClientNumber();
			System.out.println(client_number + "" + socket.getInetAddress() + " - connected");
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

			out_socket.println("Welcome, " + client_number);

			String message = in_socket.readLine();
			System.out.println(client_number + "" + socket.getInetAddress() + " - " + message);

			socket.close();
			System.out.println(client_number + "" + socket.getInetAddress() + " - disconnected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
