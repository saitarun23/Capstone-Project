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
			Login storedLogin =result.get();
			
			if (!storedLogin.getTypeofuser().equals(login.getTypeofuser())) {
	            return "Type of user is invalid"; 
	        }

	        // Step 2: Check if password matches
	        if (!storedLogin.getPassword().equals(login.getPassword())) {
	            return "Password is incorrect";
	        }

	        // Step 3: Check specific user type and return a corresponding message
	        if (storedLogin.getTypeofuser().equals("admin")) {
	            return "Admin login successful";
	        } else if (storedLogin.getTypeofuser().equals("user")) {
	            return "User login successful";
	        } else {
	            return "Invalid user type";
	        }
	    } else {
	        return "Email is incorrect";
		}
	}
	
	public String createAccount(User user,String typeofuser) {
	    Login login = new Login();
	    login.setEmail(user.getEmail());
	    login.setPassword(user.getPassword());
	    login.setTypeofuser(typeofuser);

	    if (login.getTypeofuser().equals("admin")) {
	        return "You can't create admin login";
	    }

	    Optional<Login> existingLogin = loginRepository.findById(login.getEmail());
	    if (existingLogin.isPresent()) {
	        return "Account already exists";
	    } 
	        
	        loginRepository.save(login);
	        userRepository.save(user);

	        Account account = new Account();
	        account.setAmount(1000); 
	        account.setEmail(user.getEmail());
	        accountRepository.save(account);
	       
	        return "Account created successfully";

	    }
}
