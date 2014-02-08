import java.net.*;
import java.io.*;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	String playerName;
	char symbol;
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;
	ObjectOutputStream objectOutputStream;
	String serverAddress = "127.0.0.1"; // To implement

	public void setName(String name) {
		playerName = name;
	}

	public String getName() {
		return playerName;
	}

	public void setSymbol(char sym) {
		symbol = sym;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSocket(Socket s) {
		sock = s;
	}

	public Socket getSocket() {
		return sock;
	}

	public void setReader(BufferedReader r) {
		reader = r;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setWriter(PrintWriter w) {
		writer = w;
	}

	public PrintWriter getWriter() {
		return writer;
	}
	
	public void setupNetworking() {
		try {
			sock = new Socket(serverAddress, 7000);
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			writer = new PrintWriter(sock.getOutputStream());
			objectOutputStream = new ObjectOutputStream(sock.getOutputStream());
			objectOutputStream.writeObject(this);
		}
		catch(UnknownHostException ex) {
			ex.printStackTrace();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Player player = new Player();
	
		new Lobby(player);
		new UserLogin(player);
	}
}
