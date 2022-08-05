package com.bjv.bjvbackend.articles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("http://localhost:4200")
public class ImageController {
	

	@PostMapping("upl")
	@CrossOrigin("http://localhost:4200")
	public Map<String, String> storeImage(@RequestParam MultipartFile upload, @RequestHeader(value="Image-Folder") Long imageFolder) throws IOException { // param file = nom de la key form-data
		
		String path=System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\" + imageFolder;
		//System.out.println(upload.getOriginalFilename());
		//System.out.println(upload.getName());
		//System.out.println(path);
		//System.out.println(System.getProperty("user.dir"));
		//System.out.println(imageFolder);
		
		Files.copy(upload.getInputStream(), Paths.get(path + File.separator + upload.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
		
		Map<String, String> response = new HashMap<>();
		response.put("url", "http://localhost:8080/images/"+imageFolder+"/"+upload.getOriginalFilename());
		return response;
	}
	
	
	@GetMapping("test")
	public void getFileNames() {
		
		 List<String> allMatches = new ArrayList<String>();
		 Matcher m = Pattern.compile("<img src=\"(.*?)\"")
		     .matcher("<img src=\"http://site.org/one.jpg\" />\n <img src=\"http://site.org/two.jpg\" />");
		 while (m.find()) {
		   allMatches.add(m.group());
		 }
		 
		 List<String> allImgFileNames = new ArrayList<String>();
		 
	       for(String match : allMatches) {
	    	   String[] tab= match.split("/");
	    	   String fileName= tab[tab.length-1];
	    	   allImgFileNames.add(fileName.substring(0, fileName.length() - 1));
	    	   //System.out.println(match.toString());
	        }
	       
	       for(String fileName : allImgFileNames) {
	    	   
	    	   System.out.println(fileName.toString());
	       }
	       
	       
	       
	       
	}

}
