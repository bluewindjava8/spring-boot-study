package com.bluewind.file;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FilerUploadController {
	
	/*
	 * https://www.tutorialspoint.com/spring_boot/spring_boot_file_handling.htm
	 * 
	 * About how to upload a file using Postman, refer to the link below:
	 * https://dev.to/wiaio/upload-a-file-to-wia-via-postman-55ic
	 * 
	 * In Spring MVC, "request parameters" map to query parameters, form data,
	 * and parts in multipart requests. This is because the Servlet API combines
	 * query parameters and form data into a single map called "parameters", and
	 * that includes automatic parsing of the request body. --From @RequestParam javadoc
	 */

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	//@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("file") MultipartFile file) throws Exception{
		File convertFile = new File("/var/tmp/" + file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return "File is uploaded successfully.";
	}
}
