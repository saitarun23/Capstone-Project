package backend.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.com.entity.Account;
import backend.com.entity.Login;
import backend.com.entity.User;
import backend.com.repository.AccountRepository;
import backend.com.repository.LoginRepository;
import backend.com.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	AccountRepository accountRepository;
	
	public String checkUserLogin(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmail());
		if(result.isPresent()) {
			Login ll =result.get();
			if(ll.getPassword().equals(login.getPassword())) {
				if(ll.getTypeofuser().equals(login.getTypeofuser()) && ll.getTypeofuser().equals("admin")) {
					return "Admin login successfully";
				}else if(ll.getTypeofuser().equals(login.getTypeofuser()) && ll.getTypeofuser().equals("user")) {
					return "User login successfully";
				}
				else {
					return "Type of user is invalid";
				}
			}else {
				return "Password is wrong";
			}
		}else {
			return "Emailid is wrong";
		}	
	}
	
	public String createAccount(User user) {
	    // Check if the email is unique
	    if (loginRepository.existsById(user.getEmail())) {
	        return "Email ID must be unique.";
	    }

	    // Create a Login entity with the "user" type
	    Login login = new Login();
	    login.setEmail(user.getEmail());
	    login.setPassword(user.getPassword());
	    login.setTypeofuser("user");

	    // Check if the account type is not "admin"
	    if ("admin".equalsIgnoreCase(login.getTypeofuser())) {
	        return "You can't create an admin account.";
	    }

	    // Save the login, user, and account records
	    loginRepository.save(login);
	    User savedUser = userRepository.save(user);

	    Account account = new Account();
	    account.setAmount(1000); // Initial amount for the account
	    account.setEmail(user.getEmail());
	    accountRepository.save(account);

	    if (savedUser != null) {
	        return "Account created successfully.";
	    } else {
	        return "Account creation failed.";
	    }
	}
}
