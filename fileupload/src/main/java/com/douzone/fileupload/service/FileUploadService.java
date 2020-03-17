package com.douzone.fileupload.service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileUploadService {

	private static final String SAVE_PATH = "/mysite-uploads";
	private static final String URL = "/images";
	
	public String restore(MultipartFile multipartFile) {
		
		String url = "";
		
		try {
			if(multipartFile.isEmpty()) {
				return url;
			}
			
			String originFilename = multipartFile.getOriginalFilename();
			
			int lastIdx = originFilename.lastIndexOf('.');
			String extName = originFilename.substring(lastIdx+1);
			
			String saveFilename = generateSaveFilename(extName);
			long fileSize = multipartFile.getSize();
			
			System.out.println("#############"+originFilename);
			System.out.println("#############"+saveFilename);
			System.out.println("#############"+fileSize);
			
			byte[] fileDate = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH+"/"+saveFilename);
			os.write(fileDate);
			os.close();
			
			
			url = URL+"/"+saveFilename;
			
		}catch(Exception e) {
			throw new RuntimeException("file upload error : "+e);
		}
		
		return url;
	}

	private String generateSaveFilename(String extName) {
		
		String fileName = "";
		
		Calendar calendar = Calendar.getInstance();
		
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);	
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("."+extName);
				
				
		
		return fileName;
	}
	
}

























