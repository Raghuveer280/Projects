package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.organic;

@Repository
public interface OrganicRepository extends CrudRepository<organic, String>{

}
