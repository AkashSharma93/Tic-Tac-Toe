import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class Lobby {
	Player player;
	JFrame frame;
	JPanel mainPanel, playerPanel, centerPanel, playerListPanel, playerInnerPanel;
	JList<String> playerList, battleRequestList;

	public Lobby(Player p) {
		player = p;
		showLobby();
		
		new Thread(new IncomingMsgListener()).start();
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
		battleRequestList = new JList<String>();
		JScrollPane scroller1 = new JScrollPane(battleRequestList);
		scroller1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(scroller1);
		
		//Player List
		playerListPanel = new JPanel();
		playerList = new JList<String>();
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

	public class IncomingMsgListener implements Runnable {
		ObjectInputStream ois;

		public IncomingMsgListener() {
			try {
				ois = new ObjectInputStream(player.getSocket().getInputStream());
			} catch(Exception ex) { ex.printStackTrace(); }
		}

		public void run() {
			DefaultListModel<String> model = new DefaultListModel<String>();
			ArrayList<String> list;

			try {
				while((list = (ArrayList<String>) ois.readObject()) != null) {
					if(list.get(0) == "playerList") {
						for(int i = 1; i < list.size(); i++)
							model.addElement(list.get(i));
						playerList.setModel(model);
					}	
				}
			} catch(Exception ex) { ex.printStackTrace(); }
		}
	}
}
