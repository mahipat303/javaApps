package com.masai.model;

public class ProductDTO {

	private String productName;
	private Integer quantity;
	private Double price;

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPuantity() {
		return quantity;
	}

	public void setPuantity(Integer puantity) {
		this.quantity = puantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductDTO(String productName, Integer puantity, Double price) {
		super();
		this.productName = productName;
		this.quantity = puantity;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDTO [productName=" + productName + ", puantity=" + quantity + ", price=" + price + "]";
	}

}
