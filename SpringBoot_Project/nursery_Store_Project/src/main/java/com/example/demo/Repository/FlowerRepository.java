package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.flower;

@Repository
public interface FlowerRepository extends CrudRepository<flower, String>{

}
