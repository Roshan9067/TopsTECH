package com.service;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface ImgService {
	
	public String upload(String path,MultipartFile file);
	public InputStream getImg(String path, String fileName);

}
