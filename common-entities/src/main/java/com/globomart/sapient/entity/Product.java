package com.globomart.sapient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements java.io.Serializable {
	@Id
	@Column(name = "ID", nullable = false)
	private Long id;
	
	private String type;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String name;
	
	private String description;
	
	private Long priceId;
	
	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
