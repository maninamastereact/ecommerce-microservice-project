package com.pm.warehouse.Controller;

import com.pm.warehouse.Model.Warehouse;
import com.pm.warehouse.Service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;


    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Integer id) {
        Warehouse warehouse = warehouseService.findbyId(id);
        return new ResponseEntity<>(warehouse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouse() {
        List<Warehouse> warehouses = warehouseService.getWarehouses();
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Warehouse> saveWarehouse(@RequestBody Warehouse warehouse){
        Warehouse warehouse1 = warehouseService.save(warehouse);
        return new ResponseEntity<>(warehouse1, HttpStatus.OK);
    }
}
