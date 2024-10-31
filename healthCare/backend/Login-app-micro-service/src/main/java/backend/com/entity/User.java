package backend.com.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {

	@Id
	@Column(name="email", length = 25, nullable = false)
	private String email;
	
	@Column(name="firstname", length = 25, nullable = false)
	private String firstname;
	
	@Column(name="lastname", length = 25, nullable = false)
	private String lastname;
	
	@Column(name="password", length = 25, nullable = false)
	private String password;
	
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="phonenumber", length = 10)
	private String phonenumber;
	
	@Column(name="address", length = 10)
	private String address;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="email", referencedColumnName = "email", insertable = false, updatable = false)
	private Login login;
}
