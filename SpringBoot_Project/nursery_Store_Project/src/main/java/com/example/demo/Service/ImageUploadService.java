package com.example.demo.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageUploadService {
	public String imageUpload(MultipartFile file)
	{
		try {
			String uploadurl="src/main/resources/static/uploads";
			Path path=Paths.get(uploadurl+File.separator+file.getOriginalFilename());
			Files.copy(file.getInputStream(), path);
			return "Image Uploaded";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Unable to Upload";
		}
	}
}