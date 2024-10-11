package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.userdata;

@Repository
public interface UserRepository extends CrudRepository<userdata, String> {
	public List<userdata> findByUsernameIgnoreCaseAndPw(String username,String pw);

}
