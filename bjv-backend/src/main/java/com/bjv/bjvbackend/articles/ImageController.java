package com.bjv.bjvbackend.articles;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@CrossOrigin("*")
@RestController
public class ImageController {
	
	@Value("${aws-bucket}")
	private String bucketname;
	
	@Value("${aws-storage-url}")
	private String storageUrl;
	
	@Autowired
	private AmazonS3 s3Client;
	
	@PostMapping("upl")
	public Map<String, String> storeImage(@RequestParam MultipartFile upload, @RequestHeader(value="Image-Folder") Long imageFolder) throws IOException { // param file = nom de la key form-data
		
		s3Client.putObject(new PutObjectRequest(bucketname,"images/"+imageFolder+"/"+upload.getOriginalFilename(),upload.getInputStream(), null ));
		
		Map<String, String> response = new HashMap<>();
		
		response.put("url", storageUrl+"/images/"+ imageFolder +"/"+upload.getOriginalFilename());
		
		System.out.println(response.get("url"));

		return response;
	}

	/*@PostMapping("upl")
	@CrossOrigin("http://localhost:4200")
	public Map<String, String> storeImage(@RequestParam MultipartFile upload, @RequestHeader(value="Image-Folder") Long imageFolder) throws IOException { // param file = nom de la key form-data
		
		//String path=System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\" + imageFolder;
		String path=System.getProperty("user.dir") + "\\target\\classes\\static\\images\\" + imageFolder;

		//System.out.println(upload.getOriginalFilename());
		//System.out.println(upload.getName());
		//System.out.println(path);
		//System.out.println(System.getProperty("user.dir"));
		//System.out.println(imageFolder);
		
		Files.copy(upload.getInputStream(), Paths.get(path + File.separator + upload.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
		
		//byte[] data= upload.getBytes();
		//Path path1=Paths.get(path);
		//Files.write(path1, data);
		
		Map<String, String> response = new HashMap<>();
		response.put("url", "http://localhost:8080/images/"+ imageFolder +"/"+upload.getOriginalFilename());
		System.out.println(response.get("url"));

		return response;
	}*/
	

}
