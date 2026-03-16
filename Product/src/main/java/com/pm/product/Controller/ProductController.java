package com.pm.product.Controller;

import com.pm.product.Mapper.WarehouseResponseDTO;
import com.pm.product.Model.Product;
import com.pm.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> result = productService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product result = productService.save(product);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductbyid(@PathVariable int id){
        Product result = productService.findbyid(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/stock/{id}")
    public ResponseEntity<WarehouseResponseDTO> getWarehousebyid(@PathVariable int id){
        WarehouseResponseDTO warehouseResponseDTO = productService.getStockbyId(id);
        return new ResponseEntity<>(warehouseResponseDTO, HttpStatus.OK);
    }

}
