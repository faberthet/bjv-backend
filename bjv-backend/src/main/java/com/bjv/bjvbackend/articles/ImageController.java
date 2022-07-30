package com.bjv.bjvbackend.articles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("http://localhost:4200")
public class ImageController {
	
	
	/*@PostMapping("file")
	public String storeFile(@RequestParam("file") MultipartFile file) throws IOException { // param file = nom de la key form-data
		
		String path=System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images";
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getName());
		System.out.println(path);
		System.out.println(System.getProperty("user.dir"));
		
		Files.copy(file.getInputStream(), Paths.get(path + File.separator + file.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
		return "coucou";
	}*/
	
	@PostMapping("upl")
	@CrossOrigin("http://localhost:4200")
	public Map<String, String> storeImage(@RequestParam MultipartFile upload) throws IOException { // param file = nom de la key form-data
		
		String path=System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images";
		System.out.println(upload.getOriginalFilename());
		System.out.println(upload.getName());
		System.out.println(path);
		System.out.println(System.getProperty("user.dir"));
		
		Files.copy(upload.getInputStream(), Paths.get(path + File.separator + upload.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
		
		Map<String, String> response = new HashMap<>();
		response.put("url", "localhost:8080/images/"+upload.getOriginalFilename());
		return response;
	}
	
	@GetMapping("test")
	public void test() {
		
		System.out.println("testdfsdfsdfgfdgf");
	}

}
