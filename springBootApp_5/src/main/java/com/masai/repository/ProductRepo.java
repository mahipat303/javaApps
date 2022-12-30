package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.model.ProductDTO;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	public List<Product> findByCategory(String address);
	
	
	@Query("select new com.masai.model.ProductDTO(p.productName,p.quantity,p.price) from Product p")
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException;

}
