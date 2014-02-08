import javax.swing.*;
import java.awt.*;

public class Lobby {
	Player player;
	JFrame frame;
	JPanel mainPanel, playerPanel, centerPanel, playerListPanel, playerInnerPanel;
	JList playerList, battleRequestList;

	public Lobby(Player p) {
		player = p;
		showLobby();
	}
	
	public void showLobby() {
		frame = new JFrame("Lobby");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		mainPanel = new JPanel();
		
		//Player details.
		playerPanel = new JPanel();
		playerPanel.setLayout(new BorderLayout());

		playerInnerPanel = new JPanel();	//To place all the buttons and stuff
		playerInnerPanel.setLayout(new BoxLayout(playerInnerPanel, BoxLayout.Y_AXIS));

		playerInnerPanel.add(new JLabel("Player Details"));

		playerPanel.add(playerInnerPanel);
		
		//Centre Area.
		centerPanel = new JPanel();
		battleRequestList = new JList();
		JScrollPane scroller1 = new JScrollPane(battleRequestList);
		scroller1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(scroller1);
		
		//Player List
		playerListPanel = new JPanel();
		playerList = new JList();
		JScrollPane scroller2 = new JScrollPane(playerList);
		scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		playerListPanel.setLayout(new BorderLayout());
		playerListPanel.setName("Player List");
		playerListPanel.add(scroller2);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(playerPanel);
		mainPanel.add(centerPanel);
		mainPanel.add(playerListPanel);
		
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
}
