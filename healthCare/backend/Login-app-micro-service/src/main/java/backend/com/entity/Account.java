package backend.com.entity;

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
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="accnumber")
	private int accnumber;
	
	@Column(name="amount", nullable = false,columnDefinition = "int default 1000")
	private float amount=1000;
	
	@Column(name = "email", length = 25, nullable = false)
    private String email;
	
	@ManyToOne
	@JoinColumn(name="email",referencedColumnName = "email", insertable = false, updatable = false)
	private User user;
}
