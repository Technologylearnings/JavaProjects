package JavaTechie.db.file.upload.download;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ImageData")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class ImageData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String type;
	
	//to store BINARY FORMAT in DB
	@Lob
	@Column(name="data",length=1000)
	private byte[] imagedata;

//	public ImageData() {
//	}
//
//	public ImageData(Long id, String name, String type, byte[] imagedata) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.type = type;
//		this.imagedata = imagedata;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public byte[] getImagedata() {
//		return imagedata;
//	}
//
//	public void setImagedata(byte[] imagedata) {
//		this.imagedata = imagedata;
//	}

	
	

}
