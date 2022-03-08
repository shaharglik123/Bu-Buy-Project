package com.hit.dao;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream{

	public MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
	public MyObjectOutputStream() throws IOException {
		super();
	}
	public void writeStreamHeader(){}// This overrides the method in the parent class, so that he does not write to the file header when calling writeObject()
	
}
