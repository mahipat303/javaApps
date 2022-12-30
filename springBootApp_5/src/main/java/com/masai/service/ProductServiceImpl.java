package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.model.ProductDTO;
import com.masai.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo pro;

	public Product registerProduct(Product p) throws ProductException {

		Product saveedProduct = pro.save(p);

		if (saveedProduct == null)
			throw new ProductException("invalid student details");

		return saveedProduct;

	}

	public List<Product> getAllProducts() throws ProductException {

		List<Product> products = pro.findAll();

		if (products.isEmpty()) {
			throw new ProductException("no product available in database");
		}

		return products;
	}

	@Override
	public Product updateProdcut(Product p) throws ProductException {

		Optional<Product> op = pro.findById(p.getProductId());

		if (op.isPresent()) {
			return pro.save(p);
		}

		throw new ProductException("no same product available in database");

	}

	@Override
	public Product deleteProductById(Integer pid) throws ProductException {

		Optional<Product> op = pro.findById(pid);

		if (op.isPresent()) {

			Product existingStudent = op.get();

			pro.delete(existingStudent);

			return existingStudent;

		} else
			throw new ProductException("product does not exist with id :" + pid);

	}

	@Override
	public List<Product> getsProductByCategory(String category) throws ProductException {

		List<Product> products = pro.findByCategory(category);

		if (products.isEmpty()) {
			throw new ProductException("no product available in database with category : " + category);
		}

		return products;

	}

	@Override
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException {
		List<ProductDTO> pdos = pro.getProductNameQtyPrice();

		if (pdos.isEmpty()) {
			throw new ProductException("No product available in database");
		}

		return pdos;
	}

}
