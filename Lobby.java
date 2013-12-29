import javax.swing.*;
import java.awt.*;

public class Lobby {
	Player player;
	JFrame frame;

	public Lobby(Player p) {
		player = p;
		showLobby();
	}

	public void showLobby() {
		frame = new JFrame("Lobby");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(null);

//		Bounds b = new Bounds();
//		frame.add(b);

		displayStat();
		
		frame.setVisible(true);
	}

	public void displayStat() {
		JLabel heading1, heading2;
		JLabel playerName;

		heading1 = new JLabel("Player details...");
		heading1.setBounds(10, 10, 150, 20);
		frame.add(heading1);

		heading2 = new JLabel("Player Statistics...");
		heading2.setBounds(10, 60, 150, 50);
		frame.add(heading2);

//		playerName = new JLabel(player.getName());
//		playerName.setBounds(10, 20, 150, 30);
//		frame.add(playerName);
	}

//	public class Bounds extends JPanel{
//		public void paintComponent(Graphics g) {
//			int width = frame.getWidth();
//			int height = frame.getHeight();

//			g.drawLine(width/4, 0, width/4, height);
//			g.drawLine(3*width/4, 0, 3*width/4, height);
//		}
//	}
}
