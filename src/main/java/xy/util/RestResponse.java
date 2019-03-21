package xy.util;

import xy.exception.MainException;

public class RestResponse {

	private String message;
	private Object data;
	
	public RestResponse(Exception e){
		
		if(e instanceof MainException){
			this.responseExMain((MainException) e);
		}else{
			this.responseEx(e);
		}
	}
	
	public RestResponse(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

	private void responseExMain(MainException e){
		this.message = e.getMsg();
		this.data = e.getData();
	}
	
	private void responseEx(Exception e){
		e.printStackTrace();
		this.message = "Internal Server Error";
		this.data = e.getMessage();
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
}
