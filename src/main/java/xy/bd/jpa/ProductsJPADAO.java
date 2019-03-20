package xy.bd.jpa;

import java.util.List;

import xy.util.QuerySQL;
import xy.bd.interfaces.ProductsDAO;
import xy.objects.Products;
import xy.util.Search;

public class ProductsJPADAO extends JPAAbstract<Products, Integer> implements ProductsDAO{

	public List<Products> list(Search search) throws Exception {
		
		QuerySQL query = new QuerySQL();
		
		String txt = "SELECT P FROM "+ this.getEntityName() +" P";
		
		query.setSql(txt);
		
		return this.getList(query);
	}
}
