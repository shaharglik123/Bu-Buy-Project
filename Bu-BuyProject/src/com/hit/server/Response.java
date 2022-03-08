package com.hit.server;


public class Response {
	public String body;
	
	public Response() {
	}

	public Response(String body) {

		this.body=body;
	}

public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}

@Override
public String toString() {
	return "Response [body=" + body + "]";
}
}

