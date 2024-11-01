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
	
	@Column(name = "")
	private int mid;
	
	@Column(name = "")
	private String medicinename;
	
	@Column(name = "")
	private float price;
	
	@Column(name = "")
	private int quantity;
	
	@Column(name = "")
	private String emailid;
	
	@Column(name = "")
	private LocalDateTime orderdate;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Orderdetails orderdetails;
	
}
