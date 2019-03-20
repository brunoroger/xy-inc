package xy.util;

import java.util.HashMap;
import java.util.List;

public class QuerySQL {

	private String sql;
	private HashMap<String, Object> parametros;
	private HashMap<String, List<Integer>> listParameter;
	
	public QuerySQL(){
		this.parametros = new HashMap<String, Object>();
	}
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public HashMap<String, Object> getParametros() {
		return parametros;
	}
	
	public void setParameter(String chave, Object valor){
		this.parametros.put(chave, valor);
	}

	public void setListParameter(String chave, List<Integer> listId){
		this.listParameter.put(chave, listId);
	}
	
	public HashMap<String, List<Integer>> getListParameter() {
		return listParameter;
	}
}
