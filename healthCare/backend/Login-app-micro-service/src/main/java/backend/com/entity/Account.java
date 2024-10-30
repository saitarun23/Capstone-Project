package backend.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {

	@Id
	@Column(name="accnumber")
	private int accnumber;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="emailid")
	private String emailid;
}
