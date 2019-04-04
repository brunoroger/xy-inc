package xy.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import xy.objects.Products;
import xy.rest.ProductsRest;
import xy.util.UtilRest;

@TestMethodOrder(OrderAnnotation.class)
public class ProductsTest {
	
	private ProductsRest rest = new ProductsRest();
	private UtilRest util = new UtilRest();
	
	@Test
	@Order(1)
	void add() throws Exception {
        
		Products product = new Products();
        
        product.setName("test product add");
        product.setDescription("test product add");
        product.setCategory("test");
        product.setPrice(2);
        
        Response response  = this.rest.add(this.util.getObjectMapper().writeValueAsString(product));
		
        assertEquals(Response.Status.CREATED, response.getStatusInfo());
    }
	
	@Test
	@Order(2)
	void addNameNull() throws Exception {
        
		Products product = new Products();
        
        product.setDescription("test product add");
        product.setCategory("test");
        product.setPrice(2);
        
        Response response  = this.rest.add(this.util.getObjectMapper().writeValueAsString(product));
		
        assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
    }
	
	@Test
	@Order(3)
	void addNameEmpty() throws Exception {
        
		Products product = new Products();
        
        product.setName("");
        product.setDescription("test product add");
        product.setCategory("test");
        product.setPrice(2);
        
        Response response  = this.rest.add(this.util.getObjectMapper().writeValueAsString(product));
		
        assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
    }
	
	@Test
	@Order(4)
	void addDescriptionNull() throws Exception {
        
		Products product = new Products();
        
        product.setName("test product add");
        product.setCategory("test");
        product.setPrice(2);
        
        Response response  = this.rest.add(this.util.getObjectMapper().writeValueAsString(product));
		
        assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
    }
	
	@Test
	@Order(5)
	void addDescriptionEmpty() throws Exception {
        
		Products product = new Products();
        
        product.setName("test product add");
        product.setDescription("");
        product.setCategory("test");
        product.setPrice(2);
        
        Response response  = this.rest.add(this.util.getObjectMapper().writeValueAsString(product));
		
        assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
    }
	
	@Test
	@Order(6)
	void addCategoryNull() throws Exception {
        
		Products product = new Products();
        
        product.setName("test product add");
        product.setDescription("test product add");
        product.setPrice(2);
        
        Response response  = this.rest.add(this.util.getObjectMapper().writeValueAsString(product));
		
        assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
    }
	
	@Test
	@Order(7)
	void addCategoryEmpty() throws Exception {
        
		Products product = new Products();
        
        product.setName("test product add");
        product.setDescription("test product add");
        product.setCategory("");
        product.setPrice(2);
        
        Response response  = this.rest.add(this.util.getObjectMapper().writeValueAsString(product));
		
        assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
    }
	
	@Test
	@Order(8)
	void addPriceNull() throws Exception {
        
		Products product = new Products();
        
        product.setName("test product add");
        product.setDescription("test product add");
        product.setCategory("test");
        
        Response response  = this.rest.add(this.util.getObjectMapper().writeValueAsString(product));
		
        assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
    }
	
	@Test
	@Order(9)
	void edit() throws Exception {
		
		Products product = new Products();
        
        product.setName("test product edit");
        product.setDescription("test product edit");
        product.setCategory("test");
        product.setPrice(2);
        
        Response response  = this.rest.edit(1,this.util.getObjectMapper().writeValueAsString(product));
		
        assertEquals(Response.Status.OK, response.getStatusInfo());
    }
	
	@Test
	@Order(10)
	void remove() throws Exception {
		
        Response response  = this.rest.remove(1);
		
        assertEquals(Response.Status.OK, response.getStatusInfo());
    }
}
