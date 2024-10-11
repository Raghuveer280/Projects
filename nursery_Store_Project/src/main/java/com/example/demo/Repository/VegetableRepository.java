package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.vegetables;

@Repository
public interface VegetableRepository extends CrudRepository<vegetables, String> {

}
