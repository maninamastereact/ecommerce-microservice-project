package com.pm.product.Service;

import com.pm.product.Mapper.WarehouseResponseDTO;
import com.pm.product.Model.Product;
import com.pm.product.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;
    RestTemplate restTemplate;

    public ProductService(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product findbyid(int id){
        return productRepository.findById(id).get();
    }

    public WarehouseResponseDTO getStockbyId(int id){
        return restTemplate.getForObject("http://localhost:8081/warehouse/" + id , WarehouseResponseDTO.class );
    }
}
