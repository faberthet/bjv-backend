package com.bjv.bjvbackend.admin;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjv.bjvbackend.articles.ResourceNotFoundException;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("admin/auth")
public class AdminController {
	
	 @Autowired
	private AdminRepo adminRepo;
	
	@PostMapping("")
	public ResponseEntity<Map<String, String>> Login(@RequestBody AdminModel admin){
		System.out.println(admin);

		AdminModel adminModel = adminRepo.findById(admin.getAdminId()).orElseThrow(() -> new ResourceNotFoundException("article not exist with id" + admin.getAdminId()));

		System.out.println(adminModel);
		Map<String, String> response = new HashMap<>();
		response.put("user", adminModel.getAdminId());
		return ResponseEntity.ok(response);
	
	}
	
}
