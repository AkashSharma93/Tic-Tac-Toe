import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
	int port = 5555;
	ServerSocket serverSocket;
	ArrayList<PrintWriter> outputStreams = new ArrayList<PrintWriter>();
	ArrayList<Player> playerList = new ArrayList<Player>();
	public Server() {
		try {
			serverSocket = new ServerSocket(port);
			listenForClients();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void listenForClients() throws IOException, InterruptedException, ClassNotFoundException{ 
		while (true) {
			Socket clientSocket = serverSocket.accept();
			addToList(clientSocket);
			new Thread(new ClientHandler(clientSocket)).start();
			Thread.sleep(50);
		}
	}
	
	public void addToList(Socket clientSocket) throws IOException {
		PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
		outputStreams.add(writer);
	}
	
	public class ClientHandler implements Runnable {
		BufferedReader reader;
		ObjectInputStream objectInputStream;
		Player player;
		public ClientHandler(Socket clientSocket) throws IOException, ClassNotFoundException {
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
			player = (Player) objectInputStream.readObject();
		}
		@Override
		public void run() {
			/* This method will be implemented after the main Game class
			 * has been implemented. It will read player moves from the clients.
			 */
			 
		}
	}
}
