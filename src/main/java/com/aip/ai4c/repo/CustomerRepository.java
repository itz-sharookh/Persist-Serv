package com.aip.ai4c.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aip.ai4c.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
