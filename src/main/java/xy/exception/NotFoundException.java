package xy.exception;

import javax.ws.rs.core.Response;

public class NotFoundException extends MainException{

	private static final long serialVersionUID = 1L;
	
	public NotFoundException(){
		this.setMsg("Recurso não encontrado.");
		this.setStatus(Response.Status.NOT_FOUND);
	}
}
