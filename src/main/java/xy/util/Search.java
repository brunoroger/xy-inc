package xy.util;

import javax.ws.rs.core.MultivaluedMap;

public class Search {

	private MultivaluedMap<String,String> parametros;

	public void setParametros(MultivaluedMap<String, String> parametros) {
		this.parametros = parametros;
	}
	
	public String getString(String chave){
		
		String retorno = this.parametros.getFirst(chave);
		
		if(retorno != null && !retorno.isEmpty()){
			return retorno;
		}else{
			return null;
		}
	}
	
	public int getInt(String chave) throws Exception{
		
		String retorno = this.getString(chave);
		
		if(retorno != null){
			return Integer.parseInt(retorno);
		}else{
			return 0;
		}
	}
	
	public double getDouble(String chave) throws Exception{
		
		String retorno = this.getString(chave);
		
		if(retorno != null){
			return Double.parseDouble(retorno);
		}else{
			return 0;
		}
	}
}
