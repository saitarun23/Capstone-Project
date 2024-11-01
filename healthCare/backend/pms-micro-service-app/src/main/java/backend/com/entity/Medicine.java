package backend.com.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	
	@Column(name="medicinename")
	private String medicinename;
	
	@Column(name="companyname")
	private String companyname;
	
	@Column(name="price")
	private float price;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="uses")
	private String uses;
	
	@Column(name="expiredate")
	private LocalDate expiredate;
	
	@Column(columnDefinition = "blob")
	private String imageurl;
}
