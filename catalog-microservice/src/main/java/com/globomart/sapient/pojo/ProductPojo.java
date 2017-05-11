package com.globomart.sapient.pojo;

import com.globomart.sapient.entity.Price;
import com.globomart.sapient.entity.Product;

/**
 * Created by Rakesh on 5/10/2017.
 */
public class ProductPojo extends Product{
	
	private Price price;

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
	
}
