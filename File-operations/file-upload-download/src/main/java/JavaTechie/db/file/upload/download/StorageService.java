package JavaTechie.db.file.upload.download;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

	@Autowired
	StorageRepository repo;
	
	//ImageData imageData;
	
//	StorageService(ImageData img)
//	{
//		this.imageData=img;
//	}
	
	public String fileUpload(MultipartFile file) throws IOException
	{
		ImageData data = repo.save(ImageData.builder().name(file.getOriginalFilename())
				.type(file.getContentType())
				.imagedata(ImageUtils.compressImage(file.getBytes())).build());
		
		if(data!=null) {
			return "File uploaded successfully : "+file.getOriginalFilename();
		}
		return null;
		
	
	}
	
	public byte[] fileDownload(String file) 
	{
		Optional<ImageData> data = repo.findByName(file);
		byte[] decompressImage = ImageUtils.decompressImage(data.get().getImagedata());
		return decompressImage;
		
	
	}
}
