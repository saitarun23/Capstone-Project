package backend.com.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="medicineorderdetails")
public class Medicineorderdetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "modid")
	private int modid;
	
	@Column(name = "mid")
	private int mid;
	
	@Column(name = "medicinename")
	private String medicinename;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "emailid")
	private String emailid;
	
	@Column(name = "orderdate")
	private LocalDateTime orderdate;
	
	@ManyToOne
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	private Orderdetails orderdetails;
	
}
