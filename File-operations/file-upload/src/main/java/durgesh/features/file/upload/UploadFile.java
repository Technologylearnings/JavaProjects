package durgesh.features.file.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadFile {
	
	public final String UPLOAD_DIR="C:\\Users\\000R8P744\\Desktop\\JavaProjects\\file-upload\\src\\main\\resources\\static\\images";
//	DYNAMIC PATH
//	public final String UPLOAD_DIR=new ClassPathResource("static/images/").getFile().getAbsolutePath();
//	UploadFile()throws IOException
//	{
//		
//	}
	public boolean fileUpload(MultipartFile file)
	{
		boolean f=false;
		
		try {
//			//read content
//			InputStream is= file.getInputStream();
//			byte[] data=new byte[is.available()];
//			is.read(data);
//			
//			//write content
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
			
			Files.copy(file.getInputStream(), 
					Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), 
					StandardCopyOption.REPLACE_EXISTING);
			f=true;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return f;
		
	}

}
