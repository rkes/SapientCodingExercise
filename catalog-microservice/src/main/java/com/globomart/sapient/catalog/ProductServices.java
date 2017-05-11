package com.globomart.sapient.catalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Rakesh on 5/10/2017.
 */

import com.globomart.sapient.dao.ProductDAO;
import com.globomart.sapient.entity.Price;
import com.globomart.sapient.entity.Product;
import com.globomart.sapient.pojo.ProductPojo;
import com.globomart.sapient.rest.PriceServicesRestClient;

@Service("productService")
public class ProductServices {
    @Autowired
    ProductDAO productDao;

    @Autowired
    PriceServicesRestClient priceRestClient;

    public List<ProductPojo> getAllProducts(){
        List<ProductPojo> products=productDao.getAllProducts();
        return products;
    }
    public ProductPojo getProduct(String productName){
    	ProductPojo product=productDao.getProduct(productName);
        return product;
    }
    public List<ProductPojo> getProductsByType(String productType){
    	List<ProductPojo> products=productDao.getProductsByType(productType);
        return products;
    }
    public ProductPojo removeProductByName(String productName){
    	ProductPojo product=productDao.removeProductByName(productName);
        return product;
    }
    public String removeProductById(String productId){
    	String priceId=productDao.removeProductById(productId);
    	if(null!=priceId && priceId.length()>0){
    		priceRestClient.removePrice(priceId);
    		return "Product and its price is Removed ";
    	}
        return "Product not found";
    }
    public Product addProductDetails(Product productObj,Double price){
    	Product product=productDao.addProductDetails(productObj,price);
        return product;
    }
   public ProductPojo updateProductPrice(String productId, Price price) {
		Product prod=productDao.getPriceId(productId);
		if(prod==null){
            return null;
        }
		ProductPojo prodPojo=new ProductPojo();
		prodPojo.setDescription(prod.getDescription());
		prodPojo.setName(prod.getName());
		prodPojo.setId(prod.getId());
		prodPojo.setPriceId(prod.getPriceId());
		prodPojo.setPrice(price);
		priceRestClient.changePriceOfProduct(prod.getPriceId().toString(), price.getPrice());
		
		return prodPojo;
	}
}
