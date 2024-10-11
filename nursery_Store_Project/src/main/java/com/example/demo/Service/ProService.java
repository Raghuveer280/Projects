package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.cart;
import com.example.demo.Entity.product;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.productRepo;


@Service
public class ProService {
	@Autowired
	productRepo prorepo;
	@Autowired
	CartRepository cartrepo;
	public product search(int id)
	{
		return prorepo.findById(id).get();
	}
	public cart insert(cart p)
	{
		return cartrepo.save(p);
	}
	public Iterable<cart> show()
	{
		return cartrepo.findAll();
	}
	public void delete(int id)
	{
		cartrepo.deleteById(id);
	}
	
}
