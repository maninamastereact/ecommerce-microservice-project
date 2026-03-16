package com.pm.ecommercesite.Repository;

import com.pm.ecommercesite.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommerceRepository extends JpaRepository<Order, Integer> {
}
