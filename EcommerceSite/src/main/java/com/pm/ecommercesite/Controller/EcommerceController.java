package com.pm.ecommercesite.Controller;

import com.pm.ecommercesite.Mapper.OrderResponseDTO;
import com.pm.ecommercesite.Model.Order;
import com.pm.ecommercesite.Service.EcommerceService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class EcommerceController {

    @Autowired
    EcommerceService ecommerceService;

    @PostMapping()
    public ResponseEntity<OrderResponseDTO> buyProduct(@RequestBody Order order){
        OrderResponseDTO order1 = ecommerceService.buyProduct(order);
        return new ResponseEntity<>(order1, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Order>> findAll(){
        List<Order> order = ecommerceService.getAllOrders();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
