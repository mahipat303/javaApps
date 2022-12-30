package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Product;
import com.masai.model.ProductDTO;
import com.masai.service.ProductService;

import jakarta.validation.Valid;

@RestController
//@RequestMapping("/myapp")
public class ProductController {

	@Autowired
	private ProductService ps;

	@PostMapping("/products")
	public ResponseEntity<Product> registerProductHandler(@Valid @RequestBody Product product) {

		Product p = ps.registerProduct(product);

		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProductsHandler() {

		return new ResponseEntity<List<Product>>(ps.getAllProducts(), HttpStatus.OK);

	}

	@PutMapping("/products")
	public ResponseEntity<Product> updateProdcutHandler(@Valid @RequestBody Product product) {

		return new ResponseEntity<Product>(ps.updateProdcut(product), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProductByIdHandler(@PathVariable("id") Integer id) {

		return new ResponseEntity<Product>(ps.deleteProductById(id), HttpStatus.ACCEPTED);

	}

	@GetMapping("/productsbycategory")
	public ResponseEntity<List<Product>> getsProductByCategoryHandler(
			@RequestParam(name = "category") String category) {

		return new ResponseEntity<List<Product>>(ps.getsProductByCategory(category), HttpStatus.OK);

	}

	@GetMapping("/productdto")
	public ResponseEntity<List<ProductDTO>> getProductNameQtyPriceHandler() {

		return new ResponseEntity<List<ProductDTO>>(ps.getProductNameQtyPrice(), HttpStatus.OK);

	}

}
