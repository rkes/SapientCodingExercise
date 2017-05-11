package com.globomart.sapient.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globomart.sapient.entity.Price;
import com.globomart.sapient.entity.Product;
import com.globomart.sapient.pojo.ProductPojo;
import com.globomart.sapient.repository.CatalogRepository;
import com.globomart.sapient.rest.PriceServicesRestClient;

/**
 * Created by Rakesh on 5/10/2017.
 */
@Repository
public class ProductDAO {
	private CatalogRepository productRepository;
	
	@Autowired
	PriceServicesRestClient priceServicesRestClient;
	
	@Autowired
	public void setProductRepository(CatalogRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<ProductPojo> getAllProducts() {
		List<ProductPojo> productPojos=new LinkedList<ProductPojo>();
		for(Product product:productRepository.findAll()){
			ProductPojo pojo=new ProductPojo();
			pojo.setId(product.getId());
			pojo.setDescription(product.getDescription());
			pojo.setName(product.getName());
			pojo.setType(product.getType());
			Price price=priceServicesRestClient.getPrice(product.getPriceId().toString());
			pojo.setPriceId(price.getId());
			pojo.setPrice(price);
			productPojos.add(pojo);
		}
		return productPojos;
	}

	public ProductPojo getProduct(String productName) {
		List<ProductPojo> prodPojos=getAllProducts();
		for(ProductPojo pojo:prodPojos){
			if(pojo.getName().equals(productName))
				return pojo;
		}
		return null;
	}

	public Product addProductDetails(Product product,Double priceVal) {
		Price price=priceServicesRestClient.createPrice(priceVal+"");
		product.setId(System.nanoTime());
		product.setPriceId(price.getId());
		productRepository.save(product);
		return product;
	}

	public ProductPojo removeProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getPriceId(String productId) {
		return productRepository.findOne(Long.parseLong(productId));
	}

	public String removeProductById(String productId) {
		if(productRepository.exists(Long.parseLong(productId))){
			String priceId=productRepository.findOne(Long.parseLong(productId)).getPriceId()+"";
			productRepository.delete(Long.parseLong(productId));
			return priceId; 
		}
		return "";
	}

	public List<ProductPojo> getProductsByType(String productType) {
		List<ProductPojo> prodPojos=getAllProducts();
		for(ProductPojo pojo:prodPojos){
			if(pojo.getName().equalsIgnoreCase(productType))
				prodPojos.add(pojo);
		}
		return prodPojos;
	}

}
