package xy.rest;

import javax.ws.rs.Path;

import xy.objects.Products;
import xy.service.ProductsService;

@Path("/products")
public class ProductsRest extends RestAbstract<Products, Integer, ProductsService>{}
