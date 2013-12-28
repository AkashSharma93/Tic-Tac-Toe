import java.net.*;
import java.io.*;

public class Player {
	String playerName;
	char symbol;
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;

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

	public static void main(String[] args) {
		Player player = new Player();

		new UserLogin(player);
	}
}
