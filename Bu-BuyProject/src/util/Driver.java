package util;
import java.io.IOException;
import com.hit.server.Server;

public class Driver {
		public static void main(String[] args) throws IOException {
		CLI cli = new CLI(System.in, System.out);
		Server server = new Server(123);
		cli.addPropertyChangeListener(server);
		new Thread(cli).start();
		}
}
