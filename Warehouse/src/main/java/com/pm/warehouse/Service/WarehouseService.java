package com.pm.warehouse.Service;

import com.pm.warehouse.Model.Warehouse;
import com.pm.warehouse.Repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository){
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> getWarehouses(){
        return warehouseRepository.findAll();
    }

    public Warehouse findbyId(int id){
        Warehouse warehouse = warehouseRepository.findById(id).get();
        return warehouse;
    }

    public Warehouse save(Warehouse warehouse){
        Warehouse warehouse1  =  warehouseRepository.save(warehouse);
        return warehouse1;
    }


}
