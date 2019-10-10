package com.imfsoftware.springboot.jwt;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imfsoftware.springboot.jwt.auth.UserRepository;
import com.imfsoftware.springboot.jwt.blog.BlogEntryRepository;
import com.imfsoftware.springboot.jwt.blog.BlogEntry;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BlogEntryRepository blogRepo;

	public AppController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@GetMapping({ "/", "/index" })
	public String getHomePage(Model model) {
		List<BlogEntry> entries = blogRepo.findAll();
		if (entries.size() == 0) {
			BlogEntry entry = new BlogEntry();
			entry.setTitle("First Entry");
			entry.setPost("This is my first fake post.");
			entries.add(entry);
			BlogEntry entry2 = new BlogEntry();
			entry2.setTitle("Second Entry");
			entry2.setPost("This is my second fake post.");
			entries.add(entry2);
		}
		model.addAttribute("posts", entries);
		return "index";
	}

	@GetMapping("/login")
	public String getLogin(Model model) {
		return "login";
	}

	@GetMapping("/signup")
	public String getSignup(Model model) {
		return "signup";
	}

	@GetMapping("/logout-success")
	public String getLogout(Model model) {
		return "index";
	}

	@PostMapping(path = "/signup")
	public String postSignup(@ModelAttribute @Valid Signup signup) {
		System.out.println(signup.toUser().toString());
		if (signup.comparePasswords()) {
			userRepo.save(signup.toUser());
			userRepo.findAll().forEach(System.out::println);
			return "index";
		} else {
			return "error";
		}
	}
//	
//	@GetMapping("/posts")
//	public String getPosts(Model model)
//	{
//		List<BlogEntry> entries = blogRepo.findAll();
//		if (entries.size() == 0) {
//			BlogEntry entry = new BlogEntry();
//			entry.setTitle("First Entry");
//			entry.setPost("This is my first fake post.");
//			entries.add(entry);
//		}
//		model.addAttribute("posts", entries);
//		return "posts";
//	}
}
