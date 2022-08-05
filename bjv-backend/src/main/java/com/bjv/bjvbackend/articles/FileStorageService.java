package com.bjv.bjvbackend.articles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class FileStorageService {
	
	private String ImagePath=System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images";

	
	public void createImageFolder(Long id) {
		
		File file = new File(ImagePath + "\\" + id);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

	}
	
	private List<String> getFileNames(String htmlContent) {
		
		List<String> allMatches = new ArrayList<String>();
		Matcher m = Pattern.compile("<img src=\"(.*?)\"")
		    .matcher(htmlContent);
		while (m.find()) {
		  allMatches.add(m.group());
		}
		 
		List<String> allImgFileNames = new ArrayList<String>();
		 
	    for(String match : allMatches) { // a mettre dans le while...
	    	String[] tab= match.split("/");
	    	String fileName= tab[tab.length-1];
	    	allImgFileNames.add(fileName.substring(0, fileName.length() - 1));
	    }
	       
	    return allImgFileNames;    
	}
	
}
