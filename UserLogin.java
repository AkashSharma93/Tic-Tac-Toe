import javax.swing.*;
import java.awt.event.*;

public class UserLogin {
	Player player;
	JFrame frame;
	JTextField txtName = new JTextField();
	
	public UserLogin(Player p) {
		setPlayer(p);
		setUpFrame();
	}
	
	public void setPlayer(Player p) {
		// Set the player attribute
		player = p;
	}
	
	public void setUpFrame() {
		// Set up the User Login screen
		
		frame = new JFrame();
		
		txtName.setSize(100, 50);
		txtName.setText("aaa");
		
		JPanel panel = new JPanel();
		JButton loginButton = new JButton("Login");
		loginButton.setSize(100, 50);
		loginButton.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar() == '\n') {
					handleLogin();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {}

			@Override
			public void keyTyped(KeyEvent arg0) {}
			
		});
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handleLogin();
			}
			
		});
		
		panel.add(txtName);
		panel.add(loginButton);
		
		frame.add(panel);
		frame.setSize(200, 100);
		frame.setTitle("User Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void handleLogin() {
		// Handle stuff that happens on Login button press
		
		// Set the name
		if (txtName.getText() != "") {
			player.setName(txtName.getText());
		}
		else {
			txtName.setText("Enter a name!");
			return;
		}
		
		// Set up networking
		player.setupNetworking();
		
		// Dispose UserLogin screen
		frame.dispose();
	}
}
