package com.bluewind.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadController {

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile() throws IOException {
		String filename = "/var/tmp/1.png";
		//String filename = "/var/tmp/mylog.log";
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		/*
		 * Http header setting is important for download
		 * 
		 * The combination of Content-Disposition and Content-Type will decide whether to download or show the content in browser.
		 * 
		 * For example,
		 * 
		 * Content-Type: application/octet-stream
			Content-Disposition: attachment; filename="picture.png"
			Means "I don't know what the hell this is. Please save it as a file, preferably named picture.png".
			
			Content-Type: image/png
			Content-Disposition: attachment; filename="picture.png"
			Means "This is a PNG image. Please save it as a file, preferably named picture.png".
			
			Content-Type: image/png
			Content-Disposition: inline; filename="picture.png"
			Means "This is a PNG image. Please display it unless you don't know how to display PNG images. Otherwise, or if the user chooses to save it, we recommend the name picture.png for the file you save it as".
					
			Refer to: https://stackoverflow.com/questions/20508788/do-i-need-content-type-application-octet-stream-for-file-download
			
			
			If you want to download file using Postman, please select "Send and Download" instead of "Send".
		 *
		 */
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		//headers.add("Content-Disposition", String.format("inline; filename=\"%s\"", file.getName()));	
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		
		//content-type MediaType.APPLICATION_OCTET_STREAM works for both binary file and text file.
		//content-type application/txt also works for both binary file and text file.
		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
				//.contentType(MediaType.IMAGE_PNG).body(resource);
				//.contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}
}
