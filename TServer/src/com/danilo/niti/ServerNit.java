package com.danilo.niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.danilo.konstante.Konstante;

public class ServerNit extends Thread {
	public void run() {
		pokreniServer();
	}

	private void pokreniServer() {
		try {
			ServerSocket sSocket = new ServerSocket(Konstante.PORT.getPort());
			while(true) {
				Socket socket = sSocket.accept();
				KlijentNit kNit = new KlijentNit();
				kNit.setSocket(socket);
				kNit.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
