/*
1. Ask the client program 
2. Ask the client program to  (first name,  etc.)
3. Ask the client program to send the student ,  and  to the server program
4. Ask the client program to send the  (Innovate ☺)
5. Ask the client program to send all the above in one instruction to the server program.
6. Send the client program a message to indicate the communication succeeded or aborted.
*/

// package

// imports

import java.net.*;
import java.io.*;


public class SocketServer {
	public static void main(String[] args) throws IOException {
		String[] prompts = {"student number","first name","surname","faculty","course","degree course","personal code"};
		ServerSocket ss;
		Socket s;
		ServerProtocol sp;
		DataInputStream din;
		DataOutputStream dout;


		try {

			ss = new ServerSocket(8001);
			sp = new ServerProtocol();

			sp.server_screen.setText("Waiting for client...");

			s = ss.accept();
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			sp.server_screen.setText(sp.server_screen.getText() + "\nClient connected!");

			int i = 0;

			while(i<prompts.length) {
				dout.writeUTF(prompts[i]);
				sp.server_screen.setText(sp.server_screen.getText() + "\n> " + prompts[i]);
				sp.server_screen.setText(sp.server_screen.getText() + "\nClient: " + din.readUTF());
				i++;
			}

			dout.writeUTF("  *Student registered successfully*");

		}
		catch (Exception e) {
			//
		}
	}
}
