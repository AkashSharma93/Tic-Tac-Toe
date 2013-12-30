import javax.swing.*;
import java.awt.*;

public class Lobby {
	Player player;
	JFrame frame;
	Bounds b;
	JButton newChallenge;
	JTextArea playerList;
	int width, height;

	public Lobby(Player p) {
		player = p;
		showLobby();
	}

	public void showLobby() {
		frame = new JFrame("Lobby");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		frame.setVisible(true);

		b = new Bounds();
		b.setLayout(null);
		frame.getContentPane().add(BorderLayout.CENTER, b);

		displayStat();
		displayButtons();

		try {
			Thread.sleep(100);
		} catch(Exception ex) {}

		displayText();
		
		frame.repaint();
	}

	public void displayStat() {
		JLabel heading1, heading2;
		JLabel playerName;

		heading1 = new JLabel("Player details...");
		heading1.setBounds(10, 10, 150, 20);
		b.add(heading1);

		heading2 = new JLabel("Player Statistics...");
		heading2.setBounds(10, 60, 150, 20);
		b.add(heading2);

		playerName = new JLabel(player.getName());
		playerName.setBounds(10, 20, 150, 30);
		b.add(playerName);
	}

	public void displayButtons() {
		newChallenge = new JButton("New challenge");
		newChallenge.setBounds(10, 200, 150, 20); 
		b.add(newChallenge);
	}

	public void displayText() {

		System.out.println(height);
		System.out.println(width);

		playerList = new JTextArea(width, height);
		playerList.setLineWrap(true);
		playerList.setWrapStyleWord(true);
		playerList.setEditable(false);

//		JScrollPane scroller1 = new JScrollPane(playerList);
//		scroller1.setBounds(100, 100, 400, 500);

		playerList.setBounds(3*width/4, 0, width/4, height);
		playerList.setText("Display players here...");

		b.add(playerList);
	}

	public class Bounds extends JPanel{
		public void paintComponent(Graphics g) {
			width = frame.getWidth();
			height = frame.getHeight();

			g.drawLine(width/4, 0, width/4, height);
			g.drawLine(3*width/4, 0, 3*width/4, height);
		}
	}
}
