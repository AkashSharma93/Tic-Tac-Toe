import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
	int port = 7000;
	ServerSocket serverSocket;
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
			new Thread(new ClientHandler(clientSocket)).start();
			Thread.sleep(50);
		}
	}
	
	public class ClientHandler implements Runnable {
		BufferedReader reader;
		ObjectInputStream objectInputStream;
		Player player;
		public ClientHandler(Socket clientSocket) throws IOException, ClassNotFoundException {
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
			player = (Player) objectInputStream.readObject();
			
			playerList.add(player);
		}

		@Override
		public void run() {
			String message;
			
			echo();
//			while((message = reader.readLine()) != null) {
			
//			}
		}
	}

	public void echo(String message) {
		//do something
	}

	public void echo() {
		ArrayList<String> players = new ArrayList<String>();

		for(Player player: playerList) {
			players.add(player.getName());
		}
		
		for(Player player: playerList) {
			try {
			ObjectOutputStream oos = new ObjectOutputStream(player.getSocket().getOutputStream());
			oos.writeObject(players);
			} catch(Exception ex) { ex.printStackTrace(); }
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}
