package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Grains;
import com.example.demo.Entity.flower;
import com.example.demo.Entity.mimosa;
import com.example.demo.Entity.organic;
import com.example.demo.Entity.plants;
import com.example.demo.Entity.vegetables;
import com.example.demo.Repository.FlowerRepository;
import com.example.demo.Repository.GrainsRepository;
import com.example.demo.Repository.MimosaRepository;
import com.example.demo.Repository.OrganicRepository;
import com.example.demo.Repository.PlantsRepository;
import com.example.demo.Repository.VegetableRepository;

@Service
public class ProductService {

	@Autowired
	VegetableRepository vrepo;
	@Autowired
	GrainsRepository grepo;
	@Autowired
	PlantsRepository prepo;
	@Autowired
	FlowerRepository frepo;
	@Autowired
	OrganicRepository orepo;
	@Autowired
	MimosaRepository mrepo;
	
	//Vegetable Service
	public Iterable<vegetables> showAllVeg(){
		return vrepo.findAll();
	}
	
	public vegetables insertVeg(vegetables v) {
		return vrepo.save(v);
	}
	
	//Grains Service
	public Iterable<Grains> showAllGrains(){
		return grepo.findAll();
	}
	
	public Grains insertGrains(Grains g) {
		return grepo.save(g);
	}
	
	//Plants Service
	public Iterable<plants> showAllPlants(){
		return prepo.findAll();
	}
	
	public plants insertPlants(plants p) {
		return prepo.save(p);
	}
	
	//Flower Service
	public Iterable<flower> showAllFlowers(){
		return frepo.findAll();
	}
	
	public flower insertFlower(flower f) {
		return frepo.save(f);
	}
	
	//Organic Seeds Service
	public Iterable<organic> showAllOrganics(){
		return orepo.findAll();
	}
	
	public organic insertOrganic(organic o) {
		return orepo.save(o);
	}
	
	//Mimosa Seeds Service
	public Iterable<mimosa> showAll(){
		return mrepo.findAll();
	}
	
	public mimosa insertMimosa(mimosa m) {
		return mrepo.save(m);
	}
	public void deleteVeg(String name)
	{
		vrepo.deleteById(name);
	}
}
