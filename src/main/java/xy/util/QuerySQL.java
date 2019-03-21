package xy.util;

import java.util.HashMap;
import java.util.List;

public class QuerySQL {

	private String sql;
	private HashMap<String, Object> parameters;
	private HashMap<String, List<Integer>> listParameter;
	
	public QuerySQL(){
		this.parameters = new HashMap<String, Object>();
	}
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public HashMap<String, Object> getParameters() {
		return parameters;
	}
	
	public void setParameter(String key, Object value){
		this.parameters.put(key, value);
	}

	public void setListParameter(String key, List<Integer> listId){
		this.listParameter.put(key, listId);
	}
	
	public HashMap<String, List<Integer>> getListParameter() {
		return listParameter;
	}
}
