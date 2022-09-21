package com.bjv.bjvbackend.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public class S3StorageService  {
	
	@Value("${aws-bucket}")
	private String bucketname;
	
	@Autowired
	private AmazonS3 s3Client;
	
	/*
	 * retourne la liste des noms des images utilisé dans le contenu html
	 */
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
	
	/*
	 * Suprime les fichiers images non utilisés du dossier de stockage de l'article
	 */
	public void deleteUnusedFiles(Long id, String htmlContent) {
		
		List<String> allImgNamesinHtml = getFileNames(htmlContent);
		
		ObjectListing listing = s3Client.listObjects(bucketname, "images/"+id);
		
		List<String> allKeys = new ArrayList<String>();
		 
	    for(S3ObjectSummary file : listing.getObjectSummaries()) {  
	    	String[] tab= file.getKey().split("/");
	    	String fileName= tab[tab.length-1];
	    	System.out.println(fileName);
	    	allKeys.add(fileName);//???
	    }
	    
		    for (String key : allKeys ) {
		        if(!allImgNamesinHtml.contains(key)) {
		        	s3Client.deleteObject(bucketname, "images/"+id+"/"+key);
		        }
		    }
	}
	
	
	public void deleteFolder(Long id) throws IOException {
		
		ObjectListing listing = s3Client.listObjects(bucketname, "images/"+id);
		
		List<String> allKeys = new ArrayList<String>();
		 
	    for(S3ObjectSummary file : listing.getObjectSummaries()) {  
	    	String[] tab= file.getKey().split("/");
	    	String fileName= tab[tab.length-1];
	    	System.out.println(fileName);
	    	allKeys.add(fileName);//???
	    }
	    
		    for (String key : allKeys ) {
		        	s3Client.deleteObject(bucketname, "images/"+id+"/"+key);
		    }
	}
	
}
