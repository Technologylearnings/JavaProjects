package JavaTechie.db.file.upload.download;
import durgesh.features.hibernate.mappings.Laptop;
import durgesh.features.hibernate.mappings.Student;
import durgesh.features.hibernate.mappings.StudentDao;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import durgesh.features.hibernate.mappings.Student;

@SpringBootApplication
@RestController
public class FileUploadDownloadApplication {
	
	@Autowired
	StorageService storageService;
	
	@PostMapping("/fileupload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException
	{
		String fileUpload = storageService.fileUpload(file);
		return ResponseEntity.status(HttpStatus.OK).body(fileUpload);	
	}
	
	@GetMapping("/filedownload/{file}")
	public ResponseEntity<?> downloadFile(@PathVariable("file") String file) throws IOException
	{
		byte[] fileDownload = storageService.fileDownload(file);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpeg")).body(fileDownload);	
	}
	public static void main(String[] args) {
		SpringApplication.run(FileUploadDownloadApplication.class, args);
	}
	
	////////////////////////////////////////////////////////////////////////
//	@Autowired
//	StudentDao dao;
//	
//	Student s=new Student("archana");
//	Student s2=new Student("arpita");
//	
//	Laptop l=new Laptop("Dell");
//	Laptop l2=new Laptop("HP");
//	
//	dao.save(s);

	

}
