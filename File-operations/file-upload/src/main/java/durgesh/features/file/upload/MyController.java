package durgesh.features.file.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class MyController {
	
	@Autowired
	private UploadFile uf;
	
	@PostMapping("/fileupload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		//Check if file is empty
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("File is not present");
		}
		
		//check format of file
		if(!file.getContentType().equals("image/jpeg"))
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Only JPEG format is supported");
		}
		
		//upload file code
		//Path to upload the file
		boolean res = uf.fileUpload(file);
		if(res)
		{
			return ResponseEntity.ok("File uploaded successfully");
			//DYNAMIC
			//return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath()
			//		.path("/images/").path(file.getOriginalFilename()).toUriString());
		}
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("SOME ERROR OCCURRED!!!");
		
	}

}
