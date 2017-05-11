package com.globomart.sapient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Price")
public class Price implements java.io.Serializable {
	@Id
	@Column(name = "ID", nullable = false)
	private Long id;

	private double price;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
