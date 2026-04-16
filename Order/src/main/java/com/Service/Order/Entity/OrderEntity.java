package com.Service.Order.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String userName;
	private String productName;
	private String price;
	private String jwtToken;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public OrderEntity(Long id, String userName, String productName, String price) {
		super();
		this.id = id;
		this.userName = userName;
		this.productName = productName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userName=" + userName + ", productName=" + productName + ", price=" + price + "]";
	}

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public OrderEntity(Long id, String userName, String productName, String price, String jwtToken) {
		super();
		this.id = id;
		this.userName = userName;
		this.productName = productName;
		this.price = price;
		this.jwtToken = jwtToken;
	}

}
