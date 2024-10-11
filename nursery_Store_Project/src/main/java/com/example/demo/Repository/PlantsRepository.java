package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.plants;

@Repository
public interface PlantsRepository extends CrudRepository<plants, String> {
	
}
