package com.globomart.sapient.web;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.sapient.entity.Price;
import com.globomart.sapient.price.PriceDao;

import org.slf4j.Logger;

@RestController
@EnableAutoConfiguration
public class PriceRestService {
	
	@Autowired
	private PriceDao priceDao;
	
	private static final Logger logger = LoggerFactory.getLogger(PriceRestService.class);	
	
	@RequestMapping(value="/getPrice/{priceId}",method=RequestMethod.GET)
	public Price getPrice(@PathVariable("priceId") String priceId ){
		logger.info("Get Price Called for Price Id :  "+priceId);
		return priceDao.getPrice(priceId);
	}
	@RequestMapping(value="/addPrice/{price}", method=RequestMethod.POST)
	public Price addPrice(@PathVariable("price") String  price ){
		logger.info("Add Price Called for Price Value :  "+price);
		return priceDao.addPrice(Double.valueOf(price));
	}
	@RequestMapping(value="/removePrice/{priceId}",method=RequestMethod.DELETE)
	public String removePrice(@PathVariable("priceId") String priceId ){
		logger.info("Remove Price Called for Price Id :  "+priceId);
		return priceDao.removePrice(priceId);
	}
	@RequestMapping(value="/updatePrice",method=RequestMethod.PUT)
	public Price updatePrice(@RequestBody Price price){
		 if(price!=null){
			 logger.info("Update Price Called for Price Id :  "+price.getId());
			 return priceDao.updatePrice(price);
		 }
		 return null;
	}
}
