package com.pm.ecommercesite.Service;

import com.pm.ecommercesite.Config.WarehouseFeign;
import com.pm.ecommercesite.EcommerceSiteApplication;
import com.pm.ecommercesite.Mapper.OrderResponseDTO;
import com.pm.ecommercesite.Mapper.ProductResponseDTO;
import com.pm.ecommercesite.Mapper.WarehouseResponseDTO;
import com.pm.ecommercesite.Model.Order;
import com.pm.ecommercesite.Repository.EcommerceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EcommerceService {

    EcommerceRepository ecommerceRepository;
    WebClient webClient;
    WarehouseFeign warehouseFeign;

    public EcommerceService(EcommerceRepository ecommerceRepository, WebClient webClient, WarehouseFeign warehouseFeign) {
        this.ecommerceRepository = ecommerceRepository;
        this.webClient = webClient;
        this.warehouseFeign = warehouseFeign;
    }

    public OrderResponseDTO buyProduct(Order order){

        WarehouseResponseDTO warehouseResponseDTO =
        warehouseFeign.getWarehouseById(order.getProductId());

        ProductResponseDTO productResponseDTO =
                webClient.get()
                        .uri("/product/{id}",order.getProductId())
                        .retrieve()
                        .bodyToMono(ProductResponseDTO.class)
                        .block();
        System.out.println(productResponseDTO);

        //Setting values to OrderResponse DTO//////////////////////////////////////////////////////////
        Order order1 =  ecommerceRepository.save(order);
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.orderId = order1.getOrderId();
        orderResponseDTO.productId = order1.getProductId();
        orderResponseDTO.name = cproductResponseDTO.name;
        orderResponseDTO.quantity = order1.getQuantity();
        orderResponseDTO.price = productResponseDTO.price;
        orderResponseDTO.totalPrice = productResponseDTO.price*order1.getQuantity();
        orderResponseDTO.remainingStock = warehouseResponseDTO.stock;
        //Setting values to OrderResponse DTO//////////////////////////////////////////////////////////

        return orderResponseDTO;
    }

    public List<Order> getAllOrders(){
        return ecommerceRepository.findAll();
    }
}
