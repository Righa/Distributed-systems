
// package

// imports

import javax.swing.*;

public class ClientProtocol extends JFrame {

	JTextArea client_screen; 
	JTextField client_type; 
	JButton send_btn; 

	public ClientProtocol() {
		client_screen = new JTextArea();
		client_screen.setBounds(30, 30, 300, 300);

		client_type = new JTextField();
		client_type.setBounds(30, 360, 200, 40);  

		send_btn = new JButton("SEND");
		send_btn.setBounds(250, 360, 80, 40);
		          
		add(client_screen);
		add(client_type);  
		add(send_btn);

		setTitle("Client");          
		setSize(360,500); 
		setLayout(null);  
		setVisible(true);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);

	}
}
