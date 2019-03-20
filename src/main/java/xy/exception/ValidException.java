package xy.exception;

public class ValidException extends MainException{

	private static final long serialVersionUID = 1L;

	public ValidException(String msg){
		this.setMsg(msg);
	}
}
