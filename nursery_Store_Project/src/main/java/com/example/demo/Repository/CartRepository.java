package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.cart;

@Repository
public interface CartRepository extends CrudRepository<cart, Integer>{

}
