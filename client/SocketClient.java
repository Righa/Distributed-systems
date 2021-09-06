/*
1. Send your student number to the server program
2. Send your student name (first name, surname etc.) to the server program
3. Send your student faculty, course and degree to the server program
4. Send a thank you message with personal code (Innovate☺) to the server program.
5. Send all the above in one instruction to the server program
*/

// package

// imports

import java.net.*;
import java.io.*;
import java.awt.event.*;

public class SocketClient {
	public static void main(String[] args) throws IOException {

		Socket s;
		DataInputStream din;
		DataOutputStream dout;
		ClientProtocol cp;
		

		try {
			s = new Socket("localhost", 8001);
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			cp = new ClientProtocol();

			cp.client_screen.setText("Connected to server!");

			cp.send_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						cp.client_screen.setText(cp.client_screen.getText() + "\n> " + cp.client_type.getText());
						dout.writeUTF(cp.client_type.getText());
					}
					catch (Exception ex) {
						//
					}
				}
			});

			String msg = "";

			while(!msg.equals("exit")) {
				msg = din.readUTF();
				cp.client_screen.setText(cp.client_screen.getText() + "\nServer: " + msg);
				cp.client_type.setText(null);
			}
		}
		catch (Exception ex){
			System.out.println("Unable to connect, exitting...");
		}	

	}
}
