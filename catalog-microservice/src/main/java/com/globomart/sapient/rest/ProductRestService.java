package com.globomart.sapient.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.sapient.catalog.ProductServices;
import com.globomart.sapient.entity.Price;
import com.globomart.sapient.entity.Product;
import com.globomart.sapient.pojo.ProductPojo;

@RestController
@EnableAutoConfiguration
public class ProductRestService {
	
	@Autowired
	private ProductServices prodService;
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public Product createProduct(@RequestBody Product prodObj,@RequestParam(value="price") String price ){
		return prodService.addProductDetails(prodObj,Double.parseDouble(price));	
	}
	@RequestMapping(value="/getAllProduct", method=RequestMethod.GET)
	public List<ProductPojo> getAllProduct(){
		return prodService.getAllProducts();	
	}
	@RequestMapping(value="/getProductByType", method=RequestMethod.GET)
	public List<ProductPojo> getProductsByType(@RequestParam(value = "type") String type){
		return prodService.getProductsByType(type);	
	}
	@RequestMapping(value="/getProduct", method=RequestMethod.GET)
	public ProductPojo getProduct(@RequestParam(value = "name") String name){
		return prodService.getProduct(name);	
	}
	@RequestMapping(value="/updateProductPrice/{productId}", method=RequestMethod.PUT)
	public ProductPojo updateProductPrice(@PathVariable("productId") String productId ,@RequestBody Price price){
		return prodService.updateProductPrice(productId,price);	
	}
	@RequestMapping(value="/removeProduct/{productId}", method=RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("productId") String productId ){
		return prodService.removeProductById(productId);	
	}
}
