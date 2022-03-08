package util;


import java.io.InputStream;
import java.io.PrintStream;

import com.hit.server.Server;
//console interface?????
public class CLI implements Runnable {
	Server server;
	InputStream in;
	PrintStream out;
	public CLI(InputStream in, PrintStream out) {
		this.in=in;
		this.out=out;
	}

	public void addPropertyChangeListener(Server server) {
		out.print("listening to server with port :"+server.getPortNum());
		this.server=server;
	}

	@Override
	public void run() {
		server.run();
	}

	public void stopServer() {
		server.setStatus(false);
	}
}
