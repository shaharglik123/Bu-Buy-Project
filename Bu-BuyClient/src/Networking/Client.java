package Networking;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	static Socket myServer;
	static ObjectOutputStream output;
	static ObjectInputStream input;
	
	public String sendData(String data) {
		return sendRequest(data);
	}
	
	private static String sendRequest(String data) {
		String revStr = "";
		try{
			InetAddress localaddr = InetAddress.getLocalHost();

			myServer = new Socket(localaddr.getHostAddress(), 123);
			output=new ObjectOutputStream(myServer.getOutputStream());
			input=new ObjectInputStream(myServer.getInputStream());
			revStr = (String) input.readObject();
			
			output.writeObject(data);
			output.flush();

			revStr = (String) input.readObject();
			System.out.println(revStr);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return revStr;
	}

	@Override
	protected void finalize() throws Throwable {
		output.close();
		input.close();
		myServer.close();
	}
}
