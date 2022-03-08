package com.hit.clientandserver.test;

import java.io.IOException;

import com.hit.client.Client;

import util.Driver;

public class Init {
	public static void main(String[] args) {
		try {
			Driver.main(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Client client=new Client();
		new Thread(client).start();
	}
}


///Next steps:syncronize