package xy.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import xy.objects.Products;
import xy.service.ProductsService;

public class ServiceTest {
	
	@Test
	void add() throws Exception {
        Products product = new Products();
        
        product.setName("test product add");
        product.setDescription("test product add");
        product.setCategory("test");
        product.setPrice(2);
        
        ProductsService service = new ProductsService();
        Products response = service.add(product);
		
        assertEquals(product.toString(), response.toString());
    }
}
