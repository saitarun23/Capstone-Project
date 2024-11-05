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
	
	public String SignIn(Login login) {
		Optional<Login> result=loginRepository.findById(login.getEmail());
		if(result.isPresent()) {
			Login ll=result.get();
			if(ll.getPassword().equals(login.getPassword())) {
				if(ll.getTypeofuser().equals("admin") && login.getTypeofuser().equals("admin")) {
					return "Admin login successfully";
				}else if(ll.getTypeofuser().equals("user") && login.getTypeofuser().equals("user")) {
					return "Customer login successfully";
				}else {
					return "type of user wrong";
				}
			}else {
				return "Password is wrong";
			}
		}else {
			return "EmailId is wrong";
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
