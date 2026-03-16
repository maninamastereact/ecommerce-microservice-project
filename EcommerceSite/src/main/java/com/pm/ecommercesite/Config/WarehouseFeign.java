package com.pm.ecommercesite.Config;

import com.pm.ecommercesite.Mapper.WarehouseResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Warehouse-service",url = "http://localhost:8081")
public interface WarehouseFeign {

    @GetMapping("/warehouse/{id}")
    public WarehouseResponseDTO getWarehouseById(@PathVariable int id);
}
