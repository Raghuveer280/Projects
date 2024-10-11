package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Grains;

@Repository
public interface GrainsRepository extends CrudRepository<Grains, String>  {

}
