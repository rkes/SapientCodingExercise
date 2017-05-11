package com.globomart.sapient.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.sapient.entity.Price;


@Service("priceService")
public class PriceServices {
	
	@Autowired
	PriceDao priceDao;
	
	public Price getPrice(String priceId){
		return priceDao.getPrice(priceId);
	}
	public void removePrice(String priceId){
		priceDao.removePrice(priceId);
	}
	public void updatePrice(Price price){
		priceDao.updatePrice(price);
	}
	
}
