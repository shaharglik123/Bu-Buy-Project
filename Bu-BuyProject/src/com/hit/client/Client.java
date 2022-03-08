package com.hit.client;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.hit.dm.Customer;

public class Client implements Runnable, Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	InetAddress address;
	Socket myServer;
	ObjectOutputStream output;
	ObjectInputStream input;
	Customer cust;

	@Override
	public void run() {
			try {
				address = InetAddress.getLocalHost();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} 
		try {
			System.out.println("Enter request");
			// Creating a File object for directory
			File directoryPath = new File("C:\\Users\\shaha\\eclipse-workspace.2\\Bu-BuyProject\\json request files");
			// List of all files and directories
			File filesList[] = directoryPath.listFiles();
			for (File file : filesList) {
				try {
					myServer = new Socket(address, 123);
					output = new ObjectOutputStream(myServer.getOutputStream());
					input = new ObjectInputStream(myServer.getInputStream());
					try {
						System.out.println((String) input.readObject());
					} catch (Exception e) {
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				output.writeObject(Files.readString(Path.of(file.getAbsolutePath())));
				String filename =file.getName();
				if (filename.contains("get")||filename.contains("search"))
					System.out.println(input.readObject().toString());
				System.out.println("");
			}
			output.writeObject(null);
			System.out.println((String) input.readObject());
			Thread.sleep(5000);
			output.flush();
			output.close();
			input.close();
			myServer.close();
		} catch (IOException | ClassNotFoundException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}