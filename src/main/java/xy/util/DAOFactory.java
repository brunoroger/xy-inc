package xy.util;

import xy.bd.interfaces.ProductsDAO;
import xy.bd.jpa.ProductsJPADAO;

public class DAOFactory {

	@SuppressWarnings("rawtypes")
	public static Object getInstanceOf(Class c){
		
		if (c.equals(ProductsDAO.class)) {
			return new ProductsJPADAO();
		} else {
			return null;
		}
	}
}
