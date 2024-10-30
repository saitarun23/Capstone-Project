package backend.com.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@Column(name="emailid")
	private String emailid;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="password")
	private String password;
	
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="phonenumber")
	private String phonenumber;
	
	@Column(name="address")
	private String address;
}
