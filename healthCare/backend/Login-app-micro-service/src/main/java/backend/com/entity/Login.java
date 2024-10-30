package backend.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Login {

	@Id
	@Column(name = "emailid")
	private String emailid;
	@Column(name = "password")
	private String password;
	@Column(name = "typeofuser")
	private String typeofuser;
}
