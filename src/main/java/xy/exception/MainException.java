package xy.exception;

import javax.ws.rs.core.Response;

public class MainException extends Exception{

	private static final long serialVersionUID = 1L;
	private Response.Status status;
	private String msg;
	private String data;
	
	public MainException(){
		this.status = Response.Status.BAD_REQUEST;
		this.msg = "";
		this.data = "";
	}

	public Response.Status getStatus() {
		return status;
	}

	protected void setStatus(Response.Status status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	protected void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	protected void setData(String data) {
		this.data = data;
	}
}
