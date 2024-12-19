package org.jsp.product_api.controller;

import java.util.List;

import org.jsp.product_api.dto.Product;
import org.jsp.product_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@Operation(summary = "Saving One Product")
	@PostMapping("/products")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product){
		return service.saveProduct(product);
	}
	
	@Operation(summary = "Save Multiple Products")
	@PostMapping("/products/many")
	public ResponseEntity<Object> saveProducts(@RequestBody List<Product> products){
		return service.saveProducts(products);
	}
	
	@Operation(summary = "Fetch All Products")
	@GetMapping("/products")
	public ResponseEntity<Object> fetchAllProducts(){
		return service.fetchAllProducts();
	}
	
	@Operation(summary = "Fetch Product By Id")
	@GetMapping("/products/{id}")
	public ResponseEntity<Object> fetchById(@PathVariable int id){
		return service.fetchById(id);
	}
	
	@Operation(summary = "Fetch Product By Name")
	@GetMapping("/products/name/{name}")
	public ResponseEntity<Object> fetchByName(@PathVariable String name){
		return service.fetchByName(name);
	}
	
	@Operation(summary = "Fetch Products Price Greater Than")
	@GetMapping("/products/price/greater/{price}")
	public ResponseEntity<Object> fetchByPriceGreater(@PathVariable double price){
		return service.fetchByPriceGreater(price);
	}
	
	@Operation(summary = "Fetch Products By Stock Between")
	@GetMapping("/products/stock/{min}/{max}")
	public ResponseEntity<Object> fetchByStockBetween(@PathVariable int min,@PathVariable int max){
		return service.fetchByStockBetween(min,max);
	}
	
	@Operation(summary = "Delete Product By Id")
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id){
		return service.deleteById(id);
	}
	
	@Operation(summary = "Update Product - PUT")
	@PutMapping("/products")
	public ResponseEntity<Object> updateRecord(@RequestBody Product product){
		return service.updateProduct(product);
	}
	
	@Operation(summary = "Update Product- PATCH")
	@PatchMapping("/products/{id}")
	public ResponseEntity<Object> updateRecord(@PathVariable int id,@RequestBody Product product){
		return service.updateProduct(id,product);
	}
}
