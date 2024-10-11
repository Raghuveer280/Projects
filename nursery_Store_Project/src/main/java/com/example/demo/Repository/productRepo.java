package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.product;

@Repository
public interface productRepo extends CrudRepository<product, Integer> {

}
