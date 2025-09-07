package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

	private Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println(socket.getInetAddress( )+ " - connected");
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

			out_socket.println("Welcome!");
			String message = in_socket.readLine();
			System.out.println(socket.getInetAddress() + " - " + message);

			socket.close();
			System.out.println(socket.getInetAddress() + " - disconnected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
