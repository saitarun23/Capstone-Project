package backend.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "login")
public class Login {

	@Id
	@Column(name="email", length = 25, nullable = false)
	private String email;
	
	@Column(name="password", length = 25, nullable = false)
	private String password;
	
	@Column(name="typeofuser", length = 25, nullable = false)
	private String typeofuser;
}
