
// package

// imports

import javax.swing.*;

public class ServerProtocol extends JFrame {

	JTextArea server_screen;

	public ServerProtocol() {
		server_screen = new JTextArea();
		server_screen.setBounds(30, 30, 300, 400);

		add(server_screen);

		setTitle("Server");
		setSize(360, 500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
}
