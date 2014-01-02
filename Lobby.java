import javax.swing.*;

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

		JLabel label = new JLabel("Player details:");
		label.setBounds(10, 10, 200, 20);
		frame.add(label);

		frame.setVisible(true);
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
