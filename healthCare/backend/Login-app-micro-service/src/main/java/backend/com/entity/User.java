package backend.com.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {

	@Id
	@Column(name="email", length = 25)
	private String email;
	
	@Column(name="firstname", length = 25)
	private String firstname;
	
	@Column(name="lastname", length = 25)
	private String lastname;
	
	@Column(name="password", length = 25)
	private String password;
	
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="phonenumber", length = 10)
	private String phonenumber;
	
	@Column(name="address", length = 10)
	private String address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="email", referencedColumnName = "email", insertable = false, updatable = false)
	private Login login;
}
