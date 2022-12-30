package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;

	@NotNull(message = "{name.null}")
	@Size(min=3,max=5,message = "{name.invalid}")
	private String productName;

	@NotNull(message = "{quantity.null}")
	@Min(message = "{quantity.invalid}", value = 1)
	private Integer quantity;

	@NotNull(message = "{price.null}")
	private Double price;

	@NotNull(message = "{category.null}")
	private String category; // here category should be Stationary, Grocery, Electronics

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, Integer quantity, Double price, String category) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + ", category=" + category + "]";
	}

}
