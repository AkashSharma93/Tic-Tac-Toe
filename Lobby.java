import javax.swing.*;

public class Lobby {
	Player player;
	JFrame frame;

	public Lobby(Player p) {
		player = p;
	}

	public void showLobby() {
		frame = new JFrame("Lobby");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}
