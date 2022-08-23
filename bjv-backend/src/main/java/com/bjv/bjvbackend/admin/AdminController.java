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

@RestController
@RequestMapping("admin/auth")
@CrossOrigin("http://localhost:4200")
public class AdminController {
	
	 @Autowired
	private AdminRepo adminRepo;
	
	@PostMapping("")
	public ResponseEntity<Map<String, Boolean>> Login(@RequestBody AdminModel admin){
		System.out.println(admin);
		AdminModel adminModel = adminRepo.findByAdminId(admin.getAdminId());

		System.out.println(adminModel);
		
		Map<String, Boolean> response = new HashMap<>();
		
		if(adminModel!=null) {
			response.put("login", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		response.put("login", Boolean.FALSE);
		return ResponseEntity.ok(response);
		
	}
	
}
