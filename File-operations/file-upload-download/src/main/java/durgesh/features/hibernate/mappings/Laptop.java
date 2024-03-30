package durgesh.features.hibernate.mappings;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Laptop {
	
	@Id
	@GeneratedValue
	private int id;
	private String brand;	
	
	@OneToOne
	@JoinColumn(name="student_id")
	private Student stu;
	
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Laptop() {
	}
	public Laptop(String brand) {
		super();
		
		this.brand = brand;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	

}
