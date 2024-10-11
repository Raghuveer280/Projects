package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Entity.product;
import com.example.demo.Entity.userdata;
import com.example.demo.Entity.vegetables;
import com.example.demo.Service.ImageUploadService;
import com.example.demo.Service.ProService;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.UserService;
import com.example.demo.Entity.Grains;
import com.example.demo.Entity.cart;
import com.example.demo.Entity.flower;
import com.example.demo.Entity.mimosa;
import com.example.demo.Entity.organic;
import com.example.demo.Entity.plants;

@Controller
public class AppController {
	
	@Autowired
	ProductService pserve;
	
	@Autowired
	ImageUploadService imgService;
	@GetMapping("/home")
	public String home(Model m) {
		m.addAttribute("count", 0);
		return "home";
	}
	
	@Autowired
	ProService proservice;
	@GetMapping ("/showcart")
	public String showcart(Model m)
	{
		m.addAttribute("info", proservice.show());
		return "newcart";
	}
	@PostMapping("/add")
	public String add(@RequestParam int id,@RequestParam int qty,Model m)
	{
		product p= proservice.search(id);
		cart c=new cart(p.getId(),p.getName(),p.getPrice(),qty);
		proservice.insert(c);
		Iterable<cart>t=proservice.show();
		int count=0;
		for(cart a:t)
		{
			count++;
		}
		m.addAttribute("count", count);
		return "home";
	}
	@GetMapping("/newcart")
	public String newcart() {
		return "newcart";
	}
	
	@PostMapping("/uploadres")
	public String uploadres(@RequestParam String name,@RequestParam int price,@RequestParam int quantity,@RequestParam String category,@RequestParam MultipartFile file,Model m)
	{
		switch(category) {
		
		case "vegetables":
			vegetables v=new vegetables();
			v.setName(name);
			v.setPrice(price);
			v.setQuantity(quantity);
			String fv=file.getOriginalFilename();
			v.setPicurl(fv);
			vegetables veg=pserve.insertVeg(v);
			if(veg!=null) {
			String msg=imgService.imageUpload(file);
			m.addAttribute("msg", msg);
		}
			break;
		
		case "grains":
			Grains g=new Grains();
			g.setName(name);
			g.setPrice(price);
			g.setQuantity(quantity);
			String fg=file.getOriginalFilename();
			g.setPicurl(fg);
			Grains gr=pserve.insertGrains(g);
			if(gr!=null) {
			String msg=imgService.imageUpload(file);
			m.addAttribute("msg", msg);
		}
			break;
			
		case "plants":
			plants p=new plants();
			p.setName(name);
			p.setPrice(price);
			p.setQuantity(quantity);
			String fp=file.getOriginalFilename();
			p.setPicurl(fp);
			plants plants=pserve.insertPlants(p);
			if(plants!=null) {
			String msg=imgService.imageUpload(file);
			m.addAttribute("msg", msg);
		}
			break;	
			
		case "flowers":
			flower f=new flower();
			f.setName(name);
			f.setPrice(price);
			f.setQuantity(quantity);
			String ff=file.getOriginalFilename();
			f.setPicurl(ff);
			flower fr=pserve.insertFlower(f);
			if(fr!=null) {
			String msg=imgService.imageUpload(file);
			m.addAttribute("msg", msg);
		}
			break;
			
		case "organic":
			organic o=new organic();
			o.setName(name);
			o.setPrice(price);
			o.setQuantity(quantity);
			String fo=file.getOriginalFilename();
			o.setPicurl(fo);
			organic or=pserve.insertOrganic(o);
			if(or!=null) {
			String msg=imgService.imageUpload(file);
			m.addAttribute("msg", msg);
		}
			break;
			
		case "Mimosa":
			mimosa mimosa=new mimosa();
			mimosa.setName(name);
			mimosa.setPrice(price);
			mimosa.setQuantity(quantity);
			String fm=file.getOriginalFilename();
			mimosa.setPicurl(fm);
			mimosa ma=pserve.insertMimosa(mimosa);
			if(ma!=null) {
			String msg=imgService.imageUpload(file);
			m.addAttribute("msg", msg);
		}
			break;
		}
		return "index";
	}
	
	@GetMapping("/showVeg")
	public String show(Model m) {
		m.addAttribute("records", pserve.showAllVeg());
		return "Vegetables";
	}
	
	@GetMapping("/showGrains")
	public String showGrains(Model m) {
		m.addAttribute("records", pserve.showAllGrains());
		return "grains";
	}
	
	@GetMapping("/showPlants")
	public String showPlants(Model m) {
		m.addAttribute("records", pserve.showAllPlants());
		return "plants";
	}
	
	@GetMapping("/showFlowers")
	public String showFlowers(Model m) {
		m.addAttribute("records", pserve.showAllFlowers());
		return "flower";
	}
	
	@GetMapping("/showOrganic")
	public String showOrganic(Model m) {
		m.addAttribute("records", pserve.showAllOrganics());
		return "organic";
	}
	
	@GetMapping("/showMimosa")
	public String showMimosa(Model m) {
		m.addAttribute("records", pserve.showAllGrains());
		return "mimosa";
	}
	
	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "aboutus";
	}
	
	@GetMapping("/contactUs")
	public String contactUs() {
		return "contactus";
	}
	
	@GetMapping("/privacy")
	public String privacy() {
		return "privacy policy";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,Model m )
	{
		proservice.delete(id);
		m.addAttribute("info",proservice.show());
		return "newcart";
	}
	@GetMapping("/deleteVeg/{name}")
	public String delete(@PathVariable String name,Model m )
	{
		pserve.deleteVeg(name);
		m.addAttribute("record1",pserve.showAllVeg());
		return "delete";
	}
	
	@Autowired
	UserService userservice;
	@PostMapping("/loginres")
	public String loginres(@RequestParam String username,@RequestParam String email,@RequestParam String pw,Model m)
	{
		
		List<userdata> s=userservice.search(username,pw);
		if(username.equals("admin") && pw.equals("1234"))
			return "index";
		else if(s.isEmpty())
		{
			m.addAttribute("msg", "Invalid Username or password!!");
			return "login";
		}
		else
		{
			m.addAttribute("count", 0);
			return "home";
		}
	}
	@PostMapping("/signupres")
	public String signupres(@RequestParam String username,@RequestParam String email,@RequestParam String pw,Model m)
	{
		userdata u=new userdata(username,email,pw);
		userdata newuser=userservice.create(u);
		if(newuser!=null)
			{
				m.addAttribute("msg", "Account Created!!..Now, Login with Credentials ") ;
				return "login";
			}
		else
			{
			m.addAttribute("msg", "Sorry Can't procees your request!") ;
			return "signup";
			}
	}
	@GetMapping ("/")
	public String login()
	{
		return "login";
	}
	@GetMapping ("/signup")
	public String signup()
	{
		return "signup";
	}
	@GetMapping("/payment")
	public String payment() {
		return "payment";
	}
	@GetMapping("/showdelete")
	public String showdelete(Model m) {
		m.addAttribute("record1", pserve.showAllVeg());	
		return "delete";
	}
	
}
