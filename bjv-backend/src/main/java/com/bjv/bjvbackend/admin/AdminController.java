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

@CrossOrigin("*")
@RestController
@RequestMapping("admin/auth")
public class AdminController {
	
	 @Autowired
	private AdminRepo adminRepo;
	
		@PostMapping("")
		public ResponseEntity<Map<String, Boolean>> Login(@RequestBody AdminModel admin){
			System.out.println(admin);

			AdminModel adminModel = adminRepo.findById(admin.getAdminId()).orElseThrow(() -> new ResourceNotFoundException("article not exist with id" + admin.getAdminId()));

			System.out.println(adminModel);
			
			
			Map<String, Boolean> response = new HashMap<String, Boolean>();
			
			System.out.println(adminModel.getPassword());
			System.out.println(admin.getPassword());
			
			if(adminModel.getPassword().equals(admin.getPassword())) {
				System.out.println("true");
				response.put("valid", true);
			}else {
				System.out.println("false");
				response.put("valid",false);
			}
			
			return ResponseEntity.ok(response);
		}
	
}