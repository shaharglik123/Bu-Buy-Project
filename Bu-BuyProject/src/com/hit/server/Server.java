package com.hit.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.google.gson.Gson;
import com.hit.service.BuBuyController;

public class Server implements Runnable{
	private int portNum;
	static final int  MAX_POOL_SIZE= 10;
	boolean status=true;

	ServerSocket serverSocket = null;
	Request<?> request;
	Response response;
	Object obj;
	ExecutorService pool;
	HandleRequest handleRequest;
	public Server(int port) throws IOException {
		this.portNum=port;
	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(portNum);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ObjectOutputStream outref = null;
		while(status) {
		try {
			Socket clientSocket = serverSocket.accept();
			System.out.println("wating client to connect");
			@SuppressWarnings("resource")
			//System.out.println("client connected");
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			outref=out;
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			out.writeObject("you are now connected to the server");
			out.flush();
		    // creates a thread pool with MAX_T no. of threads as the fixed pool size(Step 2)
	        pool = Executors.newFixedThreadPool(MAX_POOL_SIZE);

	        request =(Request<?>)new Gson().fromJson((String)in.readObject(), Request.class);
			HandleRequest HR=new HandleRequest(request, new BuBuyController());
			pool.execute(HR);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(HR.response!=null) {
				System.out.println(HR.response);
			out.writeObject(HR.response.toString());
			}
			out.close();
			in.close();
			clientSocket.close();
		}catch (ClassNotFoundException  e) {
		e.printStackTrace();
		}catch (java.net.SocketException e) {
		System.err.println("Server Timeout ??? ");
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}	
		try {
			outref.writeObject(null);
			pool.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getPortNum() {
		return portNum;
	}

	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}
	
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
