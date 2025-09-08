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
			String message, header = "client:" + client_number;

			System.out.println(header + ":connected");
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

			do {
				out_socket.println("connected");
				message = in_socket.readLine();

				System.out.println(header + ":send:" + message.toUpperCase());
				out_socket.println(message.toUpperCase());

			} while(!message.toLowerCase().startsWith("exit"));
			out_socket.println("disconect");

			socket.close();
			System.out.println(header + ":disconect");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
