package com.hit.server;


public class Request<T> {	
	
	Header header;
	T body;
	
	public Request() {
		this.header=new Header();
	}

	public Request(Request<T>.Header header,T body) {
		this.header=new Header(header.target, header.action);
		this.body = body;
	}


	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public T getBody() {
		return body;
	}


	public void setBody(T body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Request [ header=" + header + ", body=" + body + "]";
	}
	

	class Header{
		String target;
		String action;
		public Header() {
		}
		public Header(String target, String action) {
			this.target = target;
			this.action = action;
		}
		public String getTarget() {
			return target;
		}
		public void setTarget(String target) {
			this.target = target;
		}
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}
		@Override
		public String toString() {
			return "Header [target=" + target + ", action=" + action + "]";
		}
	}
}

