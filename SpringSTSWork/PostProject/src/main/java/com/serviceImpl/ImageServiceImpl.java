package com.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.service.ImgService;
@Service
public class ImageServiceImpl implements ImgService{

	@Override
public String upload(String path, MultipartFile file) {
		
		String name = file.getOriginalFilename();
		
		String filename = System.currentTimeMillis()+"_"+name;
		String filepath = path+File.separator+filename;
		
		File f = new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		
		try {
			Files.copy(file.getInputStream(), Paths.get(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filename;
	}

	@Override
	public InputStream getImg(String path, String fileName) {
		// TODO Auto-generated method stub
		InputStream stream = null;
		
		
		try {
			String imgpath = path+File.separator+fileName;
			stream = new FileInputStream(imgpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stream;
	}

}
