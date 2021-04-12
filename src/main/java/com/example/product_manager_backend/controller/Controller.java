package com.example.product_manager_backend.controller;

import com.example.product_manager_backend.model.Category;
import com.example.product_manager_backend.model.Product;
import com.example.product_manager_backend.service.category.ICategoryService;
import com.example.product_manager_backend.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class Controller {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category-list")
    private ResponseEntity<List<Category>> sentListCategory() {
        return new ResponseEntity<>(categoryService.findALl(), HttpStatus.OK);
    }

    @GetMapping("/product-list")
    public ResponseEntity<List<Product>> getProductList() {
        List<Product> productList = productService.findALl();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add-new")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/update-product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        productService.deleteById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
