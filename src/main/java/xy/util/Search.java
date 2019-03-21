package xy.util;

import javax.ws.rs.core.MultivaluedMap;

public class Search {

	private MultivaluedMap<String,String> parameters;

	public void setParameters(MultivaluedMap<String, String> parameters) {
		this.parameters = parameters;
	}
	
	public String getString(String key){
		
		String returnParameter = this.parameters.getFirst(key);
		
		if(returnParameter != null && !returnParameter.isEmpty()){
			return returnParameter;
		}else{
			return null;
		}
	}
	
	public int getInt(String key) throws Exception{
		
		String returnParameter = this.getString(key);
		
		if(returnParameter != null){
			return Integer.parseInt(returnParameter);
		}else{
			return 0;
		}
	}
	
	public double getDouble(String key) throws Exception{
		
		String returnParameter = this.getString(key);
		
		if(returnParameter != null){
			return Double.parseDouble(returnParameter);
		}else{
			return 0;
		}
	}
}
