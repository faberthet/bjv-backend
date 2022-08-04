package com.bjv.bjvbackend.articles;

import java.io.File;

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
}
