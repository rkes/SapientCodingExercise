package com.globomart.sapient.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.globomart.sapient.entity.Price;
import com.globomart.sapient.pojo.ProductPojo;

/**
 * Created by Rakesh on 5/10/2017.
 */
@Service("priceServiceRestClient")
public class PriceServicesRestClient {

    @Autowired
    RestTemplate restTemplate;
    
    //@Value("http://${price.server.host}:${price.server.port}")
    @Value("http://localhost:8090")
    String server;
    
    public void changePriceOfProduct(Price price){
        String url=server+"/"+"changePrice";
    	restTemplate.put(url,price);
    }
    
    public Price getPrice(String priceId){
    	String url=server+"/"+"getPrice/"+priceId;
    	return restTemplate.getForObject(url, Price.class);
    }
    public Price createPrice(String price){
    	String url=server+"/"+"addPrice/"+price;
    	return restTemplate.postForObject(url,null,Price.class);
    }
	public Price changePriceOfProduct(String priceId, Double priceVal) {
		String url=server+"/updatePrice";
		Price price=new Price();
		price.setId(Long.parseLong(priceId));
		price.setPrice(priceVal);
		restTemplate.put(url, price);
		return price;
	}

	public void removePrice(String priceId) {
		String url=server+"/removePrice/"+priceId;
		restTemplate.delete(url);
	}

}
