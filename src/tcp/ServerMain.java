package tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	private int clientNumber = 1;

	public ServerMain() throws Exception {
		ServerSocket server_socket = new ServerSocket(8080);
		System.out.println("::8080 - open");

		while (true) {
			Socket socket = server_socket.accept();
			ServerThread server_thread = new ServerThread(socket, this);
			Thread thread = new Thread(server_thread);
			thread.start();
		}
	}

	public int getClientNumber() {
		return clientNumber++;
	}

	public static void main(String[] args) {
		try {
			new ServerMain();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
