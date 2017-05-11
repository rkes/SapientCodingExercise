package com.globomart.sapient.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globomart.sapient.entity.Price;
import com.globomart.sapient.repository.PriceRepository;

@Component
public class PriceDao {

	private PriceRepository productRepository;

	@Autowired
	public void setProductRepository(PriceRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Price getPrice(String priceId) {
		return productRepository.findOne(Long.parseLong(priceId));
	}

	public Price addPrice(Double price) {
		Price priceObj = new Price();
		priceObj.setId(System.nanoTime());
		priceObj.setPrice(price);
		productRepository.save(priceObj);
		return priceObj;
	}

	public String removePrice(String priceId) {
		if (getPrice(priceId) != null) {
			productRepository.delete(Long.valueOf(priceId));
			return "Price with PriceId : " + priceId + " Deleted";
		} else
			return "";
	}

	public Price updatePrice(Price price) {
		if(getPrice(price.getId()+"")!=null){
			Price priceObj=new Price();
			priceObj.setPrice(price.getPrice());
			priceObj.setId(price.getId());
			productRepository.delete(Long.valueOf(price.getId()));
			return productRepository.save(priceObj);
		}
		return null;
	}
	
}
