package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.userdata;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userrepo;
	public List<userdata> search(String username,String pw)
	{
		return userrepo.findByUsernameIgnoreCaseAndPw(username,pw);
	}
	public userdata create(userdata user)
	{
		return userrepo.save(user);
	}
}
